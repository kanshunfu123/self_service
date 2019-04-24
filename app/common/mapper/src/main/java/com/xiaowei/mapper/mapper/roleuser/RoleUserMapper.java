package com.xiaowei.mapper.mapper.roleuser;

import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kanshunfu on 2019/4/11.
 * 用户角色
 */
public interface RoleUserMapper {
    /**
     * 批量新增用户和角色关系
     *
     * @param roleUserDOS
     * @return
     */
    public int batchaddRoleUser(List<SelfRoleUserDO> roleUserDOS);
    /**
     * 根据用户id删除用户和角色关系
     *
     * @param userid
     * @return
     */
    public int deleteByUserId(@Param("userid") Long userid);

}
