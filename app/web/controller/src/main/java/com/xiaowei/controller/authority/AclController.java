package com.xiaowei.controller.authority;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.authority.AclReq;
import com.xiaowei.common.req.authority.RoleReq;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.authority.AclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MOMO on 2019/4/9.
 */
@RestController
@RequestMapping(value = "/self/acl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class AclController extends BaseController {
    @Autowired
    private AclService aclService;

    @RequestMapping("/save/v1")
    public JSONResult save(@Validated(AclReq.save.class) @RequestBody AclReq aclReq) {
        return aclService.insertSelective(aclReq, redisUser());
    }

    @RequestMapping("/modify/v1")
    public JSONResult modify(@Validated(AclReq.Modify.class) @RequestBody AclReq roleReq) {
        return aclService.updateByPrimaryKeySelective(roleReq, this.redisUser());
    }

    @RequestMapping("/status/v1")
    public JSONResult status(@Validated(AclReq.Status.class) @RequestBody AclReq roleReq) {
        return aclService.updateStatus(roleReq, this.redisUser());
    }
}
