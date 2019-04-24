package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_ROLE_USER.
 * SELF_ROLE_USER
 */
public interface SelfRoleUserDOMapper{

    /**
     * desc:插入表:SELF_ROLE_USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ROLE_USER( COMP_ID ,ROLE_ID ,USER_ID ,CREATE_TIME )VALUES( #{compId,jdbcType=BIGINT} ,#{roleId,jdbcType=BIGINT} ,#{userId,jdbcType=BIGINT} ,#{createTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SelfRoleUserDO entity);
    /**
     * desc:更新表:SELF_ROLE_USER.<br/>
     * descSql =  UPDATE SELF_ROLE_USER SET COMP_ID = #{compId,jdbcType=BIGINT} ,ROLE_ID = #{roleId,jdbcType=BIGINT} ,USER_ID = #{userId,jdbcType=BIGINT} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SelfRoleUserDO entity);
    /**
     * desc:根据主键删除数据:SELF_ROLE_USER.<br/>
     * descSql =  DELETE FROM SELF_ROLE_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SELF_ROLE_USER.<br/>
     * descSql =  SELECT * FROM SELF_ROLE_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfRoleUserDO
     */
    SelfRoleUserDO getById(Long id);
}
