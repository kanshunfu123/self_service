package com.xiaowei.mapper.mapper.authority;

import com.xiaowei.mapper.dataobject.SelfAclDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 */
public interface AuthorityMapper {
    /**
     * 根据用户id查询 用户所拥有的角色
     *
     * @param userId
     * @return
     */
    List<Long> rolesByUserId(@Param("userId") Long userId);

    /**
     * 根据角色ids 查询所有权限
     *
     * @param roleId
     * @return
     */
    List<Long> aclsByRoleId(@Param("roleIds") List<Long> roleId, @Param("sys_acl_permission_type") Long sys_acl_permission_type);

    /**
     * 获取所有权限点
     *
     * @param aclPermissionType 权限类型
     * @param userAclIdList     权限点 ids
     * @return
     */
    List<SelfAclDO> getAllAcl(@Param("aclPermissionType") Long aclPermissionType, @Param("userAclIdList") List<Long> userAclIdList);

    /**
     * 根据组的id 得到管理员ids
     *
     * @param groupId
     * @return
     */
    List<Long> rolesAdminByGroupId(@Param("groupId") Long groupId);
}
