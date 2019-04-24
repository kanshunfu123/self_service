package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfRoleDO;

/**
 * The table SELF_ROLE
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfRoleDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * compId 企业id.
     */
    private Long compId;
    /**
     * uuid UUID.
     */
    private String uuid;
    /**
     * status 状态 0启用  1禁用.
     */
    private String status;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * createBy CREATE_BY.
     */
    private String createBy;
    /**
     * roleName 角色名称.
     */
    private String roleName;
    /**
     * roleType 角色的类型，0：管理员角色，1：普通用户 2其他.
     */
    private String roleType;
    /**
     * updateBy UPDATE_BY.
     */
    private String updateBy;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

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
     * Set uuid UUID.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid UUID.
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set status 状态 0启用  1禁用.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 状态 0启用  1禁用.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set createBy CREATE_BY.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy CREATE_BY.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set roleName 角色名称.
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /**
     * Get roleName 角色名称.
     *
     * @return the string
     */
    public String getRoleName(){
        return roleName;
    }

    /**
     * Set roleType 角色的类型，0：管理员角色，1：普通用户 2其他.
     */
    public void setRoleType(String roleType){
        this.roleType = roleType;
    }

    /**
     * Get roleType 角色的类型，0：管理员角色，1：普通用户 2其他.
     *
     * @return the string
     */
    public String getRoleType(){
        return roleType;
    }

    /**
     * Set updateBy UPDATE_BY.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy UPDATE_BY.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
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

    /**
     * Set updateTime UPDATE_TIME.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime UPDATE_TIME.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
