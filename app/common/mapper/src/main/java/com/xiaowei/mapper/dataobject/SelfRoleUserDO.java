package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;

/**
 * The table SELF_ROLE_USER
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfRoleUserDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * compId 企业id.
     */
    private Long compId;
    /**
     * roleId 角色id.
     */
    private Long roleId;
    /**
     * userId 用户id.
     */
    private Long userId;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set compId 企业id.
     */
    public void setCompId(Long compId){
        this.compId = compId;
    }

    /**
     * Get compId 企业id.
     *
     * @return the string
     */
    public Long getCompId(){
        return compId;
    }

    /**
     * Set roleId 角色id.
     */
    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    /**
     * Get roleId 角色id.
     *
     * @return the string
     */
    public Long getRoleId(){
        return roleId;
    }

    /**
     * Set userId 用户id.
     */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /**
     * Get userId 用户id.
     *
     * @return the string
     */
    public Long getUserId(){
        return userId;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }
}
