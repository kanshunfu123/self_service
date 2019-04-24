package com.xiaowei.service.authority.permission;

import com.google.common.collect.Lists;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.common.res.authority.AclDto;
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
public class CommonSysCoreService {
    @Value("${xiaowei.isSuperAdmin}")
    private String isSuperAdmin;
    @Autowired
    private AuthorityMapper authorityMapper;

    public List<SelfAclDO> getRoleAclList(Long roleId, Long aclPermissionType) {
        List<Long> aclIdList = authorityMapper.aclsByRoleId(Lists.<Long>newArrayList(roleId), aclPermissionType);
        if (CollectionUtils.isEmpty(aclIdList)) {
            return Lists.newArrayList();
        }
        return authorityMapper.getAllAcl(null, aclIdList);
    }

    public List<SelfAclDO> getUserHavingAclList(LoginAuthReq loginAuthReq, RedisUser redisUser) {

        List<Long> userRoleIdList = authorityMapper.rolesByUserId(redisUser.getId());
        if (CollectionUtils.isEmpty(userRoleIdList)) {
            return Lists.newArrayList();
        }
        List<Long> userAclIdList = authorityMapper.aclsByRoleId(userRoleIdList, loginAuthReq.getAclPermissionType());
        if (CollectionUtils.isEmpty(userAclIdList)) {
            return Lists.newArrayList();
        }
        return authorityMapper.getAllAcl(loginAuthReq.getAclPermissionType(), userAclIdList);
    }
}
