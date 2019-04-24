package com.xiaowei.controller.sysmain;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.sysmain.RegisterUserReq;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.sysmain.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MOMO on 2019/4/10.
 */
@RestController
@RequestMapping(value = "/self/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/registerUser/v1")
    public JSONResult register(@Validated(RegisterUserReq.save.class) @RequestBody RegisterUserReq registerUserReq) {
        return userService.register(registerUserReq, redisUser());
    }

    @RequestMapping("/checkLoginName/v1")
    public JSONResult checkLoginName(@Validated(RegisterUserReq.Query.class) @RequestBody RegisterUserReq registerUserReq) {
        return userService.checkLoginName(registerUserReq);
    }
}
