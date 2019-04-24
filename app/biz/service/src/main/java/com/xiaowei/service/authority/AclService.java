package com.xiaowei.service.authority;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.AclReq;

/**
 * Created by MOMO on 2019/4/9.
 */
public interface AclService {

    JSONResult insertSelective(AclReq aclReq, RedisUser redisUser);

    JSONResult updateByPrimaryKeySelective(AclReq aclReq, RedisUser redisUser);

    JSONResult updateStatus(AclReq aclReq, RedisUser redisUser);
}
