package com.xiaowei.controller.selfuser;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.user.InserUserReq;
import com.xiaowei.common.req.user.PassWordReq;
import com.xiaowei.controller.BaseController;
import com.xiaowei.mapper.mapper.req.UserPageReq;
import com.xiaowei.service.user.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Created by kanshunfu on 2019/4/11.
 */
@RestController
@RequestMapping("/self")
@Slf4j
public class SelfController extends BaseController {
    @Autowired
    private UsersService usersService;

    /**
     * 新增用户
     *
     * @param inserUserReq
     * @param
     * @return
     */
    @PostMapping("/useradd/v1")
    public JSONResult insertUser(@Validated(InserUserReq.Add.class) @RequestBody InserUserReq inserUserReq
    ) {
        return usersService.insertUser(inserUserReq, this.redisUser());
    }
    /**
     * 根据uuid查询用户
     *
     * @param modifyUserReq
     * @return
     */
    @PostMapping("/useruuid/v1")
    public JSONResult getUserByUUID(@Validated(InserUserReq.Query.class) @RequestBody InserUserReq modifyUserReq) {
        return usersService.getUserByUUID(modifyUserReq);
    }
    @PostMapping("/useredit/v1")
    public JSONResult editUser(@Validated(InserUserReq.Modify.class) @RequestBody InserUserReq modifyUserReq
                               ) {
            return usersService.editUser(modifyUserReq, this.redisUser());
    }
    /**
     * 用户分页查询
     *
     * @param userPageReq
     * @param
     * @return
     */
    @PostMapping("/userpage/v1")
    public JSONResult userPage(@RequestBody UserPageReq userPageReq
                              ) {
            return usersService.userPage(userPageReq, this.redisUser());
    }
    @PostMapping("/pass/v1")
    public JSONResult updatePassword(@Validated(PassWordReq.Modify.class) @RequestBody PassWordReq modifyUserReq
    ) {
        return usersService.updatePassword(modifyUserReq, this.redisUser());
    }
}
