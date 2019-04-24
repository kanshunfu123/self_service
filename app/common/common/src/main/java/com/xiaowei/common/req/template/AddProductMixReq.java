package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/9
 */
public class AddProductMixReq extends BaseReq implements Serializable {
    /**
     * 产品详情
     * */
    private AddProductReq productInfo;
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
    /**
     * 接口属性配置
     * */
    private List<SelfPortConfigReq> config;

    public AddProductReq getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(AddProductReq productInfo) {
        this.productInfo = productInfo;
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

    public List<SelfPortConfigReq> getConfig() {
        return config;
    }

    public void setConfig(List<SelfPortConfigReq> config) {
        this.config = config;
    }
}
