package com.xiaowei.common.req.template;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/11
 */
public class TemplateReq implements Serializable {
    private List<AddTemplateReq>basic;
    private List<AddTemplateReq>define;

    public List<AddTemplateReq> getBasic() {
        return basic;
    }

    public void setBasic(List<AddTemplateReq> basic) {
        this.basic = basic;
    }

    public List<AddTemplateReq> getDefine() {
        return define;
    }

    public void setDefine(List<AddTemplateReq> define) {
        this.define = define;
    }
}
