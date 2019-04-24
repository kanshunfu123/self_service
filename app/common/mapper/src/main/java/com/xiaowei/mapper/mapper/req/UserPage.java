package com.xiaowei.mapper.mapper.req;

import com.xiaowei.mapper.dataobject.SelfRoleDO;
import com.xiaowei.mapper.dataobject.SelfUserDO;

import java.util.List;

/**
 * Created by kanshunfu on 2019/4/12.
 */
public class UserPage extends SelfUserDO {

    //角色列表
    private List<SelfRoleDO> roleNameList;

    public List<SelfRoleDO> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<SelfRoleDO> roleNameList) {
        this.roleNameList = roleNameList;
    }
}
