package com.xiaowei.service.authority;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.AclReq;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.common.util.LevelUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.mapper.dataobject.SelfAclDO;
import com.xiaowei.mapper.mapper.authority.AclMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 */
@Service
@Slf4j
public class AclServiceImpl implements AclService {
    @Autowired
    private AclMapper aclMapper;

    @Transactional
    @Override
    public JSONResult insertSelective(AclReq aclReq, RedisUser redisUser) {
        if (checkUrl(aclReq.getSysAclUrl(), aclReq.getSysAclModuleType(), null)) {
            return JSONResult.errorMap("url重复");
        }
        SelfAclDO record = new SelfAclDO();
        BeanUtils.copyProperties(aclReq, record);
        record.setSysAclModuleLevel(LevelUtil.calculateLevel(getLevel(aclReq.getSysAclModuleParentId()), aclReq.getSysAclModuleParentId()));
        record.setCreateBy(redisUser.getSysUserName());
        record.setUpdateBy(redisUser.getSysUserName());
        record.setCreateTime(DateUtil.getDateTime());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setSysAclUuid(StrUtil.genUUID());
        aclMapper.insertSelective(record);
        return JSONResult.ok("新增权限成功");
    }

    @Transactional
    @Override
    public JSONResult updateByPrimaryKeySelective(AclReq aclReq, RedisUser redisUser) {
        SelfAclDO before = aclMapper.selectByPrimaryUuid(aclReq.getSysAclUuid());
        if (null == before) {
            return JSONResult.errorMap("待编辑的权限不存在");
        }
        if (before.getId().equals(aclReq.getSysAclModuleParentId())) {
            return JSONResult.ok("无法将当前模块挂在自己模块下");
        }
        if (!before.getSysAclModuleType().equals(aclReq.getSysAclModuleType())) {
            return JSONResult.errorMap("无法跨模块编辑");
        }
        if (checkUrl(aclReq.getSysAclUrl(), aclReq.getSysAclModuleType(), before.getId())) {
            return JSONResult.errorMap("url重复");
        }
        SelfAclDO after = new SelfAclDO();
        BeanUtils.copyProperties(aclReq, after);
        after.setSysAclModuleLevel(LevelUtil.calculateLevel(getLevel(aclReq.getSysAclModuleParentId()), aclReq.getSysAclModuleParentId()));
        after.setUpdateBy(redisUser.getSysUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        after.setId(before.getId());
        updateWithChild(before, after);

        return JSONResult.ok("编辑权限成功");
    }

    @Override
    public JSONResult updateStatus(AclReq aclReq, RedisUser redisUser) {
        SelfAclDO selfAclDO = aclMapper.selectByPrimaryUuid(aclReq.getSysAclUuid());
        if (null == selfAclDO) {
            return JSONResult.errorMap("待编辑的权限不存在");
        }
        SelfAclDO record = new SelfAclDO();
        //状态 0启用  1禁用
        if ("0".equals(aclReq.getSysAclState())) {
            record.setSysAclState("1");
        } else if ("1".equals(aclReq.getSysAclState())) {
            record.setSysAclState("0");
        }
        record.setUpdateBy(redisUser.getSysUserName());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setId(selfAclDO.getId());
        aclMapper.updateByPrimaryKeySelective(record);
        return JSONResult.ok("更新权限状态成功");
    }
    @Transactional
    private void updateWithChild(SelfAclDO before, SelfAclDO after) {
        String newLevelPrefix = after.getSysAclModuleLevel();
        String oldLevelPrefix = before.getSysAclModuleLevel();
        List<SelfAclDO> aclModuleList = null;
        if (!after.getSysAclModuleLevel().equals(before.getSysAclModuleLevel())) {
            aclModuleList = aclMapper.getChildAclModuleListByLevel(LevelUtil.calculateLevel(before.getSysAclModuleLevel(), before.getId()));
            if (CollectionUtils.isNotEmpty(aclModuleList)) {
                for (SelfAclDO aclModule : aclModuleList) {
                    String level = aclModule.getSysAclModuleLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        aclModule.setSysAclModuleLevel(level);
                    }
                }
                aclMapper.batchUpdateLevel(aclModuleList);

            }
        }
        after.setSysAclModuleType(null);
        aclMapper.updateByPrimaryKeySelective(after);
    }
    private boolean checkUrl(String url, Long moduleType, Long id) {
        return aclMapper.checkUrl(url, moduleType, id) > 0 ? true : false;
    }
    private String getLevel(Long aclModuleId) {
        SelfAclDO aclModule = aclMapper.selectByPrimaryKey(aclModuleId);
        if (aclModule == null) {
            return null;
        }
        return aclModule.getSysAclModuleLevel();
    }
}
