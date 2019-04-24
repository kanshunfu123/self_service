package com.xiaowei.service.user;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xiaowei.common.common.DateUtils;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.config.JwtProperties;
import com.xiaowei.common.error.RedisKeyEnum;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.user.InserUserReq;
import com.xiaowei.common.req.user.PassWordReq;
import com.xiaowei.common.res.user.SysUserRes;
import com.xiaowei.common.res.user.UserPageRes;
import com.xiaowei.common.util.Encrypt;
import com.xiaowei.common.util.JwtTokenUtil;
import com.xiaowei.common.util.RedisUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.mapper.dao.SelfUserDAO;
import com.xiaowei.mapper.dataobject.SelfRoleDO;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import com.xiaowei.mapper.dataobject.SelfUserDO;
import com.xiaowei.mapper.mapper.authority.RoleMapper;
import com.xiaowei.mapper.mapper.req.UserPage;
import com.xiaowei.mapper.mapper.req.UserPageReq;
import com.xiaowei.mapper.mapper.roleuser.RoleUserMapper;
import com.xiaowei.mapper.mapper.user.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by kanshunfu on 2019/4/11.
 */
@Service
@Transactional
@Slf4j
public class UsersService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleUserMapper roleUserMapper;
    @Autowired
    private SelfUserDAO selfUserDAO;

    public JSONResult insertUser(InserUserReq inserUserReq, RedisUser redisUser) {
        //新增用户
        int loginName = sysUserMapper.userLoginCout(inserUserReq.getULoginName(), null, null);
        if (loginName > 0) {
            return JSONResult.errorMap("登录名已存在");
        }
        int phone = sysUserMapper.userLoginCout(null, inserUserReq.getUPhone(), null);
        if (phone > 0) {
            return JSONResult.errorMap("手机号已存在");
        }
        SelfRoleDO selfRoleDO = roleMapper.getRoleById(inserUserReq.getRoleId());
        if (selfRoleDO == null) {
            return JSONResult.errorMap("角色信息不存在");
        }
        SelfUserDO selfUserDO = new SelfUserDO();
        BeanUtils.copyProperties(inserUserReq, selfUserDO);
        final String randomKey = jwtTokenUtil.getRandomKey();
        selfUserDO.setUAuthSalt(randomKey);
        String pwd = Encrypt.getShiroPassword(inserUserReq.getSysUserPwd(), selfUserDO.getUAuthSalt(), 5);
        selfUserDO.setULoginName(inserUserReq.getULoginName().trim());
        selfUserDO.setCompId(redisUser.getGroupId());
        selfUserDO.setUuid(StrUtil.genUUID());
        selfUserDO.setULoginPwd(pwd);
        selfUserDO.setCreateBy(redisUser.getSysUserName());
        selfUserDO.setUpdateBy(redisUser.getSysUserName());
        selfUserDO.setCreateTime(DateUtils.getCurrentDateTime());
        selfUserDO.setUpdateTime(DateUtils.getCurrentDateTime());
        selfRoleDO.setDelFlag("0");
        sysUserMapper.insertUser(selfUserDO);
        List<SelfRoleUserDO> selfRoleUserDOList = Lists.newArrayList();
        SelfRoleUserDO selfRoleUserDO = new SelfRoleUserDO();
        selfRoleUserDO.setCompId(selfRoleDO.getCompId());
        selfRoleUserDO.setRoleId(selfRoleDO.getId());
        selfRoleUserDO.setCreateTime(DateUtils.getCurrentDateTime());
        selfRoleUserDO.setUserId(selfUserDO.getId());
        selfRoleUserDOList.add(selfRoleUserDO);
        roleUserMapper.batchaddRoleUser(selfRoleUserDOList);
        saveRedisUser(selfUserDO);
        saveRedisRoleUser(Lists.newArrayList(selfRoleDO.getId()), selfUserDO.getId());
        return JSONResult.ok("新增用户成功");
    }

    private void saveRedisRoleUser(List<Long> redisRoleUsers, Long userId) {
        if (org.apache.commons.collections.CollectionUtils.isEmpty(redisRoleUsers)) {
            redisUtil.del(RedisKeyEnum.REDIS_USER_ROLE_INFO.getKey() + userId);
            return;
        }
        redisUtil.set(RedisKeyEnum.REDIS_USER_ROLE_INFO.getKey() + userId, JSONObject.toJSONString(redisRoleUsers));
    }

    /**
     * 根据uuid查询用户
     *
     * @param modifyUserReq
     * @return
     */
    public JSONResult getUserByUUID(InserUserReq modifyUserReq) {
        SelfUserDO userDOa = sysUserMapper.getUserByUUID(modifyUserReq.getUuid());
        if (null == userDOa) {
            return JSONResult.errorMap("待查询的用户不存在");
        }
        List<SelfRoleDO> roleDOS = roleMapper.getRolesByUserId(userDOa.getId());
        userDOa.setULoginPwd("");
        userDOa.setId(null);
        SysUserRes sysUserRes = new SysUserRes();
        BeanUtils.copyProperties(userDOa, sysUserRes);
        if (!CollectionUtils.isEmpty(roleDOS)) {
            sysUserRes.setRoleId(roleDOS.get(0).getId());
        }
        return JSONResult.ok(sysUserRes);
    }

    //编辑用户
    public JSONResult editUser(InserUserReq modifyUserReq, RedisUser redisUser) {
        SelfUserDO userDOa = sysUserMapper.getUserByUUID(modifyUserReq.getUuid());
        if (null == userDOa) {
            return JSONResult.errorMap("待编辑的用户不存在");
        }
        SelfRoleDO roleDO = roleMapper.getRoleById(modifyUserReq.getRoleId());

        int phone = sysUserMapper.userLoginCout(null, modifyUserReq.getUPhone(), userDOa.getId());
        if (phone > 0) {
            return JSONResult.errorMap("手机号已存在");
        }
        if (roleDO == null) {
            return JSONResult.errorMap("角色信息不存在");
        }


        SelfUserDO userDO = new SelfUserDO();
        BeanUtils.copyProperties(modifyUserReq, userDO);
        userDO.setCreateBy(redisUser.getSysUserName());
        userDO.setUpdateBy(redisUser.getSysUserName());
        userDO.setId(userDOa.getId());
        userDO.setCreateTime(DateUtils.getCurrentDateTime());
        userDO.setUpdateTime(DateUtils.getCurrentDateTime());
        userDO.setULoginName(null);
        userDO.setULoginPwd(null);
        userDO.setUAuthSalt(null);
        int i = sysUserMapper.editUser(userDO);
        List<SelfRoleUserDO> roleAclList = Lists.newArrayList();
        SelfRoleUserDO roleUserDO = new SelfRoleUserDO();
        roleUserDO.setCompId(roleDO.getCompId());
        roleUserDO.setRoleId(roleDO.getId());
        roleUserDO.setCreateTime(DateUtils.getCurrentDateTime());
        roleUserDO.setUserId(userDO.getId());
        roleAclList.add(roleUserDO);
        roleUserMapper.deleteByUserId(roleUserDO.getUserId());
        roleUserMapper.batchaddRoleUser(roleAclList);

        if (i > 0) {
            userDO.setState(userDOa.getState());
            userDO.setCompId(userDOa.getCompId());
            saveRedisUser(userDO);
            return JSONResult.ok("编辑用户成功");
        }
        return JSONResult.errorMap("编辑用户失败");
    }

    //用户分页
    public JSONResult userPage(UserPageReq userPageReq, RedisUser redisUser) {
        userPageReq.setCompId(redisUser.getGroupId());
        PageHelper.startPage(userPageReq.getPageNum(), userPageReq.getPageSize());
        List<UserPage> list = sysUserMapper.userPage(userPageReq);
        PageInfo<UserPage> pageInfo = new PageInfo<>(list);
        List<UserPage> list1 = pageInfo.getList();
        List<UserPageRes> userPageRes = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(list1)) {
            list1.forEach(userPage -> {
                UserPageRes userPag = new UserPageRes();
                BeanUtils.copyProperties(userPage, userPag);
                userPageRes.add(userPag);
            });
        }
        PageInfo<UserPageRes> userPageRespageInfo = new PageInfo<>(userPageRes);
        userPageRespageInfo.setTotal(pageInfo.getTotal());
        userPageRespageInfo.setSize(userPageReq.getPageSize());
        userPageRespageInfo.setPageNum(userPageReq.getPageNum());
        return JSONResult.ok(userPageRespageInfo);
    }

    //用户放入redis缓存
    private void saveRedisUser(SelfUserDO userDO) {
        RedisUser redisUser = new RedisUser();
        redisUser.setGroupId(userDO.getCompId());
        redisUser.setId(userDO.getId());
        redisUser.setSysUserName(userDO.getUNickname());
        redisUser.setSysLoginNumber(userDO.getSysLoginNumber());
        redisUser.setSysUserPhone(userDO.getUPhone());
        redisUser.setIsForbidden(userDO.getState());
        redisUtil.set(RedisKeyEnum.REDIS_USER_INFO.getKey() + redisUser.getId(), JSONObject.toJSONString(redisUser));
    }


/**
 * 修改密码
 */
    public JSONResult updatePassword(PassWordReq password,RedisUser redisUser) {
        //  Map<String, Object> map = new HashMap<String, Object>();
        SelfUserDO userDOa = sysUserMapper.getUserByUUID(password.getUuid());
        if (password.getSysUserPwd() != null) {
            String passwords = Encrypt.getShiroPassword(password.getSysUserPwd(), userDOa.getUAuthSalt(), 5);
            Long id = userDOa.getId();
            String yspassword = userDOa.getULoginPwd();
            if (!yspassword.equals(passwords)) {
                SelfUserDO selfUserDO = new SelfUserDO();
                selfUserDO.setId(id);
                String newPassword = Encrypt.getShiroPassword(password.getSysUserPwd(), userDOa.getUAuthSalt(), 5);
                selfUserDO.setULoginPwd(newPassword);
                sysUserMapper.updateByPrimaryKeySelective(selfUserDO);
                return JSONResult.ok("修改密码成功");
            }

        }
       return JSONResult.errorMap("修改密码失败");

    }
}




