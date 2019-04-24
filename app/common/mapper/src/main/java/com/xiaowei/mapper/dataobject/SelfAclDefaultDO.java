package com.xiaowei.mapper.dataobject;

import com.xiaowei.mapper.dataobject.SelfAclDefaultDO;

/**
 * The table 默认权限
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfAclDefaultDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * aclId 权限id.
     */
    private Long aclId;
    /**
     * sysAclModuleType SYS_ACL_MODULE_TYPE.
     */
    private Long sysAclModuleType;

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
     * Set aclId 权限id.
     */
    public void setAclId(Long aclId){
        this.aclId = aclId;
    }

    /**
     * Get aclId 权限id.
     *
     * @return the string
     */
    public Long getAclId(){
        return aclId;
    }

    /**
     * Set sysAclModuleType SYS_ACL_MODULE_TYPE.
     */
    public void setSysAclModuleType(Long sysAclModuleType){
        this.sysAclModuleType = sysAclModuleType;
    }

    /**
     * Get sysAclModuleType SYS_ACL_MODULE_TYPE.
     *
     * @return the string
     */
    public Long getSysAclModuleType(){
        return sysAclModuleType;
    }
}
