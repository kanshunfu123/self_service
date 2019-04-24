package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfTemplateProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_TEMPLATE_PRODUCT.
 * SELF_TEMPLATE_PRODUCT
 */
public interface SelfTemplateProductMapper {

   /**
    * 新增
    * */
    int insert(SelfTemplateProductDO entity);
    /**
     *修改
     * */
    int update(SelfTemplateProductDO entity);
    /**
     * 根据id查询
     * */
    SelfTemplateProductDO dataById(@Param("id")Long id);
    /**
     * 根据产品id和模板类型id查询模板属性
     * */
    List<SelfTemplateProductDO>templateByMix(@Param("productId")Long productId,@Param("templateType")String templateType,@Param("isDefine")Integer isDefine);
    /**
     * 根据产品id删除属性模板
     * */
    int delByProductId(@Param("productId")Long productId);
}
