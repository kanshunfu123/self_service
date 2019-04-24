package com.xiaowei.mapper.mapper.authority;

import com.xiaowei.mapper.dataobject.SelfAclDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MOMO on 2019/4/9.
 */
public interface AclMapper {


    int insertSelective(SelfAclDO record);

    SelfAclDO selectByPrimaryKey(Long id);
    SelfAclDO selectByPrimaryUuid(String uuid);

    int updateByPrimaryKeySelective(SelfAclDO record);

    /**
     * 验证url是否唯一
     *
     * @param url
     * @param moduleType
     * @param id
     * @return
     */
    int checkUrl(@Param("url") String url, @Param("moduleType") Long moduleType, @Param("id") Long id);
    /**
     * 查询子孙level
     * @param aclModuleLevel
     * @return
     */
    public List<SelfAclDO> getChildAclModuleListByLevel(@Param("aclModuleLevel") String aclModuleLevel);
    /**
     * 批量更新 level
     * @param aclModuleDOS
     * @return
     */
    public int batchUpdateLevel(@Param("sysAclModuleList") List<SelfAclDO> aclModuleDOS);
}
