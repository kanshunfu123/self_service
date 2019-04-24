package com.xiaowei.common.req.sysmain;

import com.xiaowei.common.error.BaseReq;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Created by MOMO on 2019/4/9.
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = {"id"})
public class LoginReq extends BaseReq{
    /**
     * uLoginPwd 密码.
     */
    @NotBlank(message = "密码必填",groups = {Submit.class})
    private String loginPwd;
    /**
     * uLoginName 登录名.
     */
    @NotBlank(message = "登录名必填",groups = {Submit.class})
    private String loginName;
//    @NotBlank(message = "验证码不能为空",groups = {Submit.class})
    private String verificationCode;//验证码
    private String verUUidCode;//该验证码对应唯一一个用户
}
