package com.xiaowei.service.authority;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.BatchRoleUserReq;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.common.req.authority.RoleReq;
import com.xiaowei.mapper.dataobject.SelfRoleDO;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 * 角色
 */
public interface RoleService {
    public JSONResult insertSelective(RoleReq roleReq, RedisUser redisUser);

    public JSONResult updateByPrimaryKeySelective(RoleReq roleReq, RedisUser redisUser);

    public JSONResult updateState(RoleReq roleReq, RedisUser redisUser);

    public JSONResult roleList(RoleReq roleReq, RedisUser redisUser);

    public JSONResult showRole(RoleReq roleReq);

    /**
     * 下拉框角色列表
     * @param redisUser
     * @return
     */
    public JSONResult selectRole(RedisUser redisUser);

    /**
     * 角色列表给用户
     *
     * @param batchRoleUserReq
     * @param redisUser
     * @return
     */
    public JSONResult rolesToUser(BatchRoleUserReq batchRoleUserReq, RedisUser redisUser);

    /**
     * 权限列表给角色
     *
     * @param batchRoleUserReq
     * @param redisUser
     * @return
     */
    public JSONResult aclsToRole(BatchRoleUserReq batchRoleUserReq, RedisUser redisUser);

    /**
     * //为角色授权 权限 之前， 需要查看该角色拥有哪些权限点，以及当前登录用户可以操作哪些权限
     *
     * @param loginAuthReq
     * @param redisUser
     * @return
     */
    public JSONResult roleHaveAclTree(LoginAuthReq loginAuthReq, RedisUser redisUser);

    /**
     * 查看当前用户角色
     * @param redisUser
     * @return
     */
    List<SelfRoleDO> rolesByCurrentId(RedisUser redisUser);
}
