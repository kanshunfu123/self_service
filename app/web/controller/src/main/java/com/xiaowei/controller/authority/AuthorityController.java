package com.xiaowei.controller.authority;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.LoginAuthReq;
import com.xiaowei.common.res.authority.AclDto;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.authority.RoleService;
import com.xiaowei.service.authority.permission.AdminAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by MOMO on 2019/4/10.
 */
@RestController
@RequestMapping(value = "/self/acl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
@Slf4j
public class AuthorityController extends BaseController {

    @Autowired
    private AdminAuthorityService adminAuthorityService;
    @Autowired
    private RoleService roleService;

    /**
     * 动态权限菜单 (总部和第三方通用)
     *
     * @return
     */
    @RequestMapping("/dynamicMenu/v1")
    public JSONResult dynamicMenu(@Validated(LoginAuthReq.Permission.class) @RequestBody LoginAuthReq loginAuthReq) {
        Map<String, Object> map = Maps.newHashMap();
        RedisUser redisUser = this.redisUser();
        List<AclDto> aclModuleLevelDtos_DB = adminAuthorityService.dynamicMenuTree(loginAuthReq, redisUser);
        map.put("acls", aclModuleLevelDtos_DB);
        map.put("userInfo", this.redisUser());
//        map.put("roles", roleService.rolesByCurrentId(redisUser));
        return JSONResult.ok(map);

    }
}
