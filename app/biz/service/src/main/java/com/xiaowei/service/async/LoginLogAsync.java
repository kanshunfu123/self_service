package com.xiaowei.service.async;

import com.xiaowei.common.common.UserAgentGetter;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.mapper.dao.LoginLogDAO;
import com.xiaowei.mapper.dataobject.LoginLogDO;
import com.xiaowei.mapper.dataobject.SelfUserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 李杰 on 2019/2/10.
 */
@Service
@Slf4j
public class LoginLogAsync {
    @Autowired
    private LoginLogDAO loginLogDAO;

    @Async("threadPoolTaskExecutor")
    public void loginLog(LoginLogDO entity, HttpServletRequest request) {
        UserAgentGetter userAgentGetter = new UserAgentGetter(request);
        entity.setCreateTime(DateUtil.getDateTime());
        entity.setUserIp(userAgentGetter.getIpAddr());
        entity.setUserLoginType(userAgentGetter.getDevice());
        entity.setUserLoginSys(userAgentGetter.getOS());
        entity.setUserLoginBrowser(userAgentGetter.getBrowser());
//        log.info("登录日志记录:{}", JSONObject.toJSONString(entity));
        loginLogDAO.insert(entity);
    }
}

