package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class ConfigListReq extends BaseReq implements Serializable {
    /**
     * uuid
     * */
    @NotBlank(message = "uuid不能为空",groups = {Query.class})
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
