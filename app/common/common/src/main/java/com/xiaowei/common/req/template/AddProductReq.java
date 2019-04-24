package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/9
 */
public class AddProductReq extends BaseReq implements Serializable {
    /**
     * 协议类型（数据字典id）
     * */
    private Long parameterPactId;
    /**
     * 协议类型
     */
    private String pactType;
    /**
     * productDesc 产品描述.
     */
    private String productDesc;
    /**
     * productName 产品名称.
     */
    private String productName;
    /**
     * 行业类型（数据字典id）
     * */
    private Long parameterIndustryId;
    /**
     * 行业类型
     */
    private String industryType;

    public Long getParameterPactId() {
        return parameterPactId;
    }

    public void setParameterPactId(Long parameterPactId) {
        this.parameterPactId = parameterPactId;
    }

    public Long getParameterIndustryId() {
        return parameterIndustryId;
    }

    public void setParameterIndustryId(Long parameterIndustryId) {
        this.parameterIndustryId = parameterIndustryId;
    }

    public String getPactType() {
        return pactType;
    }

    public void setPactType(String pactType) {
        this.pactType = pactType;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
}
