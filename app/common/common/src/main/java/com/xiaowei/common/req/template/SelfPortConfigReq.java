package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import java.io.Serializable;

/**
 * created by 韩金群 2019/4/10
 */
public class SelfPortConfigReq extends BaseReq implements Serializable {
    /**
     * configKey 功能.
     */
    private String configKey;
    /**
     * configValue 功能描述.
     */
    private String configValue;

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
