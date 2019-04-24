package com.xiaowei.controller.template;

import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.error.BaseReq;
import com.xiaowei.common.req.product.EditProductMixReq;
import com.xiaowei.common.req.template.*;
import com.xiaowei.controller.BaseController;
import com.xiaowei.service.template.TemplateMainService;
import com.xiaowei.service.template.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * created by 韩金群 2019/4/8
 */
@RestController
@RequestMapping(value = "/self/template")
@Slf4j
public class TemplateController extends BaseController {
    @Autowired
    private TemplateMainService templateMainService;
    @Autowired
    private TemplateService templateService;

    /**
     * 询主模板列表
     * */
    @PostMapping("/templateList/v1")
    public JSONResult templateList(@Validated(TemplateListReq.Query.class)@RequestBody TemplateListReq req)
    {
        return templateMainService.templateList(req);
    }
    /**
     * 新增用户产品模板
     * */
    @PostMapping("/addProductMix/v1")
    public JSONResult addProductMix(@Validated(AddProductMixReq.Add.class) @RequestBody AddProductMixReq req)
    {
        return templateService.addProductMix(req,this.redisUser());
    }
    /**
     * 用户产品列表接口
     * */
    @PostMapping("/productList/v1")
    public JSONResult productList(@Validated(ProductListReq.Query.class) @RequestBody ProductListReq req)
    {
        return templateService.productList(req,this.redisUser());
    }
    /**
     * 修改接口配置
     * */
    @PostMapping("/editPortConfig/v1")
    public JSONResult editPortConfig(@Validated(EditPortConfigReq.Modify.class) @RequestBody EditPortConfigReq req)
    {
        return templateService.editPortConfig(req,this.redisUser());
    }
    /**
     * 查询全部接口配置
     * */
    @PostMapping("/selectPortConfig/v1")
    public JSONResult selectPortConfig(@Validated(ConfigListReq.Query.class) @RequestBody ConfigListReq req)
    {
        return templateService.selectPortConfig(req);
    }
    /**
     *修改用户产品模板
     * */
    @PostMapping("/editProductMix/v1")
    public JSONResult editProductMix(@Validated(EditProductMixReq.Add.class) @RequestBody EditProductMixReq req)
    {
        return templateService.editProductMix(req,this.redisUser());
    }
}
