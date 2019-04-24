package com.xiaowei.service.template;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.product.EditProductMixReq;
import com.xiaowei.common.req.template.*;
import com.xiaowei.common.res.template.PortConfigListRes;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.common.util.LevelUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.mapper.dataobject.*;
import com.xiaowei.mapper.mapper.*;
import com.xiaowei.mapper.result.ProductListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 韩金群 2019/4/10
 */
@Service
@Slf4j
public class TemplateService {
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
     *修改用户产品模板
     * */
    public JSONResult editProductMix(EditProductMixReq req,RedisUser redisUser)
    {
        List<AddTemplateReq> deviceBasic = new ArrayList<>();
        List<AddTemplateReq> deviceDefine = new ArrayList<>();
        List<AddTemplateReq> senceBasic = new ArrayList<>();
        List<AddTemplateReq> senceDefine = new ArrayList<>();
        List<AddTemplateReq> dataBasic = new ArrayList<>();
        List<AddTemplateReq> dataDefine = new ArrayList<>();
        SelfProductDO productDO= selfProductMapper.dataByUuid(req.getProductUuid());
        if(productDO==null)
        {
            return JSONResult.errorMap("该产品不存在");
        }
        Long productId = productDO.getId();
        //删除原属性
        selfTemplateProductMapper.delByProductId(productId);
        //新增产品属性模板(设备)
        TemplateReq device=req.getDevice();
        if(device!=null)
        {
            deviceBasic=device.getBasic();
            dealTemplate(deviceBasic,productId,redisUser);
            deviceDefine=device.getDefine();
            dealTemplate(deviceDefine,productId,redisUser);
        }
        TemplateReq sence=req.getSence();
        if(sence!=null)
        {
            senceBasic=sence.getBasic();
            dealTemplate(senceBasic,productId,redisUser);
            senceDefine=sence.getDefine();
            dealTemplate(senceDefine,productId,redisUser);
        }
        TemplateReq data=req.getData();
        if(data!=null)
        {
            dataBasic=data.getBasic();
            dealTemplate(dataBasic,productId,redisUser);
            dataDefine=data.getDefine();
            dealTemplate(dataDefine,productId,redisUser);
        }
        return JSONResult.ok("修改成功");
    }
    /**
     * 修改接口配置
     * */
    public JSONResult editPortConfig(EditPortConfigReq req,RedisUser redisUser)
    {
        SelfProductDO selfProductDO= selfProductMapper.dataByUuid(req.getUuid());
        if(selfProductDO==null)
        {
            return JSONResult.errorMap("该产品不存在");
        }
        Long productId=selfProductDO.getId();
        //删除原有的
        selfPortConfigMapper.delByProductId(productId);
        //新增新的接口配置
        List<SelfPortConfigReq>configReqs=req.getConfigs();
        if(!CollectionUtils.isEmpty(configReqs))
        {
            for (SelfPortConfigReq configReq:configReqs)
            {
                SelfPortConfigDO selfPortConfigDO=new SelfPortConfigDO();
                BeanUtils.copyProperties(configReq,selfPortConfigDO);
                selfPortConfigDO.setUuid(StrUtil.genUUID());
                selfPortConfigDO.setUpdateBy(redisUser.getSysUserName());
                selfPortConfigDO.setCreateTime(DateUtil.getDateTime());
                selfPortConfigDO.setProductId(productId);
                selfPortConfigMapper.insert(selfPortConfigDO);
            }
        }
        return JSONResult.ok("修改成功");
    }
    /**
     * 查询接口配置(根据产品uuid)
     * */
    public JSONResult selectPortConfig(ConfigListReq req)
    {
        List<PortConfigListRes>result=new ArrayList<>();
        SelfProductDO selfProductDO= selfProductMapper.dataByUuid(req.getUuid());
        if(selfProductDO==null)
        {
            return JSONResult.errorMap("该产品不存在");
        }
        List<SelfPortConfigDO> list=selfPortConfigMapper.configByProductId(selfProductDO.getId());
        if(!CollectionUtils.isEmpty(list))
        {
            for (SelfPortConfigDO configDO:list)
            {
                PortConfigListRes res=new PortConfigListRes();
                BeanUtils.copyProperties(configDO,res);
                result.add(res);
            }
        }
        return JSONResult.ok(result);
    }
    /**
     * 用户产品列表接口
     * */
    public JSONResult productList(ProductListReq req, RedisUser redisUser)
    {
        List<ProductListResult>result=new ArrayList<>();
        //查询用户角色
        List<SelfRoleUserDO> list = selfTemplateMainMapper.roleByUserId(redisUser.getId());
        PageHelper.startPage(req.getCurrPageNo(),req.getLimit());
        result=selfProductMapper.productList(list,req.getParameterPactId(),req.getProductName());
        PageInfo<ProductListResult>pageInfo=new PageInfo<>(result);
        pageInfo.setPageNum(req.getCurrPageNo());
        return JSONResult.ok(pageInfo);
    }

