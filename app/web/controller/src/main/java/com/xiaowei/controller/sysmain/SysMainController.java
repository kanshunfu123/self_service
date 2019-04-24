package com.xiaowei.controller.sysmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.error.RedisKeyEnum;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.sysmain.LoginReq;
import com.xiaowei.common.res.sysmain.ResPonseUser;
import com.xiaowei.common.util.RedisUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.common.util.verificationCode.captcha.SpecCaptcha;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.sysmain.SysMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2019/4/9.
 */
@RestController
@RequestMapping(value = "/self/sysMain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class SysMainController extends BaseController {
    @Autowired
    private SysMainService sysMainService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 用户登录
     *
     * @param loginUserReq
     * @return
     */
    @PostMapping("/login/v1")
    public JSONResult userLogin(@Validated(LoginReq.Submit.class) @RequestBody LoginReq loginUserReq, HttpServletRequest request, ResPonseUser resPonseUser) {
        return sysMainService.login(loginUserReq, request);
    }

    @RequestMapping(path = "/images/captcha/v1")
    public JSONResult captcha() throws Exception {
        return sysMainService.createVerificationCode();
    }

    /**
     * 注销
     *
     * @return
     */
    @PostMapping("/logout/v1")
    public JSONResult logout(HttpServletRequest request, ResPonseUser resPonseUser) {
        RedisUser redisUser = this.redisUser();
        Object listUuid = redisUtil.get(RedisKeyEnum.REDIS_KEY_USER_ID.getKey() + redisUser.getId());
        if (null != listUuid) {
            List<String> list = JSON.parseObject((String) listUuid, new TypeReference<List<String>>() {
            });
            int index = -1;
            int siez = list.size();
            for (int i = 0; i < siez; i++) {
                String s = list.get(i);
                if (s.equals(redisUser.getRedisUserKey())) {
                    index = i;
                }
            }
            if (index != -1) {
                list.remove(index);
            }
            redisUtil.set(RedisKeyEnum.REDIS_KEY_USER_ID.getKey() + redisUser.getId(), JSONObject.toJSONString(list), RedisKeyEnum.REDIS_KEY_USER_ID.getExpireTime());
        }

        redisUtil.del(RedisKeyEnum.REDIS_KEY_USER_INFO.getKey() + redisUser.getRedisUserKey());
        return JSONResult.ok("安全退出成功");
    }
}
