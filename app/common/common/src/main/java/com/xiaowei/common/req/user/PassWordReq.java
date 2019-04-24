package com.xiaowei.common.req.user;

import com.xiaowei.common.error.BaseReq;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
/**
 * Created by kanshunfu on 2019/4/15.
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassWordReq extends BaseReq implements Serializable {
    /**
     * id 主键.
     */
    private Long id;
    @NotBlank(message = "sysUserPwd 密码必填",groups = {Add.class})
    private String sysUserPwd;
    private String uNickname;
    @NotBlank(message = " uuid必填",groups = {Delete.class})
    private String uuid;

}
