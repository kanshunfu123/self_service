package com.xiaowei.common.req.product;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/19
 */
public class ApplyProductReq extends BaseReq implements Serializable {
    @NotBlank(message = "productUuid不能为空",groups = {Modify.class})
    private String productUuid;
    /**
     * 1发起申请操作  0撤销申请操作
     * */
    @NotBlank(message = "reviewStatus不能为空",groups = {Modify.class})
    private String reviewStatus;

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
