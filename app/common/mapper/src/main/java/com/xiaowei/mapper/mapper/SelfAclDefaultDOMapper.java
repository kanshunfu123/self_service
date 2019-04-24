package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfAclDefaultDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_ACL_DEFAULT.
 * 默认权限
 */
public interface SelfAclDefaultDOMapper{

    /**
     * desc:插入表:SELF_ACL_DEFAULT.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ACL_DEFAULT( ACL_ID )VALUES( #{aclId,jdbcType=BIGINT} )
     * @param entity entity
     * @return int
     */
    int insert(SelfAclDefaultDO entity);
    /**
     * desc:更新表:SELF_ACL_DEFAULT.<br/>
     * descSql =  UPDATE SELF_ACL_DEFAULT SET ACL_ID = #{aclId,jdbcType=BIGINT} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SelfAclDefaultDO entity);
    /**
     * desc:根据主键删除数据:SELF_ACL_DEFAULT.<br/>
     * descSql =  DELETE FROM SELF_ACL_DEFAULT WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SELF_ACL_DEFAULT.<br/>
     * descSql =  SELECT * FROM SELF_ACL_DEFAULT WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfAclDefaultDO
     */
    SelfAclDefaultDO getById(Long id);
    /**
     * desc:getAll.<br/>
     * descSql =  SELECT acl_id,sys_acl_module_type from self_acl_default
     * @return List<SelfAclDefaultDO>
     */
    List<SelfAclDefaultDO> getAll();
}
