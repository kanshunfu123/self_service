package com.xiaowei.service.template;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.product.ApplyProductReq;
import com.xiaowei.common.req.template.TemplateByTypeReq;
import com.xiaowei.common.res.template.TemplateByTypeRes;
import com.xiaowei.common.res.template.TemplateRes;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.common.util.LevelUtil;
import com.xiaowei.mapper.dataobject.SelfProductDO;
import com.xiaowei.mapper.dataobject.SelfTemplateMainDO;
import com.xiaowei.mapper.dataobject.SelfTemplateProductDO;
import com.xiaowei.mapper.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 韩金群 2019/4/12
 */
@Service
@Slf4j
public class ProductService {
    @Autowired
    private SelfProductMapper selfProductMapper;
    @Autowired
    private SelfTemplateProductMapper selfTemplateProductMapper;
    @Autowired
    private SelfTemplateMainMapper selfTemplateMainMapper;
    @Autowired
    private SelfRoleProductMapper selfRoleProductMapper;
    @Autowired
    private SelfPortConfigMapper selfPortConfigMapper;

    /**
     * 查询产品属性模板(回显)
     */
    public JSONResult templateByType(TemplateByTypeReq req) {
        TemplateByTypeRes result = new TemplateByTypeRes();
        List<TemplateRes> basic = new ArrayList<>();
        List<TemplateRes> define = new ArrayList<>();
        SelfProductDO selfProductDO = selfProductMapper.dataByUuid(req.getProductUuid());
        if (selfProductDO == null) {
            return JSONResult.errorMap("该产品不存在");
        }
        Long productId = selfProductDO.getId();
        //处理系统属性
        List<SelfTemplateMainDO> mainDOS = selfTemplateMainMapper.templateList(req.getTemplateType());
        List<SelfTemplateProductDO> productDOS = selfTemplateProductMapper.templateByMix(productId, req.getTemplateType(), 0);
        for (SelfTemplateMainDO mainDO : mainDOS) {
            TemplateRes basicRes = new TemplateRes();
            BeanUtils.copyProperties(mainDO, basicRes);
            basicRes.setIsDefine(0);
            if (mainDO.getIsDisable() == 1) {
                basicRes.setIsDisable(1);
            } else {
                basicRes.setIsDisable(0);
            }
            for (int i = 0; i < productDOS.size(); i++) {
                if (mainDO.getId().equals(productDOS.get(i).getTemplateMainId())) {
                    basicRes.setIsSelect(1);
                    basicRes.setAttributeDefaults(productDOS.get(i).getAttributeDefaults());
                    basicRes.setAttributeShort(productDOS.get(i).getAttributeShort());
                    break;
                }
            }
            basic.add(basicRes);
        }
        //处理自定义数据
        List<SelfTemplateProductDO> productDefineDOS = selfTemplateProductMapper.templateByMix(productId, req.getTemplateType(), 1);
        for (int i = 0; i < productDefineDOS.size(); i++) {
            TemplateRes res = new TemplateRes();
            BeanUtils.copyProperties(productDefineDOS.get(i), res);
            res.setIsDefine(1);
            define.add(res);
        }
        result.setBasic(treeList(basic));
        result.setDefine(treeList(define));
        return JSONResult.ok(result);
    }

    /**
     * 提交/撤销申请
     */
    public JSONResult applayProduct(ApplyProductReq req, RedisUser redisUser) {
        SelfProductDO selfProductDO = selfProductMapper.dataByUuid(req.getProductUuid());
        if (selfProductDO == null) {
            return JSONResult.errorMap("产品不存在");
        }
        SelfProductDO after = new SelfProductDO();
        after.setId(selfProductDO.getId());
        after.setReviewStatus(req.getReviewStatus());
        after.setUpdateBy(redisUser.getSysUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        selfProductMapper.update(after);
        return JSONResult.ok("操作成功");
    }

    private List<TemplateRes> treeList(List<TemplateRes> resList) {
        //集合为空直接返回
        if (CollectionUtils.isEmpty(resList)) {
            return Lists.newArrayList();
        }
        Multimap<String, TemplateRes> multimap = ArrayListMultimap.create();
        //首先保存第一层级字典树，也是最后一层级
        List<TemplateRes> rootList = Lists.newArrayList();
        for (TemplateRes res : resList) {
            multimap.put(res.getCodeLevel(), res);
            if (LevelUtil.ROOT.equals(res.getCodeLevel())) {
                rootList.add(res);
            }
        }
        transformTree(rootList, LevelUtil.ROOT, multimap);
        //递归生成树
        return rootList;
    }

    //递归生成树
    public void transformTree(List<TemplateRes> templateList, String level, Multimap<String, TemplateRes> multimap) {
        int size = templateList.size();
        for (int i = 0; i < size; i++) {
            TemplateRes templateListRes = templateList.get(i);
            //处理当前层级下的数据
            String nextLevel = LevelUtil.calculateLevel(level, templateListRes.getId());
            List<TemplateRes> nextList = (List<TemplateRes>) multimap.get(nextLevel);
            if (!CollectionUtils.isEmpty(nextList)) {
                templateListRes.setChildren(nextList);
                transformTree(nextList, nextLevel, multimap);
            }
        }
    }
}
