package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfCompanyDO;

/**
 * The table 自助服务-企业
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfCompanyDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * compArea 区域id.
     */
    private Long compArea;
    /**
     * compCity 市id.
     */
    private Long compCity;
    /**
     * compProvince 省id.
     */
    private Long compProvince;
    /**
     * compStreetId 街道id.
     */
    private Long compStreetId;
    /**
     * uuid UUID.
     */
    private String uuid;
    /**
     * state 状态 0启用  1禁用.
     */
    private String state;
    /**
     * remark 备注.
     */
    private String remark;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * compName 企业名称.
     */
    private String compName;
    /**
     * createBy CREATE_BY.
     */
    private String createBy;
    /**
     * updateBy UPDATE_BY.
     */
    private String updateBy;
    /**
     * compEmail 邮箱.
     */
    private String compEmail;
    /**
     * compPhone 手机号.
     */
    private String compPhone;
    /**
     * compStreet 街道.
     */
    private String compStreet;
    /**
     * compAddress 详细地址.
     */
    private String compAddress;
    /**
     * compAreaName 区域.
     */
    private String compAreaName;
    /**
     * compCityName 市.
     */
    private String compCityName;
    /**
     * compContacts 联系人.
     */
    private String compContacts;
    /**
     * compRegistType 注册来源 0平台注册 1自己注册.
     */
    private String compRegistType;
    /**
     * compProvinceName 省名称.
     */
    private String compProvinceName;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set compArea 区域id.
     */
    public void setCompArea(Long compArea){
        this.compArea = compArea;
    }

    /**
     * Get compArea 区域id.
     *
     * @return the string
     */
    public Long getCompArea(){
        return compArea;
    }

    /**
     * Set compCity 市id.
     */
    public void setCompCity(Long compCity){
        this.compCity = compCity;
    }

    /**
     * Get compCity 市id.
     *
     * @return the string
     */
    public Long getCompCity(){
        return compCity;
    }

    /**
     * Set compProvince 省id.
     */
    public void setCompProvince(Long compProvince){
        this.compProvince = compProvince;
    }

    /**
     * Get compProvince 省id.
     *
     * @return the string
     */
    public Long getCompProvince(){
        return compProvince;
    }

    /**
     * Set compStreetId 街道id.
     */
    public void setCompStreetId(Long compStreetId){
        this.compStreetId = compStreetId;
    }

    /**
     * Get compStreetId 街道id.
     *
     * @return the string
     */
    public Long getCompStreetId(){
        return compStreetId;
    }

    /**
     * Set uuid UUID.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid UUID.
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set state 状态 0启用  1禁用.
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * Get state 状态 0启用  1禁用.
     *
     * @return the string
     */
    public String getState(){
        return state;
    }

    /**
     * Set remark 备注.
     */
    public void setRemark(String remark){
        this.remark = remark;
    }

    /**
     * Get remark 备注.
     *
     * @return the string
     */
    public String getRemark(){
        return remark;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set compName 企业名称.
     */
    public void setCompName(String compName){
        this.compName = compName;
    }

    /**
     * Get compName 企业名称.
     *
     * @return the string
     */
    public String getCompName(){
        return compName;
    }

    /**
     * Set createBy CREATE_BY.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy CREATE_BY.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set updateBy UPDATE_BY.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy UPDATE_BY.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set compEmail 邮箱.
     */
    public void setCompEmail(String compEmail){
        this.compEmail = compEmail;
    }

    /**
     * Get compEmail 邮箱.
     *
     * @return the string
     */
    public String getCompEmail(){
        return compEmail;
    }

    /**
     * Set compPhone 手机号.
     */
    public void setCompPhone(String compPhone){
        this.compPhone = compPhone;
    }

    /**
     * Get compPhone 手机号.
     *
     * @return the string
     */
    public String getCompPhone(){
        return compPhone;
    }

    /**
     * Set compStreet 街道.
     */
    public void setCompStreet(String compStreet){
        this.compStreet = compStreet;
    }

    /**
     * Get compStreet 街道.
     *
     * @return the string
     */
    public String getCompStreet(){
        return compStreet;
    }

    /**
     * Set compAddress 详细地址.
     */
    public void setCompAddress(String compAddress){
        this.compAddress = compAddress;
    }

    /**
     * Get compAddress 详细地址.
     *
     * @return the string
     */
    public String getCompAddress(){
        return compAddress;
    }

    /**
     * Set compAreaName 区域.
     */
    public void setCompAreaName(String compAreaName){
        this.compAreaName = compAreaName;
    }

    /**
     * Get compAreaName 区域.
     *
     * @return the string
     */
    public String getCompAreaName(){
        return compAreaName;
    }

    /**
     * Set compCityName 市.
     */
    public void setCompCityName(String compCityName){
        this.compCityName = compCityName;
    }

    /**
     * Get compCityName 市.
     *
     * @return the string
     */
    public String getCompCityName(){
        return compCityName;
    }

    /**
     * Set compContacts 联系人.
     */
    public void setCompContacts(String compContacts){
        this.compContacts = compContacts;
    }

    /**
     * Get compContacts 联系人.
     *
     * @return the string
     */
    public String getCompContacts(){
        return compContacts;
    }

    /**
     * Set compRegistType 注册来源 0平台注册 1自己注册.
     */
    public void setCompRegistType(String compRegistType){
        this.compRegistType = compRegistType;
    }

    /**
     * Get compRegistType 注册来源 0平台注册 1自己注册.
     *
     * @return the string
     */
    public String getCompRegistType(){
        return compRegistType;
    }

    /**
     * Set compProvinceName 省名称.
     */
    public void setCompProvinceName(String compProvinceName){
        this.compProvinceName = compProvinceName;
    }

    /**
     * Get compProvinceName 省名称.
     *
     * @return the string
     */
    public String getCompProvinceName(){
        return compProvinceName;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set updateTime UPDATE_TIME.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime UPDATE_TIME.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
