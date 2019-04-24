package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfRoleProductDO;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_ROLE_PRODUCT.
 * 产品角色关系表
 */
public interface SelfRoleProductMapper {

  /**
   * 插入
   * */
    int insert(SelfRoleProductDO entity);
    /**
     * 修改
     * */
    int update(SelfRoleProductDO entity);
}
