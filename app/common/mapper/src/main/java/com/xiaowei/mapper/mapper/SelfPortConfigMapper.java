package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfPortConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_PORT_CONFIG.
 * 接口配置
 */
public interface SelfPortConfigMapper {
    /**
     * 新增
     * */
    int insert(SelfPortConfigDO entity);
    /**
     * 修改
     * */
    int update(SelfPortConfigDO entity);
    /**
     * 通过产品id查询接口配置
     * */
    List<SelfPortConfigDO>configByProductId(@Param("productId")Long productId);
    /**
     * 根据id删除接口配置
     * */
    int delByProductId(@Param("productId")Long productId);
}
