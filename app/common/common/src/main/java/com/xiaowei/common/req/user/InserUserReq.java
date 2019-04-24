package com.xiaowei.common.req.user;

import com.xiaowei.common.error.BaseReq;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by kanshunfu on 2019/4/11.
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InserUserReq extends BaseReq {

    /**
     * id 主键.
     */
    private Long id;
    /**
     * compId 关联企业id.
     */
    private Long compId;

    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * nameTop 顶部名称.
     */
    private String nameTop;

    /**
     * nameBottom 版权.
     */
    private String nameBottom;
    /**
     * sysUserPwd 密码.
     */
    @NotBlank(message = "sysUserPwd 密码必填",groups = {Add.class})
    private String sysUserPwd;
    /**
     * uNickname 昵称.
     */
    @NotBlank(message = "uNickname 密码必填",groups = {Add.class})
    private String uNickname;
    /**
     * state 是否被禁用  0否 1禁用.
     */
    private String state;
    /**
     * uLoginName 姓名.
     */
    @NotBlank(message = "uLoginName 登录名必填",groups = {Add.class, Modify.class})
    private String uLoginName;
    /**
     * sysUserUuid 唯一，32位字符串，查询用.
     */
    @NotBlank(message = " uuid必填",groups = {Delete.class})
    private String uuid;
    /**
     * uPhone 手机号.
     */
    @NotBlank(message = "uPhone 手机号必填",groups = {Add.class, Modify.class})
    private String uPhone;
    @NotNull(message = "roleId 角色id.必填",groups = {Add.class, Modify.class})
    private Long roleId;
    /**
     * 备注
     */
    private String remark;
    /**
     * uRegistType 注册来源 0平台注册 1自己注册 2自己企业添加.
     */
    private String uRegistType;

}
