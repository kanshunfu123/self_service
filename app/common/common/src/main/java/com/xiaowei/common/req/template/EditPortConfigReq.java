package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/11
 */
public class EditPortConfigReq extends BaseReq implements Serializable {
    private String uuid;
    private List<SelfPortConfigReq>configs;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<SelfPortConfigReq> getConfigs() {
        return configs;
    }

    public void setConfigs(List<SelfPortConfigReq> configs) {
        this.configs = configs;
    }
}
