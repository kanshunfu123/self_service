package com.xiaowei.common.res.authority;

import com.google.common.collect.Lists;
import com.xiaowei.mapper.dataobject.SelfAclDO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Kagome on 2019/3/23.
 * 权限点
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = {"id"})
public class AclDto extends SelfAclDO{

    private List<AclDto> children = Lists.newArrayList();
    // 是否要默认选中
    private boolean checked = false;

    // 是否有权限操作
    private boolean hasAcl = false;

    public static AclDto adapt(SelfAclDO acl) {
        AclDto dto = new AclDto();
        BeanUtils.copyProperties(acl, dto);
        return dto;
    }
}
