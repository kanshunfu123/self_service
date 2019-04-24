package com.xiaowei.mapper.mapper;

import com.xiaowei.mapper.dataobject.SelfCompanyDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 * The Table SELF_COMPANY.
 * 自助服务-企业
 */
public interface SelfCompanyDOMapper{

    /**
     * desc:插入表:SELF_COMPANY.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SELF_COMPANY( COMP_AREA ,COMP_CITY ,COMP_PROVINCE ,COMP_STREET_ID ,UUID ,STATE ,REMARK ,DEL_FLAG ,COMP_NAME ,CREATE_BY ,UPDATE_BY ,COMP_EMAIL ,COMP_PHONE ,COMP_STREET ,COMP_ADDRESS ,COMP_AREA_NAME ,COMP_CITY_NAME ,COMP_CONTACTS ,COMP_PROVINCE_NAME ,CREATE_TIME ,UPDATE_TIME )VALUES( #{compArea,jdbcType=BIGINT} ,#{compCity,jdbcType=BIGINT} ,#{compProvince,jdbcType=BIGINT} ,#{compStreetId,jdbcType=BIGINT} ,#{uuid,jdbcType=VARCHAR} ,#{state,jdbcType=CHAR} ,#{remark,jdbcType=VARCHAR} ,#{delFlag,jdbcType=CHAR} ,#{compName,jdbcType=VARCHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{compEmail,jdbcType=VARCHAR} ,#{compPhone,jdbcType=VARCHAR} ,#{compStreet,jdbcType=VARCHAR} ,#{compAddress,jdbcType=VARCHAR} ,#{compAreaName,jdbcType=VARCHAR} ,#{compCityName,jdbcType=VARCHAR} ,#{compContacts,jdbcType=VARCHAR} ,#{compProvinceName,jdbcType=VARCHAR} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SelfCompanyDO entity);
    /**
     * desc:更新表:SELF_COMPANY.<br/>
     * descSql =  UPDATE SELF_COMPANY SET COMP_AREA = #{compArea,jdbcType=BIGINT} ,COMP_CITY = #{compCity,jdbcType=BIGINT} ,COMP_PROVINCE = #{compProvince,jdbcType=BIGINT} ,COMP_STREET_ID = #{compStreetId,jdbcType=BIGINT} ,UUID = #{uuid,jdbcType=VARCHAR} ,STATE = #{state,jdbcType=CHAR} ,REMARK = #{remark,jdbcType=VARCHAR} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,COMP_NAME = #{compName,jdbcType=VARCHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,COMP_EMAIL = #{compEmail,jdbcType=VARCHAR} ,COMP_PHONE = #{compPhone,jdbcType=VARCHAR} ,COMP_STREET = #{compStreet,jdbcType=VARCHAR} ,COMP_ADDRESS = #{compAddress,jdbcType=VARCHAR} ,COMP_AREA_NAME = #{compAreaName,jdbcType=VARCHAR} ,COMP_CITY_NAME = #{compCityName,jdbcType=VARCHAR} ,COMP_CONTACTS = #{compContacts,jdbcType=VARCHAR} ,COMP_PROVINCE_NAME = #{compProvinceName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SelfCompanyDO entity);
    /**
     * desc:根据主键删除数据:SELF_COMPANY.<br/>
     * descSql =  DELETE FROM SELF_COMPANY WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SELF_COMPANY.<br/>
     * descSql =  SELECT * FROM self_company WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SelfCompanyDO
     */
    SelfCompanyDO getById(Long id);
    /**
     * desc:checkComp.<br/>
     * descSql =  select count(id) from self_company and comp_name=#{comp_name,jdbcType=VARCHAR} and comp_email=#{comp_email,jdbcType=VARCHAR} and comp_phone=#{comp_phone,jdbcType=VARCHAR} and comp_phone=#{comp_phone,jdbcType=VARCHAR} 
     * @param comp_name comp_name
     * @param comp_email comp_email
     * @param comp_phone comp_phone
     * @return int
     */
    int checkComp(@Param("comp_name")String comp_name,@Param("comp_email")String comp_email,@Param("comp_phone")String comp_phone);
    /**
     * desc:insertSelective.<br/>
     * descSql =  SELECT LAST_INSERT_ID() insert into self_company id, uuid, comp_name, comp_email, comp_contacts, comp_phone, comp_province_name, comp_province, comp_city_name, comp_city, comp_area_name, comp_area, comp_street, comp_street_id, comp_address, comp_regist_type, remark, state, del_flag, create_by, update_by, create_time, update_time, #{id,jdbcType=BIGINT}, #{uuid,jdbcType=VARCHAR}, #{compName,jdbcType=VARCHAR}, #{compEmail,jdbcType=VARCHAR}, #{compContacts,jdbcType=VARCHAR}, #{compPhone,jdbcType=VARCHAR}, #{compProvinceName,jdbcType=VARCHAR}, #{compProvince,jdbcType=BIGINT}, #{compCityName,jdbcType=VARCHAR}, #{compCity,jdbcType=BIGINT}, #{compAreaName,jdbcType=VARCHAR}, #{compArea,jdbcType=BIGINT}, #{compStreet,jdbcType=VARCHAR}, #{compStreetId,jdbcType=BIGINT}, #{compAddress,jdbcType=VARCHAR}, #{compRegistType,jdbcType=CHAR}, #{remark,jdbcType=VARCHAR}, #{state,jdbcType=CHAR}, #{delFlag,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{updateBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, 
     * @param entity entity
     * @return int
     */
    int insertSelective(SelfCompanyDO entity);
    /**
     * desc:updateByPrimaryKeySelective.<br/>
     * descSql =  update self_company uuid = #{uuid,jdbcType=VARCHAR}, comp_name = #{compName,jdbcType=VARCHAR}, comp_email = #{compEmail,jdbcType=VARCHAR}, comp_contacts = #{compContacts,jdbcType=VARCHAR}, comp_phone = #{compPhone,jdbcType=VARCHAR}, comp_province_name = #{compProvinceName,jdbcType=VARCHAR}, comp_province = #{compProvince,jdbcType=BIGINT}, comp_city_name = #{compCityName,jdbcType=VARCHAR}, comp_city = #{compCity,jdbcType=BIGINT}, comp_area_name = #{compAreaName,jdbcType=VARCHAR}, comp_area = #{compArea,jdbcType=BIGINT}, comp_street = #{compStreet,jdbcType=VARCHAR}, comp_street_id = #{compStreetId,jdbcType=BIGINT}, comp_address = #{compAddress,jdbcType=VARCHAR}, comp_regist_type = #{compRegistType,jdbcType=CHAR}, remark = #{remark,jdbcType=VARCHAR}, state = #{state,jdbcType=CHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, update_by = #{updateBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, where id = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int updateByPrimaryKeySelective(SelfCompanyDO entity);
}
