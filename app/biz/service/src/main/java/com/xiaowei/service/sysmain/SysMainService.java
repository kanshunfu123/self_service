package com.xiaowei.service.sysmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.error.RedisKeyEnum;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.sysmain.LoginReq;
import com.xiaowei.common.res.sysmain.ResPonseUser;
import com.xiaowei.common.util.Encrypt;
import com.xiaowei.common.util.JwtTokenUtil;
import com.xiaowei.common.util.RedisUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.common.util.verificationCode.captcha.SpecCaptcha;
import com.xiaowei.mapper.dao.SelfCompanyDAO;
import com.xiaowei.mapper.dao.SelfUserDAO;
import com.xiaowei.mapper.dataobject.LoginLogDO;
import com.xiaowei.mapper.dataobject.SelfCompanyDO;
import com.xiaowei.mapper.dataobject.SelfUserDO;
import com.xiaowei.service.async.LoginLogAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2019/4/9.
 */
@Service
@Slf4j
public class SysMainService {
    @Autowired
    private SelfUserDAO selfUserDAO;
    @Autowired
    private SelfCompanyDAO selfCompanyDAO;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private LoginLogAsync loginLogAsync;

    public JSONResult login(LoginReq loginReq, HttpServletRequest request) {
        SelfUserDO selfUserDO = selfUserDAO.login(loginReq.getLoginName());
        if (null == selfUserDO) {
            return JSONResult.errorMap("用户名或者密码错误");
        }
        //状态 0启用  1禁用
        if ("1".equals(selfUserDO.getState())) {
            return JSONResult.errorMap("您的账号已被禁用，请联系管理员");
        }
        //删除状态(0-正常，1-删除)
        if ("1".equals(selfUserDO.getDelFlag())) {
            return JSONResult.errorMap("您的账号已被删除，请联系管理员");
        }
        String pwd = Encrypt.getShiroPassword(loginReq.getLoginPwd(), selfUserDO.getUAuthSalt(), 5);
        if (!pwd.equals(selfUserDO.getULoginPwd())) {
            return JSONResult.errorMap("用户名或者密码错误");
        }
        SelfCompanyDO selfCompanyDO = selfCompanyDAO.getById(selfUserDO.getCompId());
        if (null == selfCompanyDO) {
            return JSONResult.errorMap("您的账号所在的公司不存在");
        }
        //状态 0启用  1禁用
        if ("1".equals(selfCompanyDO.getState())) {
            return JSONResult.errorMap("您的账号所在的公司已被禁用，请联系管理员");
        }
        //删除状态(0-正常，1-删除)
        if ("1".equals(selfCompanyDO.getDelFlag())) {
            return JSONResult.errorMap("您的账号所在的公司已被删除，请联系管理员");
        }
        //todo 验证码
        /*JSONResult jsonResult = checkVerificationCode(loginReq);
        if (jsonResult.isOK()) {
            return jsonResult;
        }*/

        String redisUserKey = StrUtil.genUUID();
        RedisUser redisUser = RedisUser.builder().redisUserKey(redisUserKey)
                .sysUserLoginName(selfUserDO.getULoginName()).sysUserPhone(selfUserDO.getUPhone())
                .groupId(selfUserDO.getCompId()).id(selfUserDO.getId())
                .sysUserName(selfUserDO.getUNickname()).build();
        String jsonStr = JSONObject.toJSONString(redisUser);
        //生成token
        // randomKey和token已经生成完毕
        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(jsonStr, randomKey);
        //限制登录次数 -1 则不进行限制
        Integer loginNumber = selfUserDO.getSysLoginNumber();
        //限制登录次数
        if (loginNumber != -1) {
            //redis  key--》用户id     v----》 List<String> String=uuid
            //redis  key--》uuid     v----》 token
            Object listUuid = redisUtil.get(RedisKeyEnum.REDIS_KEY_USER_ID.getKey() + selfUserDO.getId());
            //首次登录
            if (listUuid == null) {
                List<String> list = Lists.newArrayList();
                list.add(redisUserKey);
                String listStr = JSONObject.toJSONString(list);
                //redis  key--》用户id     v----》 List<String> String=uuid
                loginNumber(selfUserDO.getId(), listStr, redisUserKey, token);
            } else {//已经登录过了
                List<String> list = JSON.parseObject((String) listUuid, new TypeReference<List<String>>() {
                });
                //登录次数已满，需要剔除最先登录的用户
                if (list.size() >= loginNumber) {
                    String firstUuid = list.get(0);
                    redisUtil.del(RedisKeyEnum.REDIS_KEY_USER_INFO.getKey() + firstUuid);
                    list.remove(0);
                    list.add(redisUserKey);
                    String listStr = JSONObject.toJSONString(list);
                    loginNumber(selfUserDO.getId(), listStr, redisUserKey, token);
                } else {//登录次数未满
                    list.add(redisUserKey);
                    String listStr = JSONObject.toJSONString(list);
                    loginNumber(selfUserDO.getId(), listStr, redisUserKey, token);
                }
            }
        } else if (loginNumber.equals(-1)) {//不限制登录次数
            //token放入 redis
            redisUtil.set(RedisKeyEnum.REDIS_KEY_USER_INFO.getKey() + redisUserKey, token, RedisKeyEnum.REDIS_KEY_USER_INFO.getExpireTime());
        }
        ResPonseUser resPonseUser = new ResPonseUser();
        resPonseUser.setAccess_token(redisUserKey);
        LoginLogDO entity = new LoginLogDO();
        entity.setGroupId(resPonseUser.getGroupId());
        entity.setUserLoginName(selfUserDO.getULoginName());
        entity.setUserUserName(selfUserDO.getUNickname());
        entity.setUserId(selfUserDO.getId());
        loginLogAsync.loginLog(entity, request);
        return JSONResult.ok(resPonseUser);
    }

