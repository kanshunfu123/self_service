package com.xiaowei.common.req.product;

import com.xiaowei.common.error.BaseReq;
import com.xiaowei.common.req.template.TemplateReq;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/12
 */
public class EditProductMixReq extends BaseReq implements Serializable {
    private String productUuid;
    /**
     * 产品模板属性(设备)
     * */
    private TemplateReq device;
    /**
     * 产品模板属性(场景)
     * */
    private TemplateReq sence;
    /**
     * 产品模板属性(业务数据)
     * */
    private TemplateReq data;

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public TemplateReq getDevice() {
        return device;
    }

    public void setDevice(TemplateReq device) {
        this.device = device;
    }

    public TemplateReq getSence() {
        return sence;
    }

    public void setSence(TemplateReq sence) {
        this.sence = sence;
    }

    public TemplateReq getData() {
        return data;
    }

    public void setData(TemplateReq data) {
        this.data = data;
    }
}
