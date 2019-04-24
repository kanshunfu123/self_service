package com.xiaowei.service.authority;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.BatchRoleUserReq;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.common.req.authority.RoleReq;
import com.xiaowei.common.res.authority.AclDto;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.mapper.dao.SelfUserDAO;
import com.xiaowei.mapper.dataobject.SelfRoleAclDO;
import com.xiaowei.mapper.dataobject.SelfRoleDO;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import com.xiaowei.mapper.dataobject.SelfUserDO;
import com.xiaowei.mapper.mapper.authority.AuthorityMapper;
import com.xiaowei.mapper.mapper.authority.RoleMapper;
import com.xiaowei.service.authority.permission.AdminAuthorityService;
import com.xiaowei.service.authority.permission.CommonAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by MOMO on 2019/4/9.
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SelfUserDAO selfUserDAO;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AdminAuthorityService adminAuthorityService;
    @Autowired
    private CommonAuthorityService commonAuthorityService;


    @Override
    public JSONResult rolesToUser(BatchRoleUserReq batchRoleUserReq, RedisUser redisUser) {
        SelfUserDO userDO = selfUserDAO.uuid(batchRoleUserReq.getUserUuid());
        if (null == userDO) {
            return JSONResult.errorMap("待授权的用户不存在");
        }
        List<Long> roles = batchRoleUserReq.getRoles();
        List<Long> originAclIdList = authorityMapper.rolesByUserId(userDO.getId());
        if (originAclIdList.size() == roles.size()) {
            Set<Long> originAclIdSet = Sets.newHashSet(originAclIdList);
            Set<Long> aclIdSet = Sets.newHashSet(roles);
            originAclIdSet.removeAll(aclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return JSONResult.ok("为用户授权角色成功");
            }
        }
        updateUserRoles(userDO.getId(), roles, redisUser, userDO.getCompId());
        return JSONResult.ok("为用户授权角色成功");
    }

    @Override
    public JSONResult aclsToRole(BatchRoleUserReq batchRoleUserReq, RedisUser redisUser) {
        SelfRoleDO roleDO = roleMapper.selectByPrimaryUuid(batchRoleUserReq.getRoleUuid());
        if (null == roleDO) {
            return JSONResult.errorMap("待授权的角色不存在");
        }
        List<SelfRoleAclDO> roleAclDOS = batchRoleUserReq.getAcls();
        List<Long> acls = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roleAclDOS)) {
            roleAclDOS.forEach(roleAclDO -> {
                acls.add(roleAclDO.getSysAclId());
            });
        }
        List<Long> originAclIdList = authorityMapper.aclsByRoleId(Arrays.asList(roleDO.getId()), null);
        List<Long> alcIds= Lists.newArrayList();
        if (originAclIdList.size() == acls.size()) {
            Set<Long> originAclIdSet = Sets.newHashSet(originAclIdList);
            Set<Long> aclIdSet = Sets.newHashSet(acls);
            originAclIdSet.removeAll(aclIdSet);
            alcIds.addAll(originAclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return JSONResult.ok("为角色授权权限成功");
            }
        }
        updateRoleAcls(roleDO.getId(), roleAclDOS, redisUser, roleDO.getCompId(), acls,roleDO.getRoleType(),alcIds);
        return JSONResult.ok("为角色授权权限成功");
    }

    @Override
    public JSONResult roleHaveAclTree(LoginAuthReq loginAuthReq, RedisUser redisUser) {
        SelfRoleDO roleDO = roleMapper.selectByPrimaryUuid(loginAuthReq.getRoleUuid());
        if (null == roleDO) {
            return JSONResult.errorMap("待授权的角色不存在");
        }
        loginAuthReq.setRoleId(roleDO.getId());
        if (redisUser.getGroupId().equals(1L)) {
            List<AclDto> list = adminAuthorityService.roleTree(loginAuthReq, redisUser);
            return JSONResult.ok(list);
        } else {
            List<AclDto> list = commonAuthorityService.roleTree(loginAuthReq, redisUser);
            return JSONResult.ok(list);
        }
    }

    @Override
    public List<SelfRoleDO> rolesByCurrentId(RedisUser redisUser) {
        return roleMapper.rolesByCurrentId(redisUser.getId());
    }

    @Override
    public JSONResult roleList(RoleReq roleReq, RedisUser redisUser) {
        log.debug("测试 service");
        PageHelper.startPage(roleReq.getPageNum(), roleReq.getPageSize(), "create_time desc");
        SelfRoleDO selfRoleDO = new SelfRoleDO();
        BeanUtils.copyProperties(roleReq, selfRoleDO);
        selfRoleDO.setCompId(redisUser.getGroupId());
        List<SelfRoleDO> selfRoleDOS = roleMapper.roleList(selfRoleDO);
        PageInfo<SelfRoleDO> pageInfo = new PageInfo<>(selfRoleDOS);
        return JSONResult.ok(pageInfo);
    }

    @Override
    public JSONResult showRole(RoleReq roleReq) {
        SelfRoleDO roleDO = roleMapper.selectByPrimaryUuid(roleReq.getUuid());
        if (null == roleDO) {
            return JSONResult.errorMap("待编辑的角色不存在");
        }
        return JSONResult.ok(roleDO);
    }

    @Override
    public JSONResult selectRole(RedisUser redisUser) {
        SelfRoleDO selfRoleDO = new SelfRoleDO();
        selfRoleDO.setCompId(redisUser.getGroupId());
        List<SelfRoleDO> selfRoleDOS = roleMapper.roleList(selfRoleDO);
        return JSONResult.ok(selfRoleDOS);
    }

    @Transactional
    @Override
    public JSONResult insertSelective(RoleReq roleReq, RedisUser redisUser) {
        if (checkRoleName(roleReq.getRoleName(), null, redisUser.getGroupId())) {
            return JSONResult.errorMap("角色名称已存在");
        }
        //角色的类型，0：管理员角色，1：普通用户 2其他
        if ("0".equals(roleReq.getRoleType())) {
            if (checkAdminRole("0", null, redisUser.getGroupId())) {
                return JSONResult.errorMap("管理员角色已存在");
            }
        }

        SelfRoleDO record = new SelfRoleDO();
        BeanUtils.copyProperties(roleReq, record);
        record.setCreateBy(redisUser.getSysUserName());
        record.setUpdateBy(redisUser.getSysUserName());
        record.setCreateTime(DateUtil.getDateTime());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setUuid(StrUtil.genUUID());
        record.setCompId(redisUser.getGroupId());
        roleMapper.insertSelective(record);

        return JSONResult.ok("新增角色成功");
    }

    @Transactional
    @Override
    public JSONResult updateByPrimaryKeySelective(RoleReq roleReq, RedisUser redisUser) {
        SelfRoleDO selfRoleDO = roleMapper.selectByPrimaryUuid(roleReq.getUuid());
        if (null == selfRoleDO) {
            return JSONResult.errorMap("待编辑的角色不存在");
        }
        if (checkRoleName(roleReq.getRoleName(), selfRoleDO.getId(), redisUser.getGroupId())) {
            return JSONResult.errorMap("角色名称已存在");
        }
        //角色的类型，0：管理员角色，1：普通用户 2其他
        if ("0".equals(roleReq.getRoleType())) {
            if (checkAdminRole("0", null, redisUser.getGroupId())) {
                return JSONResult.errorMap("管理员角色已存在");
            }
        }
        SelfRoleDO record = new SelfRoleDO();
        BeanUtils.copyProperties(roleReq, record);
        record.setUpdateBy(redisUser.getSysUserName());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setId(selfRoleDO.getId());
        roleMapper.updateByPrimaryKeySelective(record);
        return JSONResult.ok("编辑角色成功");
    }

    @Transactional
    @Override
    public JSONResult updateState(RoleReq roleReq, RedisUser redisUser) {
        SelfRoleDO selfRoleDO = roleMapper.selectByPrimaryUuid(roleReq.getUuid());
        if (null == selfRoleDO) {
            return JSONResult.errorMap("待编辑的角色不存在");
        }
        SelfRoleDO record = new SelfRoleDO();
        //状态 0启用  1禁用
        if ("0".equals(roleReq.getStatus())) {
            record.setStatus("1");
        } else if ("1".equals(roleReq.getStatus())) {
            record.setStatus("0");
        }
        record.setUpdateBy(redisUser.getSysUserName());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setId(selfRoleDO.getId());
        roleMapper.updateByPrimaryKeySelective(record);
        return JSONResult.ok("变更角色状态成功");
    }

    @Transactional
    public void updateRoleAcls(Long roleId, List<SelfRoleAclDO> aclIdList, RedisUser redisUser, Long groupId, List<Long> acls,String roleType,List<Long> alcIds) {
        roleMapper.deleteRoleAclsByRoleId(roleId);
        //角色的类型，0：管理员角色，1：普通用户 2其他
        if("0".equals(roleType)){
            roleMapper.deleteRoleAclsAdmin(groupId, alcIds);
        }

        if (CollectionUtils.isEmpty(aclIdList)) {
            return;
        }
        List<SelfRoleAclDO> roleUserList = Lists.newArrayList();
        for (SelfRoleAclDO aclId : aclIdList) {
            SelfRoleAclDO roleUserDO = new SelfRoleAclDO();
            roleUserDO.setDelFlag("0");
            roleUserDO.setGroupId(groupId);
            roleUserDO.setSysAclId(aclId.getSysAclId());
            roleUserDO.setSysRoleId(roleId);
            roleUserDO.setSysAclPermissionType(aclId.getSysAclPermissionType());
            roleUserDO.setSysRoleAclUuid(StrUtil.genUUID());
            roleUserDO.setCreateBy(redisUser.getSysUserName());
            roleUserDO.setUpdateBy(redisUser.getSysUserName());
            roleUserDO.setUpdateTime(DateUtil.getDateTime());
            roleUserDO.setCreateTime(DateUtil.getDateTime());
            roleUserList.add(roleUserDO);
        }
        roleMapper.batchInsertRoleAcls(roleUserList);
    }

    @Transactional
    public void updateUserRoles(Long userId, List<Long> roleIdList, RedisUser redisUser, Long groupId) {
        roleMapper.deleteUserRolesByUserId(userId);

        if (CollectionUtils.isEmpty(roleIdList)) {
            return;
        }
        List<SelfRoleUserDO> roleUserList = Lists.newArrayList();
        for (Long aclId : roleIdList) {
            SelfRoleUserDO roleUserDO = new SelfRoleUserDO();
            roleUserDO.setRoleId(aclId);
            roleUserDO.setCompId(groupId);
            roleUserDO.setUserId(userId);
            roleUserDO.setCreateTime(DateUtil.getDateTime());
            roleUserList.add(roleUserDO);
        }
        roleMapper.batchInsertUserRoles(roleUserList);
    }

    public boolean checkRoleName(String roleName, Long id, Long compId) {
        return roleMapper.checkRoleName(roleName, id, compId) > 0 ? true : false;
    }

    public boolean checkAdminRole(String roleType, Long id, Long compId) {
        return roleMapper.checkAdminRole(id, roleType, compId) > 0 ? true : false;
    }
}
