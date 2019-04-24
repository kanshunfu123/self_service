package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfProductDO;

/**
 * The table 产品表
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfProductDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * parameterPactId PARAMETER_PACT_ID.
     */
    private Long parameterPactId;
    /**
     * parameterIndustryId PARAMETER_INDUSTRY_ID.
     */
    private Long parameterIndustryId;
    /**
     * uuid uuid.
     */
    private String uuid;
    /**
     * delFlag 0正常 1删除.
     */
    private String delFlag;
    /**
     * createBy CREATE_BY.
     */
    private String createBy;
    /**
     * pactType 协议类型.
     */
    private String pactType;
    /**
     * updateBy UPDATE_BY.
     */
    private String updateBy;
    /**
     * productDesc 产品描述.
     */
    private String productDesc;
    /**
     * productName 产品名称.
     */
    private String productName;
    /**
     * industryType 行业类型.
     */
    private String industryType;
    /**
     * reviewStatus 审核状态：0未申请  1申请审核中 2审核通过.
     */
    private String reviewStatus;
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
     * Set parameterPactId PARAMETER_PACT_ID.
     */
    public void setParameterPactId(Long parameterPactId){
        this.parameterPactId = parameterPactId;
    }

    /**
     * Get parameterPactId PARAMETER_PACT_ID.
     *
     * @return the string
     */
    public Long getParameterPactId(){
        return parameterPactId;
    }

    /**
     * Set parameterIndustryId PARAMETER_INDUSTRY_ID.
     */
    public void setParameterIndustryId(Long parameterIndustryId){
        this.parameterIndustryId = parameterIndustryId;
    }

    /**
     * Get parameterIndustryId PARAMETER_INDUSTRY_ID.
     *
     * @return the string
     */
    public Long getParameterIndustryId(){
        return parameterIndustryId;
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
     * Set pactType 协议类型.
     */
    public void setPactType(String pactType){
        this.pactType = pactType;
    }

    /**
     * Get pactType 协议类型.
     *
     * @return the string
     */
    public String getPactType(){
        return pactType;
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
     * Set productDesc 产品描述.
     */
    public void setProductDesc(String productDesc){
        this.productDesc = productDesc;
    }

    /**
     * Get productDesc 产品描述.
     *
     * @return the string
     */
    public String getProductDesc(){
        return productDesc;
    }

    /**
     * Set productName 产品名称.
     */
    public void setProductName(String productName){
        this.productName = productName;
    }

    /**
     * Get productName 产品名称.
     *
     * @return the string
     */
    public String getProductName(){
        return productName;
    }

    /**
     * Set industryType 行业类型.
     */
    public void setIndustryType(String industryType){
        this.industryType = industryType;
    }

    /**
     * Get industryType 行业类型.
     *
     * @return the string
     */
    public String getIndustryType(){
        return industryType;
    }

    /**
     * Set reviewStatus 审核状态：0未申请  1申请审核中 2审核通过.
     */
    public void setReviewStatus(String reviewStatus){
        this.reviewStatus = reviewStatus;
    }

    /**
     * Get reviewStatus 审核状态：0未申请  1申请审核中 2审核通过.
     *
     * @return the string
     */
    public String getReviewStatus(){
        return reviewStatus;
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
