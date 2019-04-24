package com.xiaowei.mapper.result;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class ProductListResult implements Serializable {
    private Long id;
    private String uuid;
    private String productName;
    private String pactType;
    private String productDesc;
    private String industryType;
    private String reviewStatus;
    private Long parameterPactId;
    private Long parameterIndustryId;

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

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
