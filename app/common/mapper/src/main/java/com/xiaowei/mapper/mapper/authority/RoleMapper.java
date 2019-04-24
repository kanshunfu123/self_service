package com.xiaowei.mapper.mapper.authority;

import com.xiaowei.mapper.dataobject.SelfRoleAclDO;
import com.xiaowei.mapper.dataobject.SelfRoleDO;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 * 角色
 */
public interface RoleMapper {


    int insertSelective(SelfRoleDO record);

    SelfRoleDO selectByPrimaryKey(Long id);

    SelfRoleDO selectByPrimaryUuid(String uuid);

    int updateByPrimaryKeySelective(SelfRoleDO record);

    /**
     * 删除用户和角色关系
     *
     * @param userId
     * @return
     */
    int deleteUserRolesByUserId(@Param("userId") Long userId);

    /**
     * 批量新增用户和角色关系
     *
     * @param roleUserDO
     * @return
     */
    int batchInsertUserRoles(@Param("roleUsers") List<SelfRoleUserDO> roleUserDO);

    /**
     * 检查角色名唯一性
     *
     * @param roleName
     * @param id
     * @param compId
     * @return
     */
    int checkRoleName(@Param("roleName") String roleName, @Param("id") Long id, @Param("compId") Long compId);

    /**
     * 校验管理员数量
     *
     * @param id
     * @param roleType
     * @param compId
     * @return
     */
    int checkAdminRole(@Param("id") Long id, @Param("roleType") String roleType, @Param("compId") Long compId);

    /**
     * 删除角色和权限点的关系
     *
     * @param roleId
     * @return
     */
    int deleteRoleAclsByRoleId(@Param("roleId") Long roleId);

    /**
     * 权限回收 管理员角色变更时，相应的自家用户权限也要抹除掉
     * @param groupId
     * @param roleId
     * @return
     */
    int deleteRoleAclsAdmin(@Param("groupId")Long groupId,@Param("aclIds") List<Long> roleId);

    /**
     * 批量新增角色和权限关系
     *
     * @param roleUserDO
     * @return
     */
    int batchInsertRoleAcls(@Param("roleAcls") List<SelfRoleAclDO> roleUserDO);

    /**
     * 查看当前用户角色
     *
     * @param userId
     * @return
     */
    List<SelfRoleDO> rolesByCurrentId(Long userId);


    /**
     * 分页查询角色
     *
     * @param selfRoleDO
     * @return
     */
    List<SelfRoleDO> roleList(SelfRoleDO selfRoleDO);
    /**
     * 根据id查询角色
     *
     * @param id
     * @return
     */
    public SelfRoleDO getRoleById(@Param("id") Long id);
    /**
     * 根据用户id得到角色列表
     *
     * @param userId
     * @return
     */
    public List<SelfRoleDO> getRolesByUserId(@Param("userId") Long userId);



}