    /**
     * 新增用户产品模板
     */
    public JSONResult addProductMix(AddProductMixReq req, RedisUser redisUser) {
        List<AddTemplateReq> deviceBasic = new ArrayList<>();
        List<AddTemplateReq> deviceDefine = new ArrayList<>();
        List<AddTemplateReq> senceBasic = new ArrayList<>();
        List<AddTemplateReq> senceDefine = new ArrayList<>();
        List<AddTemplateReq> dataBasic = new ArrayList<>();
        List<AddTemplateReq> dataDefine = new ArrayList<>();
        //新增产品详情
        SelfProductDO productDO = new SelfProductDO();
        BeanUtils.copyProperties(req.getProductInfo(), productDO);
        productDO.setCreateBy(redisUser.getSysUserName());
        productDO.setCreateTime(DateUtil.getDateTime());
        productDO.setReviewStatus("0");
        productDO.setUuid(StrUtil.genUUID());
        selfProductMapper.insert(productDO);
        Long productId = productDO.getId();
        //新增产品角色关系
        List<SelfRoleUserDO> selfRoleUserDOS = selfTemplateMainMapper.roleByUserId(redisUser.getId());
        for (SelfRoleUserDO selfRoleUserDO : selfRoleUserDOS) {
            Long roleId = selfRoleUserDO.getRoleId();
            SelfRoleProductDO selfRoleProductDO = new SelfRoleProductDO();
            selfRoleProductDO.setRoleId(roleId);
            selfRoleProductDO.setGroupId(redisUser.getGroupId());
            selfRoleProductDO.setProductId(productId);
            selfRoleProductDO.setCreateTime(DateUtil.getDateTime());
            selfRoleProductMapper.insert(selfRoleProductDO);
        }
        //新增接口配置
        List<SelfPortConfigReq> configReqs = req.getConfig();
        for (SelfPortConfigReq selfPortConfigReq : configReqs) {
            SelfPortConfigDO selfPortConfigDO = new SelfPortConfigDO();
            BeanUtils.copyProperties(selfPortConfigReq, selfPortConfigDO);
            selfPortConfigDO.setProductId(productId);
            selfPortConfigDO.setUuid(StrUtil.genUUID());
            selfPortConfigDO.setCreateBy(redisUser.getSysUserName());
            selfPortConfigDO.setCreateTime(DateUtil.getDateTime());
            selfPortConfigMapper.insert(selfPortConfigDO);
        }
        //新增产品属性模板(设备)
        TemplateReq device=req.getDevice();
        if(device!=null)
        {
            deviceBasic=device.getBasic();
            dealTemplate(deviceBasic,productId,redisUser);
            deviceDefine=device.getDefine();
            dealTemplate(deviceDefine,productId,redisUser);
        }
        TemplateReq sence=req.getSence();
        if(sence!=null)
        {
            senceBasic=sence.getBasic();
            dealTemplate(senceBasic,productId,redisUser);
            senceDefine=sence.getDefine();
            dealTemplate(senceDefine,productId,redisUser);
        }
        TemplateReq data=req.getData();
        if(data!=null)
        {
            dataBasic=data.getBasic();
            dealTemplate(dataBasic,productId,redisUser);
            dataDefine=data.getDefine();
            dealTemplate(dataDefine,productId,redisUser);
        }
        return JSONResult.ok("添加成功");
    }
    /**
     * 三个模板类型处理
     */
    private void dealTemplate(List<AddTemplateReq> templateReqs, Long productId, RedisUser redisUser) {
       if(!CollectionUtils.isEmpty(templateReqs))
       {
           for (int i = 0; i < templateReqs.size(); i++) {
               AddTemplateReq templateReq = templateReqs.get(i);
               SelfTemplateProductDO bean = new SelfTemplateProductDO();
               BeanUtils.copyProperties(templateReq, bean);
               String level = getLevel(null);
               bean.setCodeLevel(LevelUtil.calculateLevel(level, null));
               bean.setProductId(productId);
               bean.setUuid(StrUtil.genUUID());
               bean.setCreateBy(redisUser.getSysUserName());
               bean.setCreateTime(DateUtil.getDateTime());
               selfTemplateProductMapper.insert(bean);
               Long parentId = bean.getId();
               //是否存在子属性(递归处理)
               List<AddTemplateReq> reqs = templateReq.getChildren();
               if(reqs!=null)
               {
                   if (reqs.size() > 0) {
                       recursiveTemplate(reqs, parentId, productId, redisUser);
                   }
               }

           }
       }
    }

    //递归处理
    private void recursiveTemplate(List<AddTemplateReq> reqs, Long parentId, Long productId, RedisUser redisUser) {
        for (int i = 0; i < reqs.size(); i++) {
            AddTemplateReq templateReq = reqs.get(i);
            SelfTemplateProductDO bean = new SelfTemplateProductDO();
            BeanUtils.copyProperties(templateReq, bean);
            String level = getLevel(parentId);
            bean.setCodeLevel(LevelUtil.calculateLevel(level, parentId));
            bean.setProductId(productId);
            bean.setUuid(StrUtil.genUUID());
            bean.setCreateBy(redisUser.getSysUserName());
            bean.setCreateTime(DateUtil.getDateTime());
            selfTemplateProductMapper.insert(bean);
            Long parentId2 = bean.getId();
            //是否存在子属性(递归处理)
            List<AddTemplateReq> reqs2 = templateReq.getChildren();
            if(reqs2!=null)
            {
                if (reqs2.size() > 0) {
                    recursiveTemplate(reqs2, parentId2, productId, redisUser);
                }
            }
        }
    }

    //新增时获取等级
    private String getLevel(Long parentId) {
        if (parentId == null) {
            return null;
        }
        SelfTemplateProductDO bean = selfTemplateProductMapper.dataById(parentId);
        if (bean == null) {
            return null;
        } else {
            return bean.getCodeLevel();
        }
    }
}
