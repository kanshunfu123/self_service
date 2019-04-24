package com.xiaowei.common.res.template;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/12
 */
public class TemplateRes implements Serializable {
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
     * isSelect 是否选择 0不必选 1选择.
     */
    private Integer isSelect;
    /**
     * attributeIsWrite 是否必填 0否 1必.
     */
    private Integer attributeIsWrite;
    /**
     *是否禁用 1禁用   0不禁用
     * */
    private Integer isDisable;
    /**
     * 是否是自定义
     * */
    private Integer isDefine;
    /**
     * 子级
     * */
    private List<TemplateRes>children;

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

    public Long getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(Long parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
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

    public Integer getAttributeIsWrite() {
        return attributeIsWrite;
    }

    public void setAttributeIsWrite(Integer attributeIsWrite) {
        this.attributeIsWrite = attributeIsWrite;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getIsDefine() {
        return isDefine;
    }

    public void setIsDefine(Integer isDefine) {
        this.isDefine = isDefine;
    }

    public List<TemplateRes> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateRes> children) {
        this.children = children;
    }
}
