package com.xiaowei.controller.template;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.error.BaseReq;
import com.xiaowei.common.req.product.ApplyProductReq;
import com.xiaowei.common.req.template.TemplateByTypeReq;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.template.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by 韩金群 2019/4/12
 */
@RestController
@RequestMapping(value = "/self/template")
@Slf4j
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;
    /**
     * 查询属性模板（通过产品uuid和模板类型）
     * */
    @PostMapping("/templateByType/v1")
    public JSONResult templateByType(@Validated(TemplateByTypeReq.Query.class)@RequestBody TemplateByTypeReq req)
    {
        return productService.templateByType(req);
    }
    /**
     * 提交/撤销申请
     * */
    @PostMapping("/applayProduct/v1")
    public JSONResult applayProduct(@Validated(ApplyProductReq.Query.class)@RequestBody ApplyProductReq req)
    {
        return productService.applayProduct(req,this.redisUser());
    }
}
