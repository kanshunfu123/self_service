package com.xiaowei.mapper.mapper.user;


import com.xiaowei.mapper.dataobject.SelfUserDO;
import com.xiaowei.mapper.mapper.req.UserPage;
import com.xiaowei.mapper.mapper.req.UserPageReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MOMO on 2019/1/7.
 */
public interface SysUserMapper {

    /**
     * 用户分页查询
     * @param userPageReq
     * @return
     *//*
    public List<UserPage> userPage(UserPageReq userPageReq);*/
    /**
     *
     * @param userName  根据登录名，查看登录名是否唯一*
     * @param phone 手机号是否唯一
     * @return
     */
    public int userLoginCout(@Param("userName") String userName, @Param("uPhone") String phone, @Param("userId") Long userId);



    /**
     * 根据用户的id的用户所在的组
     * @param userId
     * @return
     *//*
    public UserGroupDO  getUserGroupByUserId(@Param("userId") Long userId);*/

    /**
     * 新增用户
     * @param selfUserDO
     * @return
     */
    public int insertUser(SelfUserDO selfUserDO);

    /**
     * 编辑用户
     * @param selfUserDO
     * @return
     */
    public int editUser(SelfUserDO selfUserDO);

   /**
     * 根据uuid查询用户
     * @param uuid
     * @return
     */
    public SelfUserDO getUserByUUID(@Param("uuid") String uuid);
    /**
     * 用户分页查询
     * @param userPageReq
     * @return
     */
    public List<UserPage> userPage(UserPageReq userPageReq);

    /**
     * 获取用户信息
     * @param passwords
     * @param username
     * @return
     */
    SelfUserDO selectBypassword(@Param("passwords") String passwords,@Param("username") String username);
    //    修改密码
    int updateByPrimaryKeySelective(SelfUserDO record);

}
