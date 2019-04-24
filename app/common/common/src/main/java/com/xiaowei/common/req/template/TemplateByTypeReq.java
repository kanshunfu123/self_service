package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class TemplateByTypeReq extends BaseReq implements Serializable {
    /**
     * 模板类型
     * */
    @NotBlank(message = "templateType不能为空",groups = {Query.class})
    private String templateType;
    /**
     * 产品uuid
     * */
    @NotBlank(message = "productUuid不能为空",groups = {Query.class})
    private String productUuid;

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
}
