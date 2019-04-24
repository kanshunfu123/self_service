package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/11
 */
public class ProductListReq extends BaseReq implements Serializable {
    @Min(value = 1, message = "每页显示记录数不能为空，且只能为整数", groups = {Query.class})
    private Integer limit = 10;//每页显示记录数
    @Min(value = 1, message = "页码不能为空，且只能为整数", groups = {Query.class})
    private Integer currPageNo = 1;//当前页 页码
    /**
     * 协议类型(数据字典id)
     * */
    private Long parameterPactId;
    /**
     * 产品名称
     * */
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Long getParameterPactId() {
        return parameterPactId;
    }

    public void setParameterPactId(Long parameterPactId) {
        this.parameterPactId = parameterPactId;
    }
}
