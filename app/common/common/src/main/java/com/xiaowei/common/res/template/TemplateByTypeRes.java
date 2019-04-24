package com.xiaowei.common.res.template;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/12
 */
public class TemplateByTypeRes implements Serializable {
    private List<TemplateRes>basic;
    private List<TemplateRes>define;

    public List<TemplateRes> getBasic() {
        return basic;
    }

    public void setBasic(List<TemplateRes> basic) {
        this.basic = basic;
    }

    public List<TemplateRes> getDefine() {
        return define;
    }

    public void setDefine(List<TemplateRes> define) {
        this.define = define;
    }
}
