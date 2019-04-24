package com.xiaowei.service.authority.permission;

import com.google.common.collect.Lists;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.mapper.dataobject.SelfAclDO;
import com.xiaowei.mapper.mapper.authority.AuthorityMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 */
@Service
public class AdminSysCoreService {
    @Value("${xiaowei.isSuperAdmin}")
    private String isSuperAdmin;
    @Autowired
    private AuthorityMapper authorityMapper;

    public List<SelfAclDO> getRoleAclList(Long roleId, Long aclPermissionType) {
        //根据角色id获取权限点ids
        List<Long> aclIdList = authorityMapper.aclsByRoleId(Lists.<Long>newArrayList(roleId), aclPermissionType);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        //根据权限点ids获取权限点列表
        return authorityMapper.getAllAcl(null, aclIdList);
    }

    //动态权限菜单
    public List<SelfAclDO> getUserAclList(LoginAuthReq loginAuthReq, RedisUser redisUser) {
        //如果是超级管理员，则获取所有权限点
        if (isSuperAdmin(redisUser)) {
            return authorityMapper.getAllAcl(loginAuthReq.getAclPermissionType(), null);
        }
        //根据用户id获取角色ids
        List<Long> userRoleIdList = authorityMapper.rolesByUserId(redisUser.getId());
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        //根据角色ids获取权限点ids
        List<Long> userAclIdList = authorityMapper.aclsByRoleId(userRoleIdList, loginAuthReq.getAclPermissionType());
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        //根据权限点ids获取权限点列表
        return authorityMapper.getAllAcl(loginAuthReq.getAclPermissionType(), userAclIdList);
    }

    //为角色授权 权限 之前， 需要查看该角色拥有哪些权限点，以及当前登录用户可以操作哪些权限
    public List<SelfAclDO> getUserHavingAclList(LoginAuthReq loginAuthReq, RedisUser redisUser) {
        //如果是超级管理员，则获取所有权限点
        if (isSuperAdmin(redisUser)) {
            return authorityMapper.getAllAcl(loginAuthReq.getAclPermissionType(), null);
        }
        //根据用户id获取角色ids
        List<Long> userRoleIdList = authorityMapper.rolesByUserId(redisUser.getId());
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        //根据角色ids获取权限点ids
        List<Long> userAclIdList = authorityMapper.aclsByRoleId(userRoleIdList, loginAuthReq.getAclPermissionType());
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        //根据权限点ids获取权限点列表
        return authorityMapper.getAllAcl(loginAuthReq.getAclPermissionType(), userAclIdList);
    }

    public boolean isSuperAdmin(RedisUser redisUser) {
        // 这里是我自己定义了一个假的超级管理员规则，实际中要根据项目进行修改
        // 可以是配置文件获取，可以指定某个用户，也可以指定某个角色
        if (isSuperAdmin.trim().contains(redisUser.getSysUserPhone().trim())) {
            return true;
        }
        return false;
    }
}
