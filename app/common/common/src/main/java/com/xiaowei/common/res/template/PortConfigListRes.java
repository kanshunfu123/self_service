package com.xiaowei.common.res.template;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class PortConfigListRes implements Serializable {
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
     * configKey 功能.
     */
    private String configKey;
    /**
     * configValue 功能描述.
     */
    private String configValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}
