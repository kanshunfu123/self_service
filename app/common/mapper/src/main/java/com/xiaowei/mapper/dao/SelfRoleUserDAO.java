package com.xiaowei.mapper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.mapper.dataobject.SelfRoleUserDO;
import com.xiaowei.mapper.mapper.SelfRoleUserDOMapper;

/**
* The Table SELF_ROLE_USER.
* 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
* SELF_ROLE_USER
*/
@Repository
public class SelfRoleUserDAO{

    @Autowired
    private SelfRoleUserDOMapper selfRoleUserDOMapper;

    /**
     * desc:插入表:SELF_ROLE_USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ROLE_USER( COMP_ID ,ROLE_ID ,USER_ID ,CREATE_TIME )VALUES( #{compId,jdbcType=BIGINT} ,#{roleId,jdbcType=BIGINT} ,#{userId,jdbcType=BIGINT} ,#{createTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    public int insert(SelfRoleUserDO entity){
        return selfRoleUserDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SELF_ROLE_USER.<br/>
     * descSql =  UPDATE SELF_ROLE_USER SET COMP_ID = #{compId,jdbcType=BIGINT} ,ROLE_ID = #{roleId,jdbcType=BIGINT} ,USER_ID = #{userId,jdbcType=BIGINT} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    public int update(SelfRoleUserDO entity){
        return selfRoleUserDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SELF_ROLE_USER.<br/>
     * descSql =  DELETE FROM SELF_ROLE_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return selfRoleUserDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SELF_ROLE_USER.<br/>
     * descSql =  SELECT * FROM SELF_ROLE_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfRoleUserDO
     */
    public SelfRoleUserDO getById(Long id){
        return selfRoleUserDOMapper.getById(id);
    }
}
