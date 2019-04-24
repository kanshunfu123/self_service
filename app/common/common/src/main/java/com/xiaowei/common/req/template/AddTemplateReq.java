package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import java.io.Serializable;
import java.util.List;

/**
 * created by 韩金群 2019/4/9
 */
public class AddTemplateReq extends BaseReq implements Serializable {
    /**
     * templateMainId 主模板id.
     */
    private Long templateMainId;
    /**
     * templateType 1设备属性 2场景属性 3业务属性.
     */
    private String templateType;
    /**
     * attributeDesc 描述.
     */
    private String attributeDesc;
    /**
     * 属性类型（数据字典id）
     * */
    private Long parameterTypeId;

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
     * attributeIsWrite 是否必填 0否 1必.
     */
    private Integer attributeIsWrite;
    /**
     * 0系统  1自定义
     * */
    private Integer isDefine;
    private List<AddTemplateReq>children;

    public Long getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(Long parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public Integer getIsDefine() {
        return isDefine;
    }

    public void setIsDefine(Integer isDefine) {
        this.isDefine = isDefine;
    }

    public Long getTemplateMainId() {
        return templateMainId;
    }

    public void setTemplateMainId(Long templateMainId) {
        this.templateMainId = templateMainId;
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

    public Integer getAttributeIsWrite() {
        return attributeIsWrite;
    }

    public void setAttributeIsWrite(Integer attributeIsWrite) {
        this.attributeIsWrite = attributeIsWrite;
    }

    public List<AddTemplateReq> getChildren() {
        return children;
    }

    public void setChildren(List<AddTemplateReq> children) {
        this.children = children;
    }
}