    /**
     * @param userId   用户id
     * @param listUuid List<String> String=uuid
     * @param uuid
     * @param token
     */
    private void loginNumber(Long userId, String listUuid, String uuid, String token) {
        //redis  key--》用户id     v----》 List<String> String=uuid
        redisUtil.set(RedisKeyEnum.REDIS_KEY_USER_ID.getKey() + userId, listUuid, RedisKeyEnum.REDIS_KEY_USER_ID.getExpireTime());
        redisUtil.set(RedisKeyEnum.REDIS_KEY_USER_INFO.getKey() + uuid, token, RedisKeyEnum.REDIS_KEY_USER_INFO.getExpireTime());
    }


    public JSONResult createVerificationCode() {
        try {
            SpecCaptcha specCaptcha = new SpecCaptcha();
            String verUUidCode = specCaptcha.outaaaa(null);
            String key = StrUtil.genUUID();
            String verificationCode = specCaptcha.text();
            redisUtil.set(RedisKeyEnum.REDIS_KEY_IMG_UUID_CODE.getKey() + key, verificationCode, RedisKeyEnum.REDIS_KEY_IMG_UUID_CODE.getExpireTime());
            Map<String, Object> map = Maps.newHashMap();
            //base64
            map.put(RedisKeyEnum.REDIS_KEY_IMG_BASE.getKey(), verUUidCode);
            //一个verUUidCode对应当前请求用户
            map.put(RedisKeyEnum.REDIS_KEY_IMG_UUID_CODE_HEADER.getKey(), key);
            map.put(RedisKeyEnum.REDIS_KEY_IMG_TYPE.getKey(), "data:image/png;base64,");
            return JSONResult.ok(map);
        } catch (Exception e) {
            log.error("生成验证码异常:{},{}",e.getMessage(),e.toString());
            return JSONResult.errorMap("获取验证码base64异常");
        }
    }

    public JSONResult checkVerificationCode(LoginReq loginReq) {
        String key = "verUUidCode:" + loginReq.getVerUUidCode();
        boolean existsKey = redisUtil.hasKey(key);
        if (!existsKey) {//验证验证码
            return JSONResult.errorMap("验证码已失效");
        }
        String verUUidCode = (String) redisUtil.get(key);
        String aa = loginReq.getVerificationCode().toLowerCase().trim();
        if (!aa.equals(verUUidCode.toLowerCase().trim())) {
            return JSONResult.errorMap("验证码不正确");
        }
        return JSONResult.ok();
    }
}
