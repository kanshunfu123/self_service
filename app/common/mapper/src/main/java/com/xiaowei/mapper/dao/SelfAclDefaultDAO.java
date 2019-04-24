package com.xiaowei.mapper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.mapper.dataobject.SelfAclDefaultDO;
import java.util.List;
import com.xiaowei.mapper.mapper.SelfAclDefaultDOMapper;

/**
* The Table SELF_ACL_DEFAULT.
* 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
* 默认权限
*/
@Repository
public class SelfAclDefaultDAO{

    @Autowired
    private SelfAclDefaultDOMapper selfAclDefaultDOMapper;

    /**
     * desc:插入表:SELF_ACL_DEFAULT.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ACL_DEFAULT( ACL_ID )VALUES( #{aclId,jdbcType=BIGINT} )
     * @param entity entity
     * @return int
     */
    public int insert(SelfAclDefaultDO entity){
        return selfAclDefaultDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SELF_ACL_DEFAULT.<br/>
     * descSql =  UPDATE SELF_ACL_DEFAULT SET ACL_ID = #{aclId,jdbcType=BIGINT} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    public int update(SelfAclDefaultDO entity){
        return selfAclDefaultDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SELF_ACL_DEFAULT.<br/>
     * descSql =  DELETE FROM SELF_ACL_DEFAULT WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return selfAclDefaultDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SELF_ACL_DEFAULT.<br/>
     * descSql =  SELECT * FROM SELF_ACL_DEFAULT WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfAclDefaultDO
     */
    public SelfAclDefaultDO getById(Long id){
        return selfAclDefaultDOMapper.getById(id);
    }
    /**
     * desc:getAll.<br/>
     * descSql =  SELECT acl_id,sys_acl_module_type from self_acl_default
     * @return List<SelfAclDefaultDO>
     */
    public List<SelfAclDefaultDO> getAll(){
        return selfAclDefaultDOMapper.getAll();
    }
}
