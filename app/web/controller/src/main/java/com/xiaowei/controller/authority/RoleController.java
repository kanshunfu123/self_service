package com.xiaowei.controller.authority;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.BatchRoleUserReq;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.common.req.authority.RoleReq;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.authority.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by MOMO on 2019/4/9.
 */
@RestController
@RequestMapping(value = "/self/role", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/save/v1")
    public JSONResult save(@Validated(RoleReq.save.class) @RequestBody RoleReq roleReq) {
        return roleService.insertSelective(roleReq, this.redisUser());
    }


    @RequestMapping("/showRole/v1")
    public JSONResult showRole(@Validated(RoleReq.Detail.class) @RequestBody RoleReq roleReq) {
        return roleService.showRole(roleReq);
    }

    @RequestMapping("/modify/v1")
    public JSONResult modify(@Validated(RoleReq.Modify.class) @RequestBody RoleReq roleReq) {
        return roleService.updateByPrimaryKeySelective(roleReq, this.redisUser());
    }

    @RequestMapping("/status/v1")
    public JSONResult status(@Validated(RoleReq.Status.class) @RequestBody RoleReq roleReq) {
        return roleService.updateState(roleReq, this.redisUser());
    }

    @PostMapping("/rolesToUser/v1")
    public JSONResult rolesToUser(@Validated(BatchRoleUserReq.Status.class) @RequestBody BatchRoleUserReq batchRoleUserReq) {
        return roleService.rolesToUser(batchRoleUserReq, redisUser());
    }

    @PostMapping("/aclsToRole/v1")
    public JSONResult aclsToRole(@Validated(BatchRoleUserReq.Permission.class) @RequestBody BatchRoleUserReq batchRoleUserReq) {
        return roleService.aclsToRole(batchRoleUserReq, redisUser());
    }

    @PostMapping("/roleList/v1")
    public JSONResult roleList(@RequestBody RoleReq batchRoleUserReq) {
        log.debug("测试 controller");
        return roleService.roleList(batchRoleUserReq, redisUser());
    }

    @PostMapping("/roleHaveAclTree/v1")
    public JSONResult roleHaveAclTree(@Validated(LoginAuthReq.Delete.class) @RequestBody LoginAuthReq loginAuthReq) {
        return roleService.roleHaveAclTree(loginAuthReq, redisUser());
    }

    @PostMapping("/selectRole/v1")
    public JSONResult selectRole() {
        return roleService.selectRole(redisUser());
    }
}
