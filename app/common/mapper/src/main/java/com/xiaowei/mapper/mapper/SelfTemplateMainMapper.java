package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import com.xiaowei.mapper.dataobject.SelfTemplateMainDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_TEMPLATE_MAIN.
 * SELF_TEMPLATE_MAIN
 */
public interface SelfTemplateMainMapper {

  /**
   * 插入
   * */
    int insert(SelfTemplateMainDO entity);
    /**
     * 修改
     * */
    int update(SelfTemplateMainDO entity);
    /**
     * 根据parentId和attributeEname属性名称查询在当前层级是否存在相同名称的属性
     * */
    int countByMix(@Param("parentId")Long parentId,@Param("attributeEname")String attributeEname,@Param("id")Long id);
    /**
     * 根据id查询字典
     * */
    SelfTemplateMainDO dataById(@Param("id")Long id);
    /**
     * 根据模板类型id查询模板属性
     * */
    List<SelfTemplateMainDO>templateList(@Param("templateType")String templateType);
    /**
     * 查询用户下的角色
     * */
    List<SelfRoleUserDO>roleByUserId(@Param("userId")Long userId);
}
