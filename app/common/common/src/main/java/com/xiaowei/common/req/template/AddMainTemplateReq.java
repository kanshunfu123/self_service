package com.xiaowei.common.req.template;

import com.xiaowei.common.error.BaseReq;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * created by 韩金群 2019/4/9
 */
public class AddMainTemplateReq extends BaseReq implements Serializable {
    /**
     * parentId 父级id.
     */
    @NotNull(message = "parentId不能为空",groups = {Add.class})
    private Long parentId;
    /**
     * templateType 1设备属性 2场景属性 3业务属性.
     */
    @NotBlank(message = "templateType不能为空",groups = {Add.class})
    private String templateType;
    /**
     * attributeDesc 描述.
     */
    private String attributeDesc;
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
    @NotBlank(message = "属性名称不能为空",groups = {Add.class})
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
    @NotNull(message = "isSelect不能为空",groups = {Add.class})
    private Integer isSelect;
    /**
     * attributeIsWrite 是否必填 0否 1必.
     */
    private Integer attributeIsWrite;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
}
