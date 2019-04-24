package com.xiaowei.mapper.dataobject;

import java.util.Date;

/**
 * The table 产品属性主模板
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfTemplateMainDO {

    /**
     * id ID.
     */
    private Long id;
    /**
     * parentId 父级id.
     */
    private Long parentId;
    /**
     * parameterTypeId 属性类型id（数据字典）.
     */
    private Long parameterTypeId;
    /**
     * uuid uuid.
     */
    private String uuid;
    /**
     * delFlag 0正常 1删除.
     */
    private String delFlag;
    /**
     * createBy CREATE_BY.
     */
    private String createBy;
    /**
     * updateBy UPDATE_BY.
     */
    private String updateBy;
    /**
     * codeLevel 字典层级关系.
     */
    private String codeLevel;
    /**
     * templateType 1设备属性 2场景属性 3业务属性.
     */
    private String templateType;
    /**
     * attributeDesc 描述.
     */
    private String attributeDesc;
    /**
     * attributeType 属性类型.
     */
    private String attributeType;
    /**
     * attributeUnit 单位.
     */
    private String attributeUnit;
    /**
     * attributeEname 英文属性名称.
     */
    private String attributeEname;
    /**
     * attributeShort 简写.
     */
    private String attributeShort;
    /**
     * attributeZname 名称（中文）.
     */
    private String attributeZname;
    /**
     * attributeDefaults 默认值.
     */
    private String attributeDefaults;
    /**
     * isSelect 是否必选 0不必选 1必选.
     */
    private Integer isSelect;
    /**
     * isDisable 1禁用 0不禁用(禁用指是否可勾选).
     */
    private Integer isDisable;
    /**
     * attributeIsWrite 是否必填 0否 1必.
     */
    private Integer attributeIsWrite;
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
     * Set parentId 父级id.
     */
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    /**
     * Get parentId 父级id.
     *
     * @return the string
     */
    public Long getParentId(){
        return parentId;
    }

    /**
     * Set parameterTypeId 属性类型id（数据字典）.
     */
    public void setParameterTypeId(Long parameterTypeId){
        this.parameterTypeId = parameterTypeId;
    }

    /**
     * Get parameterTypeId 属性类型id（数据字典）.
     *
     * @return the string
     */
    public Long getParameterTypeId(){
        return parameterTypeId;
    }

    /**
     * Set uuid uuid.
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid uuid.
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set delFlag 0正常 1删除.
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 0正常 1删除.
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
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
     * Set codeLevel 字典层级关系.
     */
    public void setCodeLevel(String codeLevel){
        this.codeLevel = codeLevel;
    }

    /**
     * Get codeLevel 字典层级关系.
     *
     * @return the string
     */
    public String getCodeLevel(){
        return codeLevel;
    }

    /**
     * Set templateType 1设备属性 2场景属性 3业务属性.
     */
    public void setTemplateType(String templateType){
        this.templateType = templateType;
    }

    /**
     * Get templateType 1设备属性 2场景属性 3业务属性.
     *
     * @return the string
     */
    public String getTemplateType(){
        return templateType;
    }

    /**
     * Set attributeDesc 描述.
     */
    public void setAttributeDesc(String attributeDesc){
        this.attributeDesc = attributeDesc;
    }

    /**
     * Get attributeDesc 描述.
     *
     * @return the string
     */
    public String getAttributeDesc(){
        return attributeDesc;
    }

    /**
     * Set attributeType 属性类型.
     */
    public void setAttributeType(String attributeType){
        this.attributeType = attributeType;
    }

    /**
     * Get attributeType 属性类型.
     *
     * @return the string
     */
    public String getAttributeType(){
        return attributeType;
    }

    /**
     * Set attributeUnit 单位.
     */
    public void setAttributeUnit(String attributeUnit){
        this.attributeUnit = attributeUnit;
    }

    /**
     * Get attributeUnit 单位.
     *
     * @return the string
     */
    public String getAttributeUnit(){
        return attributeUnit;
    }

    /**
     * Set attributeEname 英文属性名称.
     */
    public void setAttributeEname(String attributeEname){
        this.attributeEname = attributeEname;
    }

    /**
     * Get attributeEname 英文属性名称.
     *
     * @return the string
     */
    public String getAttributeEname(){
        return attributeEname;
    }

    /**
     * Set attributeShort 简写.
     */
    public void setAttributeShort(String attributeShort){
        this.attributeShort = attributeShort;
    }

    /**
     * Get attributeShort 简写.
     *
     * @return the string
     */
    public String getAttributeShort(){
        return attributeShort;
    }

    /**
     * Set attributeZname 名称（中文）.
     */
    public void setAttributeZname(String attributeZname){
        this.attributeZname = attributeZname;
    }

    /**
     * Get attributeZname 名称（中文）.
     *
     * @return the string
     */
    public String getAttributeZname(){
        return attributeZname;
    }

    /**
     * Set attributeDefaults 默认值.
     */
    public void setAttributeDefaults(String attributeDefaults){
        this.attributeDefaults = attributeDefaults;
    }

    /**
     * Get attributeDefaults 默认值.
     *
     * @return the string
     */
    public String getAttributeDefaults(){
        return attributeDefaults;
    }

    /**
     * Set isSelect 是否必选 0不必选 1必选.
     */
    public void setIsSelect(Integer isSelect){
        this.isSelect = isSelect;
    }

    /**
     * Get isSelect 是否必选 0不必选 1必选.
     *
     * @return the string
     */
    public Integer getIsSelect(){
        return isSelect;
    }

    /**
     * Set isDisable 1禁用 0不禁用(禁用指是否可勾选).
     */
    public void setIsDisable(Integer isDisable){
        this.isDisable = isDisable;
    }

    /**
     * Get isDisable 1禁用 0不禁用(禁用指是否可勾选).
     *
     * @return the string
     */
    public Integer getIsDisable(){
        return isDisable;
    }

    /**
     * Set attributeIsWrite 是否必填 0否 1必.
     */
    public void setAttributeIsWrite(Integer attributeIsWrite){
        this.attributeIsWrite = attributeIsWrite;
    }

    /**
     * Get attributeIsWrite 是否必填 0否 1必.
     *
     * @return the string
     */
    public Integer getAttributeIsWrite(){
        return attributeIsWrite;
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
