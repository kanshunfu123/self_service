package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/9
 */
public class TemplateListReq extends BaseReq implements Serializable {
    /**
     * 模板类型1设备属性 2场景属性 3业务属性
     * */
    @NotBlank(message = "templateType不能为空",groups = {Query.class})
    private String templateType;

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
}
