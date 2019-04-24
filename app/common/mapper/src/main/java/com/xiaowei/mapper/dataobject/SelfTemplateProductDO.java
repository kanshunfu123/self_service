package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfTemplateProductDO;

/**
 * The table 产品属性模板
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfTemplateProductDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * parentId 父级id.
     */
    private Long parentId;
    /**
     * productId 产品id.
     */
    private Long productId;
    /**
     * templateMainId 主模板id.
     */
    private Long templateMainId;
    /**
     * parameterTypeId 属性数据类型（数据字典id）.
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
     * isDefine 0系统  1自定义.
     */
    private Integer isDefine;
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
     * Set productId 产品id.
     */
    public void setProductId(Long productId){
        this.productId = productId;
    }

    /**
     * Get productId 产品id.
     *
     * @return the string
     */
    public Long getProductId(){
        return productId;
    }

    /**
     * Set templateMainId 主模板id.
     */
    public void setTemplateMainId(Long templateMainId){
        this.templateMainId = templateMainId;
    }

    /**
     * Get templateMainId 主模板id.
     *
     * @return the string
     */
    public Long getTemplateMainId(){
        return templateMainId;
    }

    /**
     * Set parameterTypeId 属性数据类型（数据字典id）.
     */
    public void setParameterTypeId(Long parameterTypeId){
        this.parameterTypeId = parameterTypeId;
    }

    /**
     * Get parameterTypeId 属性数据类型（数据字典id）.
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
     * Set isDefine 0系统  1自定义.
     */
    public void setIsDefine(Integer isDefine){
        this.isDefine = isDefine;
    }

    /**
     * Get isDefine 0系统  1自定义.
     *
     * @return the string
     */
    public Integer getIsDefine(){
        return isDefine;
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
