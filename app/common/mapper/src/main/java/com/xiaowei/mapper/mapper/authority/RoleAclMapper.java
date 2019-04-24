package com.xiaowei.mapper.mapper.authority;

import com.xiaowei.mapper.dataobject.SelfRoleUserDO;

/**
 * Created by MOMO on 2019/4/9.
 */
public interface RoleAclMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SelfRoleUserDO record);

    SelfRoleUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SelfRoleUserDO record);


}
