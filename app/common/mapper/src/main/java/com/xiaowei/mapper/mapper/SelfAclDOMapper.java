package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfAclDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_ACL.
 * 权限点表
 */
public interface SelfAclDOMapper{

    /**
     * desc:插入表:SELF_ACL.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_ACL( SYS_ACL_MODULE_TYPE ,NAME ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ACL_URL ,SYS_ACL_CODE ,SYS_ACL_ICON ,SYS_ACL_NAME ,SYS_ACL_TYPE ,SYS_ACL_UUID ,SYS_ACL_STATE ,SYS_ACL_ACTION ,SYS_ACL_ROUTER ,SYS_ACL_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES( #{sysAclModuleType,jdbcType=BIGINT} ,#{name,jdbcType=VARCHAR} ,#{remark,jdbcType=VARCHAR} ,#{delFlag,jdbcType=CHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{sysAclUrl,jdbcType=VARCHAR} ,#{sysAclCode,jdbcType=VARCHAR} ,#{sysAclIcon,jdbcType=VARCHAR} ,#{sysAclName,jdbcType=VARCHAR} ,#{sysAclType,jdbcType=CHAR} ,#{sysAclUuid,jdbcType=VARCHAR} ,#{sysAclState,jdbcType=CHAR} ,#{sysAclAction,jdbcType=VARCHAR} ,#{sysAclRouter,jdbcType=VARCHAR} ,#{sysAclSeq,jdbcType=INTEGER} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SelfAclDO entity);
    /**
     * desc:更新表:SELF_ACL.<br/>
     * descSql =  UPDATE SELF_ACL SET SYS_ACL_MODULE_TYPE = #{sysAclModuleType,jdbcType=BIGINT} ,NAME = #{name,jdbcType=VARCHAR} ,REMARK = #{remark,jdbcType=VARCHAR} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,SYS_ACL_URL = #{sysAclUrl,jdbcType=VARCHAR} ,SYS_ACL_CODE = #{sysAclCode,jdbcType=VARCHAR} ,SYS_ACL_ICON = #{sysAclIcon,jdbcType=VARCHAR} ,SYS_ACL_NAME = #{sysAclName,jdbcType=VARCHAR} ,SYS_ACL_TYPE = #{sysAclType,jdbcType=CHAR} ,SYS_ACL_UUID = #{sysAclUuid,jdbcType=VARCHAR} ,SYS_ACL_STATE = #{sysAclState,jdbcType=CHAR} ,SYS_ACL_ACTION = #{sysAclAction,jdbcType=VARCHAR} ,SYS_ACL_ROUTER = #{sysAclRouter,jdbcType=VARCHAR} ,SYS_ACL_SEQ = #{sysAclSeq,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SelfAclDO entity);
    /**
     * desc:根据主键删除数据:SELF_ACL.<br/>
     * descSql =  DELETE FROM SELF_ACL WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SELF_ACL.<br/>
     * descSql =  SELECT * FROM SELF_ACL WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfAclDO
     */
    SelfAclDO getById(Long id);
}
