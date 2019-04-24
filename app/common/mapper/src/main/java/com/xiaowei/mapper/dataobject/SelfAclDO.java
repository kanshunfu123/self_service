package com.xiaowei.mapper.dataobject;

import java.util.Date;
import com.xiaowei.mapper.dataobject.SelfAclDO;

/**
 * The table 权限点表
 * 注意:此结构有系统生成,禁止手工修改,以免被覆盖,请通过dalgen生成
 */
public class SelfAclDO{

    /**
     * id 权限id.
     */
    private Long id;
    /**
     * sysAclModuleType 菜单系统类型 1 系统管理 2资产管理.
     */
    private Long sysAclModuleType;
    /**
     * sysAclModuleParentId 上级权限id.
     */
    private Long sysAclModuleParentId;
    /**
     * name 页面名称(前端控制).
     */
    private String name;
    /**
     * remark 备注.
     */
    private String remark;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * createBy 创建人.
     */
    private String createBy;
    /**
     * updateBy 修改人.
     */
    private String updateBy;
    /**
     * sysAclUrl 请求的url, 可以填正则表达式.
     */
    private String sysAclUrl;
    /**
     * sysAclCode 权限码.
     */
    private String sysAclCode;
    /**
     * sysAclIcon 图标class.
     */
    private String sysAclIcon;
    /**
     * sysAclName 权限名称.
     */
    private String sysAclName;
    /**
     * sysAclType 类型，1：菜单，2：按钮，3：其他.
     */
    private String sysAclType;
    /**
     * sysAclUuid 唯一，32位字符串，查询用.
     */
    private String sysAclUuid;
    /**
     * sysAclState 状态 0启用  1禁用.
     */
    private String sysAclState;
    /**
     * sysAclAction 按钮动作类型(交给前端处理）.
     */
    private String sysAclAction;
    /**
     * sysAclRouter 所属页面(交给前端处理).
     */
    private String sysAclRouter;
    /**
     * sysAclModuleLevel 权限模块层级.
     */
    private String sysAclModuleLevel;
    /**
     * sysAclSeq 权限在当前模块下的顺序，由小到大.
     */
    private Integer sysAclSeq;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * updateTime 修改时间.
     */
    private Date updateTime;

    /**
     * Set id 权限id.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 权限id.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set sysAclModuleType 菜单系统类型 1 系统管理 2资产管理.
     */
    public void setSysAclModuleType(Long sysAclModuleType){
        this.sysAclModuleType = sysAclModuleType;
    }

    /**
     * Get sysAclModuleType 菜单系统类型 1 系统管理 2资产管理.
     *
     * @return the string
     */
    public Long getSysAclModuleType(){
        return sysAclModuleType;
    }

    /**
     * Set sysAclModuleParentId 上级权限id.
     */
    public void setSysAclModuleParentId(Long sysAclModuleParentId){
        this.sysAclModuleParentId = sysAclModuleParentId;
    }

    /**
     * Get sysAclModuleParentId 上级权限id.
     *
     * @return the string
     */
    public Long getSysAclModuleParentId(){
        return sysAclModuleParentId;
    }

    /**
     * Set name 页面名称(前端控制).
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 页面名称(前端控制).
     *
     * @return the string
     */
    public String getName(){
        return name;
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
     * Set createBy 创建人.
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * Get createBy 创建人.
     *
     * @return the string
     */
    public String getCreateBy(){
        return createBy;
    }

    /**
     * Set updateBy 修改人.
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * Get updateBy 修改人.
     *
     * @return the string
     */
    public String getUpdateBy(){
        return updateBy;
    }

    /**
     * Set sysAclUrl 请求的url, 可以填正则表达式.
     */
    public void setSysAclUrl(String sysAclUrl){
        this.sysAclUrl = sysAclUrl;
    }

    /**
     * Get sysAclUrl 请求的url, 可以填正则表达式.
     *
     * @return the string
     */
    public String getSysAclUrl(){
        return sysAclUrl;
    }

    /**
     * Set sysAclCode 权限码.
     */
    public void setSysAclCode(String sysAclCode){
        this.sysAclCode = sysAclCode;
    }

    /**
     * Get sysAclCode 权限码.
     *
     * @return the string
     */
    public String getSysAclCode(){
        return sysAclCode;
    }

    /**
     * Set sysAclIcon 图标class.
     */
    public void setSysAclIcon(String sysAclIcon){
        this.sysAclIcon = sysAclIcon;
    }

    /**
     * Get sysAclIcon 图标class.
     *
     * @return the string
     */
    public String getSysAclIcon(){
        return sysAclIcon;
    }

    /**
     * Set sysAclName 权限名称.
     */
    public void setSysAclName(String sysAclName){
        this.sysAclName = sysAclName;
    }

    /**
     * Get sysAclName 权限名称.
     *
     * @return the string
     */
    public String getSysAclName(){
        return sysAclName;
    }

    /**
     * Set sysAclType 类型，1：菜单，2：按钮，3：其他.
     */
    public void setSysAclType(String sysAclType){
        this.sysAclType = sysAclType;
    }

    /**
     * Get sysAclType 类型，1：菜单，2：按钮，3：其他.
     *
     * @return the string
     */
    public String getSysAclType(){
        return sysAclType;
    }

    /**
     * Set sysAclUuid 唯一，32位字符串，查询用.
     */
    public void setSysAclUuid(String sysAclUuid){
        this.sysAclUuid = sysAclUuid;
    }

    /**
     * Get sysAclUuid 唯一，32位字符串，查询用.
     *
     * @return the string
     */
    public String getSysAclUuid(){
        return sysAclUuid;
    }

    /**
     * Set sysAclState 状态 0启用  1禁用.
     */
    public void setSysAclState(String sysAclState){
        this.sysAclState = sysAclState;
    }

    /**
     * Get sysAclState 状态 0启用  1禁用.
     *
     * @return the string
     */
    public String getSysAclState(){
        return sysAclState;
    }

    /**
     * Set sysAclAction 按钮动作类型(交给前端处理）.
     */
    public void setSysAclAction(String sysAclAction){
        this.sysAclAction = sysAclAction;
    }

    /**
     * Get sysAclAction 按钮动作类型(交给前端处理）.
     *
     * @return the string
     */
    public String getSysAclAction(){
        return sysAclAction;
    }

    /**
     * Set sysAclRouter 所属页面(交给前端处理).
     */
    public void setSysAclRouter(String sysAclRouter){
        this.sysAclRouter = sysAclRouter;
    }

    /**
     * Get sysAclRouter 所属页面(交给前端处理).
     *
     * @return the string
     */
    public String getSysAclRouter(){
        return sysAclRouter;
    }

    /**
     * Set sysAclModuleLevel 权限模块层级.
     */
    public void setSysAclModuleLevel(String sysAclModuleLevel){
        this.sysAclModuleLevel = sysAclModuleLevel;
    }

    /**
     * Get sysAclModuleLevel 权限模块层级.
     *
     * @return the string
     */
    public String getSysAclModuleLevel(){
        return sysAclModuleLevel;
    }

    /**
     * Set sysAclSeq 权限在当前模块下的顺序，由小到大.
     */
    public void setSysAclSeq(Integer sysAclSeq){
        this.sysAclSeq = sysAclSeq;
    }

    /**
     * Get sysAclSeq 权限在当前模块下的顺序，由小到大.
     *
     * @return the string
     */
    public Integer getSysAclSeq(){
        return sysAclSeq;
    }

    /**
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set updateTime 修改时间.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime 修改时间.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
