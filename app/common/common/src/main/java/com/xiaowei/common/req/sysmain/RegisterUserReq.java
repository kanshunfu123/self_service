package com.xiaowei.common.req.sysmain;

import com.xiaowei.common.error.BaseReq;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by MOMO on 2019/4/10.
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = {"id"})
public class RegisterUserReq extends BaseReq {

    /**
     * uPhone 手机号.
     */
    private String uPhone;
    /**
     * nameTop 顶部名称.
     */
    private String nameTop;
    /**
     * uLoginPwd 密码.
     */
    @NotBlank(message = "密码必填",groups = {save.class})
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
    @NotBlank(message = "登录账号 必填",groups = {save.class,Query.class})
    private String uLoginName;
    /**
     * compRegistType 注册来源 0平台注册 1自己注册.
     */
    private String compRegistType;
    /**
     * sysLoginNumber 账号允许登录的次数 -1 不限次数 ，如需登录次数为0，请禁用该账号，减少代码复杂度.
     */
    private Integer sysLoginNumber=-1;

    /**
     * compArea 区域id.
     */
    @NotNull(message = "区域id 必填",groups = {save.class})
    private Long compArea;
    /**
     * compCity 市id.
     */
    @NotNull(message = "市id 必填",groups = {save.class})
    private Long compCity;
    /**
     * compProvince 省id.
     */
    @NotNull(message = "省id必填",groups = {save.class})
    private Long compProvince;
    /**
     * compStreetId 街道id.
     */
    @NotNull(message = "街道id必填",groups = {save.class})
    private Long compStreetId;

    /**
     * state 状态 0启用  1禁用.
     */
    private String state="0";

    /**
     * compName 企业名称.
     */
    @NotBlank(message = "企业名称必填",groups = {save.class})
    private String compName;

    /**
     * compEmail 邮箱.
     */
    @NotBlank(message = "邮箱必填",groups = {save.class})
    @Email(message = "邮箱格式不正确",groups = {save.class})
    private String compEmail;
    /**
     * compPhone 手机号.
     */
    @NotBlank(message = "企业手机号必填",groups = {save.class})
    private String compPhone;
    /**
     * compStreet 街道.
     */
    @NotBlank(message = "街道 名称必填",groups = {save.class})
    private String compStreet;
    /**
     * compAddress 详细地址.
     */
    private String compAddress;
    /**
     * compAreaName 区域.
     */
    @NotBlank(message = "区域名称必填",groups = {save.class})
    private String compAreaName;
    /**
     * compCityName 市.
     */
    @NotBlank(message = "市必填",groups = {save.class})
    private String compCityName;
    /**
     * compContacts 联系人.
     */
    @NotBlank(message = "联系人必填",groups = {save.class})
    private String compContacts;
    /**
     * compProvinceName 省名称.
     */
    @NotBlank(message = "省名称必填",groups = {save.class})
    private String compProvinceName;

}
