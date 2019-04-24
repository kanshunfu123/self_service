package com.xiaowei.service.sysmain;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.sysmain.RegisterUserReq;

/**
 * Created by MOMO on 2019/4/10.
 */
public interface UserService {

    /**
     * 账号注册
     * @param registerUserReq
     * @param redisUser
     * @return
     */
    public JSONResult register(RegisterUserReq registerUserReq, RedisUser redisUser);

    public JSONResult checkLoginName(RegisterUserReq registerUserReq);
}
