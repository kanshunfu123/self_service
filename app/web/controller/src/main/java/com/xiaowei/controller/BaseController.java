package com.xiaowei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaowei.common.error.RedisKeyEnum;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by MOMO on 2019/1/8.
 */
@Slf4j
public class BaseController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 由网关 传入最新的user信息
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public RedisUser redisUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authToken = request.getHeader(RedisKeyEnum.REDIS_KEY_USER_HEADER_CODE.getKey());
        if (!StringUtils.isEmpty(authToken)) {
            //解析token
            String userInfo = jwtTokenUtil.getUsernameFromToken(authToken);
            RedisUser redisUser = JSON.parseObject(userInfo, new TypeReference<RedisUser>() {
            });
            return redisUser;
        }
        RedisUser redisUser = new RedisUser();
        redisUser.setSysUserName("xiaowei");
        return redisUser;
    }

    /**
     * 用户登录时，存入jwt信息，更新用户无法，更新jwt
     *
     * @param token
     * @return
     */
    public RedisUser jwtUser(String token) {
        String tok = jwtTokenUtil.getUsernameFromToken(token);
        RedisUser redisUser = JSON.parseObject(tok, new TypeReference<RedisUser>() {
        });
        return redisUser;
    }

}
