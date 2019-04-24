package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfPortConfigDO;

/**
 * The table 接口配置
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfPortConfigDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * productId PRODUCT_ID.
     */
    private Long productId;
    /**
     * uuid uuid.
     */
    private String uuid;
    /**
     * delFlag 0正常 1删除.
     */
    private String delFlag;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * configKey 功能.
     */
    private String configKey;
    /**
     * configValue 功能描述.
     */
    private String configValue;
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
     * Set uuid uuid.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid uuid.
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set delFlag 0正常 1删除.
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 0正常 1删除.
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set createBy 创建人.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy 创建人.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set updateBy 修改人.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy 修改人.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set configKey 功能.
     */
    public void setConfigKey(String configKey){
        this.configKey = configKey;
    }

    /**
     * Get configKey 功能.
     *
     * @return the string
     */
    public String getConfigKey(){
        return configKey;
    }

    /**
     * Set configValue 功能描述.
     */
    public void setConfigValue(String configValue){
        this.configValue = configValue;
    }

    /**
     * Get configValue 功能描述.
     *
     * @return the string
     */
    public String getConfigValue(){
        return configValue;
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
