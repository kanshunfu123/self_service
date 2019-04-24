package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfProductDO;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import com.xiaowei.mapper.result.ProductListResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_PRODUCT.
 * 产品表
 */
public interface SelfProductMapper {

    /**
     * 插入
     * */
    int insert(SelfProductDO entity);
   /**
    * 修改
    * */
    int update(SelfProductDO entity);
    /**
     * 分页查询产品列表
     * */
    List<ProductListResult>productList(@Param("list") List<SelfRoleUserDO> list, @Param("parameterPactId")Long parameterPactId,@Param("productName")String productName);
    /**
     * 通过uuid查询产品
     * */
    SelfProductDO dataByUuid(@Param("uuid")String uuid);
}
