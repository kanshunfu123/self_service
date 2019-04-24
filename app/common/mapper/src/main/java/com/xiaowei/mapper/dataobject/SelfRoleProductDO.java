package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfRoleProductDO;

/**
 * The table 产品角色关系表
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfRoleProductDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * roleId ROLE_ID.
     */
    private Long roleId;
    /**
     * groupId GROUP_ID.
     */
    private Long groupId;
    /**
     * productId PRODUCT_ID.
     */
    private Long productId;
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
     * Set roleId ROLE_ID.
     */
    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    /**
     * Get roleId ROLE_ID.
     *
     * @return the string
     */
    public Long getRoleId(){
        return roleId;
    }

    /**
     * Set groupId GROUP_ID.
     */
    public void setGroupId(Long groupId){
        this.groupId = groupId;
    }

    /**
     * Get groupId GROUP_ID.
     *
     * @return the string
     */
    public Long getGroupId(){
        return groupId;
    }

    /**
     * Set productId PRODUCT_ID.
     */
    public void setProductId(Long productId){
        this.productId = productId;
    }

    /**
     * Get productId PRODUCT_ID.
     *
     * @return the string
     */
    public Long getProductId(){
        return productId;
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
