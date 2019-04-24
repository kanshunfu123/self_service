package com.xiaowei.common.res.template;

import com.xiaowei.mapper.dataobject.SelfTemplateMainDO;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/9
 */
public class TemplateListRes implements Serializable {
    /**
     * id ID.
     */
    private Long id;
    /**
     * parentId 父级id.
     */
    private Long parentId;
    /**
     * uuid uuid.
     */
    private String uuid;
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
     * parameterTypeId 属性类型id（数据字典）.
     */
    private Long parameterTypeId;
    /**
     * attributeType 属性类型（String,Int等）.
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
     * 是否禁用 1禁用 0不禁用
     * */
    private Integer isDisable;

    /**
     * attributeIsWrite 是否必填 0否 1必.
     */
    private Integer attributeIsWrite;
    private List<TemplateListRes>children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeDesc(String attributeDesc) {
        this.attributeDesc = attributeDesc;
    }

    public Long getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(Long parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeUnit() {
        return attributeUnit;
    }

    public void setAttributeUnit(String attributeUnit) {
        this.attributeUnit = attributeUnit;
    }

    public String getAttributeEname() {
        return attributeEname;
    }

    public void setAttributeEname(String attributeEname) {
        this.attributeEname = attributeEname;
    }

    public String getAttributeShort() {
        return attributeShort;
    }

    public void setAttributeShort(String attributeShort) {
        this.attributeShort = attributeShort;
    }

    public String getAttributeZname() {
        return attributeZname;
    }

    public void setAttributeZname(String attributeZname) {
        this.attributeZname = attributeZname;
    }

    public String getAttributeDefaults() {
        return attributeDefaults;
    }

    public void setAttributeDefaults(String attributeDefaults) {
        this.attributeDefaults = attributeDefaults;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getAttributeIsWrite() {
        return attributeIsWrite;
    }

    public void setAttributeIsWrite(Integer attributeIsWrite) {
        this.attributeIsWrite = attributeIsWrite;
    }

    public List<TemplateListRes> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateListRes> children) {
        this.children = children;
    }
}
