package com.xiaowei.common.res.template;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class ProductListRes implements Serializable {
    private Long id;
    private String uuid;
    private String productName;
    private String pactType;
    private String productDesc;

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
