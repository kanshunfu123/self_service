package com.xiaowei.mapper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.mapper.dataobject.SelfRoleDO;
import com.xiaowei.mapper.mapper.SelfRoleDOMapper;

/**
* The Table SELF_ROLE.
* 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
* SELF_ROLE
*/
@Repository
public class SelfRoleDAO{

    @Autowired
    private SelfRoleDOMapper selfRoleDOMapper;

    /**
     * desc:插入表:SELF_ROLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ROLE( COMP_ID ,UUID ,STATUS ,DEL_FLAG ,CREATE_BY ,ROLE_NAME ,ROLE_TYPE ,UPDATE_BY ,CREATE_TIME ,UPDATE_TIME )VALUES( #{compId,jdbcType=BIGINT} ,#{uuid,jdbcType=VARCHAR} ,#{status,jdbcType=CHAR} ,#{delFlag,jdbcType=CHAR} ,#{createBy,jdbcType=VARCHAR} ,#{roleName,jdbcType=VARCHAR} ,#{roleType,jdbcType=CHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    public int insert(SelfRoleDO entity){
        return selfRoleDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SELF_ROLE.<br/>
     * descSql =  UPDATE SELF_ROLE SET COMP_ID = #{compId,jdbcType=BIGINT} ,UUID = #{uuid,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=CHAR} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,ROLE_NAME = #{roleName,jdbcType=VARCHAR} ,ROLE_TYPE = #{roleType,jdbcType=CHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    public int update(SelfRoleDO entity){
        return selfRoleDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SELF_ROLE.<br/>
     * descSql =  DELETE FROM SELF_ROLE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return selfRoleDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SELF_ROLE.<br/>
     * descSql =  SELECT * FROM SELF_ROLE WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfRoleDO
     */
    public SelfRoleDO getById(Long id){
        return selfRoleDOMapper.getById(id);
    }
}
