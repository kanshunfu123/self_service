package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfUserDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_USER.
 * 自助服务-用户
 */
public interface SelfUserDOMapper{

    /**
     * desc:插入表:SELF_USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_USER( COMP_ID ,UUID ,STATE ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,U__AUTH_SALT ,U_LOGIN_PWD ,U_NICKNAME ,U_LOGIN_NAME ,CREATE_TIME ,UPDATE_TIME )VALUES( #{compId,jdbcType=BIGINT} ,#{uuid,jdbcType=VARCHAR} ,#{state,jdbcType=CHAR} ,#{remark,jdbcType=VARCHAR} ,#{delFlag,jdbcType=CHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{uAuthSalt,jdbcType=VARCHAR} ,#{uLoginPwd,jdbcType=VARCHAR} ,#{uNickname,jdbcType=VARCHAR} ,#{uLoginName,jdbcType=VARCHAR} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SelfUserDO entity);
    /**
     * desc:更新表:SELF_USER.<br/>
     * descSql =  UPDATE SELF_USER SET COMP_ID = #{compId,jdbcType=BIGINT} ,UUID = #{uuid,jdbcType=VARCHAR} ,STATE = #{state,jdbcType=CHAR} ,REMARK = #{remark,jdbcType=VARCHAR} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,U__AUTH_SALT = #{uAuthSalt,jdbcType=VARCHAR} ,U_LOGIN_PWD = #{uLoginPwd,jdbcType=VARCHAR} ,U_NICKNAME = #{uNickname,jdbcType=VARCHAR} ,U_LOGIN_NAME = #{uLoginName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SelfUserDO entity);
    /**
     * desc:根据主键删除数据:SELF_USER.<br/>
     * descSql =  DELETE FROM SELF_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SELF_USER.<br/>
     * descSql =  SELECT * FROM SELF_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfUserDO
     */
    SelfUserDO getById(Long id);
    /**
     * desc:根据主键获取数据:SELF_USER.<br/>
     * descSql =  SELECT id, uuid, comp_id, u_login_name, u__auth_salt, u_login_pwd, u_nickname, name_top, name_bottom, remark, state, del_flag,sys_login_number FROM self_user WHERE uuid = #{uuid,jdbcType=VARCHAR}
     * @param uuid uuid
     * @return SelfUserDO
     */
    SelfUserDO uuid(String uuid);
    /**
     * desc:login.<br/>
     * descSql =  SELECT id, uuid, comp_id, u_login_name, u__auth_salt, u_login_pwd, u_nickname, name_top, name_bottom, remark, state, del_flag,sys_login_number,u_phone from self_user where u_login_name=#{u_login_name,jdbcType=VARCHAR}
     * @param u_login_name u_login_name
     * @return SelfUserDO
     */
    SelfUserDO login(String u_login_name);
    /**
     * desc:checkUser.<br/>
     * descSql =  select count(id) from self_user and u_phone=#{uPhone,jdbcType=VARCHAR} 
     * @param entity entity
     * @return int
     */
    int checkUser(SelfUserDO entity);
    /**
     * desc:insertSelective.<br/>
     * descSql =  insert into self_user id, uuid, comp_id, u_login_name, u__auth_salt, u_login_pwd, u_nickname, u_phone, sys_login_number, name_top, name_bottom, u_regist_type, remark, state, del_flag, create_by, update_by, create_time, update_time, #{id,jdbcType=BIGINT}, #{uuid,jdbcType=VARCHAR}, #{compId,jdbcType=BIGINT}, #{uLoginName,jdbcType=VARCHAR}, #{uAuthSalt,jdbcType=VARCHAR}, #{uLoginPwd,jdbcType=VARCHAR}, #{uNickname,jdbcType=VARCHAR}, #{uPhone,jdbcType=VARCHAR}, #{sysLoginNumber,jdbcType=INTEGER}, #{nameTop,jdbcType=VARCHAR}, #{nameBottom,jdbcType=VARCHAR}, #{uRegistType,jdbcType=CHAR}, #{remark,jdbcType=VARCHAR}, #{state,jdbcType=CHAR}, #{delFlag,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{updateBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, 
     * @param entity entity
     * @return int
     */
    int insertSelective(SelfUserDO entity);
    /**
     * desc:updateByPrimaryKeySelective.<br/>
     * descSql =  update self_user uuid = #{uuid,jdbcType=VARCHAR}, comp_id = #{compId,jdbcType=BIGINT}, u_login_name = #{uLoginName,jdbcType=VARCHAR}, u__auth_salt = #{uAuthSalt,jdbcType=VARCHAR}, u_login_pwd = #{uLoginPwd,jdbcType=VARCHAR}, u_nickname = #{uNickname,jdbcType=VARCHAR}, u_phone = #{uPhone,jdbcType=VARCHAR}, sys_login_number = #{sysLoginNumber,jdbcType=INTEGER}, name_top = #{nameTop,jdbcType=VARCHAR}, name_bottom = #{nameBottom,jdbcType=VARCHAR}, u_regist_type = #{uRegistType,jdbcType=CHAR}, remark = #{remark,jdbcType=VARCHAR}, state = #{state,jdbcType=CHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, update_by = #{updateBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, where id = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int updateByPrimaryKeySelective(SelfUserDO entity);
}
