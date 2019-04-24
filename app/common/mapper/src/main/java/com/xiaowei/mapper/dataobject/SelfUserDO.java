package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfUserDO;

/**
 * The table 自助服务-用户
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfUserDO{

    /**
     * id 登录名.
     */
    private Long id;
    /**
     * compId 企业id.
     */
    private Long compId;
    /**
     * uuid UUID.
     */
    private String uuid;
    /**
     * state 状态 0启用  1禁用.
     */
    private String state;
    /**
     * remark REMARK.
     */
    private String remark;
    /**
     * uPhone 手机号.
     */
    private String uPhone;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * nameTop 顶部名称.
     */
    private String nameTop;
    /**
     * createBy CREATE_BY.
     */
    private String createBy;
    /**
     * updateBy UPDATE_BY.
     */
    private String updateBy;
    /**
     * uAuthSalt 撒盐.
     */
    private String uAuthSalt;
    /**
     * uLoginPwd 密码.
     */
    private String uLoginPwd;
    /**
     * uNickname 昵称.
     */
    private String uNickname;
    /**
     * nameBottom 版权.
     */
    private String nameBottom;
    /**
     * uLoginName 登录名.
     */
    private String uLoginName;
    /**
     * uRegistType 注册来源 0平台注册 1自己注册 2自己企业添加.
     */
    private String uRegistType;
    /**
     * sysLoginNumber 账号允许登录的次数 -1 不限次数 ，如需登录次数为0，请禁用该账号，减少代码复杂度.
     */
    private Integer sysLoginNumber;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

    /**
     * Set id 登录名.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 登录名.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set compId 企业id.
     */
    public void setCompId(Long compId){
        this.compId = compId;
    }

    /**
     * Get compId 企业id.
     *
     * @return the string
     */
    public Long getCompId(){
        return compId;
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
     * Set remark REMARK.
     */
    public void setRemark(String remark){
        this.remark = remark;
    }

    /**
     * Get remark REMARK.
     *
     * @return the string
     */
    public String getRemark(){
        return remark;
    }

    /**
     * Set uPhone 手机号.
     */
    public void setUPhone(String uPhone){
        this.uPhone = uPhone;
    }

    /**
     * Get uPhone 手机号.
     *
     * @return the string
     */
    public String getUPhone(){
        return uPhone;
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
     * Set nameTop 顶部名称.
     */
    public void setNameTop(String nameTop){
        this.nameTop = nameTop;
    }

    /**
     * Get nameTop 顶部名称.
     *
     * @return the string
     */
    public String getNameTop(){
        return nameTop;
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
     * Set uAuthSalt 撒盐.
     */
    public void setUAuthSalt(String uAuthSalt){
        this.uAuthSalt = uAuthSalt;
    }

    /**
     * Get uAuthSalt 撒盐.
     *
     * @return the string
     */
    public String getUAuthSalt(){
        return uAuthSalt;
    }

    /**
     * Set uLoginPwd 密码.
     */
    public void setULoginPwd(String uLoginPwd){
        this.uLoginPwd = uLoginPwd;
    }

    /**
     * Get uLoginPwd 密码.
     *
     * @return the string
     */
    public String getULoginPwd(){
        return uLoginPwd;
    }

    /**
     * Set uNickname 昵称.
     */
    public void setUNickname(String uNickname){
        this.uNickname = uNickname;
    }

    /**
     * Get uNickname 昵称.
     *
     * @return the string
     */
    public String getUNickname(){
        return uNickname;
    }

    /**
     * Set nameBottom 版权.
     */
    public void setNameBottom(String nameBottom){
        this.nameBottom = nameBottom;
    }

    /**
     * Get nameBottom 版权.
     *
     * @return the string
     */
    public String getNameBottom(){
        return nameBottom;
    }

    /**
     * Set uLoginName 登录名.
     */
    public void setULoginName(String uLoginName){
        this.uLoginName = uLoginName;
    }

    /**
     * Get uLoginName 登录名.
     *
     * @return the string
     */
    public String getULoginName(){
        return uLoginName;
    }

    /**
     * Set uRegistType 注册来源 0平台注册 1自己注册 2自己企业添加.
     */
    public void setURegistType(String uRegistType){
        this.uRegistType = uRegistType;
    }

    /**
     * Get uRegistType 注册来源 0平台注册 1自己注册 2自己企业添加.
     *
     * @return the string
     */
    public String getURegistType(){
        return uRegistType;
    }

    /**
     * Set sysLoginNumber 账号允许登录的次数 -1 不限次数 ，如需登录次数为0，请禁用该账号，减少代码复杂度.
     */
    public void setSysLoginNumber(Integer sysLoginNumber){
        this.sysLoginNumber = sysLoginNumber;
    }

    /**
     * Get sysLoginNumber 账号允许登录的次数 -1 不限次数 ，如需登录次数为0，请禁用该账号，减少代码复杂度.
     *
     * @return the string
     */
    public Integer getSysLoginNumber(){
        return sysLoginNumber;
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
