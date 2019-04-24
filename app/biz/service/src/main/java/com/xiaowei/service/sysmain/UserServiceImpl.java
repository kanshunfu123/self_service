package com.xiaowei.service.sysmain;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xiaowei.common.common.DateUtils;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.error.BizException;
import com.xiaowei.common.error.RegisterException;
import com.xiaowei.common.req.RedisUser;
import com.xiaowei.common.req.authority.BatchRoleUserReq;
import com.xiaowei.common.req.authority.RoleReq;
import com.xiaowei.common.req.sysmain.RegisterUserReq;
import com.xiaowei.common.util.DateUtil;
import com.xiaowei.common.util.Encrypt;
import com.xiaowei.common.util.JwtTokenUtil;
import com.xiaowei.common.util.StrUtil;
import com.xiaowei.mapper.dao.SelfAclDefaultDAO;
import com.xiaowei.mapper.dao.SelfCompanyDAO;
import com.xiaowei.mapper.dao.SelfRoleUserDAO;
import com.xiaowei.mapper.dao.SelfUserDAO;
import com.xiaowei.mapper.dataobject.*;
import com.xiaowei.mapper.mapper.authority.AuthorityMapper;
import com.xiaowei.mapper.mapper.authority.RoleMapper;
import com.xiaowei.mapper.mapper.roleuser.RoleUserMapper;
import com.xiaowei.service.authority.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by MOMO on 2019/4/10.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private SelfUserDAO selfUserDAO;
    @Autowired
    private SelfCompanyDAO selfCompanyDAO;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SelfAclDefaultDAO selfAclDefaultDAO;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public JSONResult checkLoginName(RegisterUserReq registerUserReq) {
        SelfUserDO insertselfUserDO = new SelfUserDO();
        BeanUtils.copyProperties(registerUserReq, insertselfUserDO);
        SelfUserDO selfUserDO = selfUserDAO.login(insertselfUserDO.getULoginName());
        if (null != selfUserDO) {
            return JSONResult.errorMap("登录账号已存在");
        }
        return JSONResult.ok("登录账号可以使用");
    }

    @Transactional
    @Override
    public JSONResult register(RegisterUserReq registerUserReq, RedisUser redisUser) {
        SelfCompanyDO insertSelfCompanyDO = new SelfCompanyDO();
        BeanUtils.copyProperties(registerUserReq, insertSelfCompanyDO);
        final String randomKey = jwtTokenUtil.getRandomKey();
        String pwd = Encrypt.getShiroPassword(registerUserReq.getULoginPwd(), randomKey, 5);
        SelfUserDO insertselfUserDO = new SelfUserDO();
        BeanUtils.copyProperties(registerUserReq, insertselfUserDO);
        insertselfUserDO.setULoginPwd(pwd);
        insertselfUserDO.setUAuthSalt(randomKey);
        insertselfUserDO.setUPhone(registerUserReq.getCompPhone());
        if (StringUtils.isEmpty(registerUserReq.getUNickname())) {
            insertselfUserDO.setUNickname(registerUserReq.getCompContacts());
        }
        insertselfUserDO.setCompId(insertSelfCompanyDO.getId());

        int userPhone = selfUserDAO.checkUser(insertselfUserDO);
        if (userPhone > 0) {
            return JSONResult.errorMap("用户手机号已存在");
        }
        int compNameCount = selfCompanyDAO.checkComp(insertSelfCompanyDO.getCompName(), null, null);
        if (compNameCount > 0) {
            return JSONResult.errorMap("企业名称已存在");
        }
        int emailCount = selfCompanyDAO.checkComp(null, insertSelfCompanyDO.getCompEmail(), null);
        if (emailCount > 0) {
            return JSONResult.errorMap("企业邮箱已存在");
        }
        int phoneCount = selfCompanyDAO.checkComp(null, null, insertSelfCompanyDO.getCompPhone());
        if (phoneCount > 0) {
            return JSONResult.errorMap("企业手机号已存在");
        }
        insertSelfCompanyDO.setCreateBy(redisUser.getSysUserName());
        insertSelfCompanyDO.setUpdateBy(redisUser.getSysUserName());
        insertSelfCompanyDO.setCreateTime(DateUtil.getDateTime());
        insertSelfCompanyDO.setUpdateTime(DateUtil.getDateTime());
        insertSelfCompanyDO.setUuid(StrUtil.genUUID());

        insertselfUserDO.setCreateBy(redisUser.getSysUserName());
        insertselfUserDO.setUpdateBy(redisUser.getSysUserName());
        insertselfUserDO.setCreateTime(DateUtil.getDateTime());
        insertselfUserDO.setUpdateTime(DateUtil.getDateTime());
        insertselfUserDO.setUuid(StrUtil.genUUID());

        selfCompanyDAO.insertSelective(insertSelfCompanyDO);

        insertselfUserDO.setCompId(insertSelfCompanyDO.getId());
        selfUserDAO.insertSelective(insertselfUserDO);
        RoleReq roleReq = new RoleReq();
        roleReq.setCompId(insertSelfCompanyDO.getId());
        roleReq.setRoleName("管理员");
        String roleUuid = StrUtil.genUUID();
        roleReq.setUuid(roleUuid);
        //角色的类型，0：管理员角色，1：普通用户 2其他
        roleReq.setRoleType("0");
        //状态 0启用  1禁用
        roleReq.setStatus("0");
        redisUser.setGroupId(insertSelfCompanyDO.getId());
        if (checkRoleName(roleReq.getRoleName(), null, redisUser.getGroupId())) {
            throw new BizException("角色名称已存在");
        }
        //角色的类型，0：管理员角色，1：普通用户 2其他
        if (checkAdminRole("0", null, redisUser.getGroupId())) {
            throw new BizException("管理员角色已存在");
        }
        SelfRoleDO record = new SelfRoleDO();
        BeanUtils.copyProperties(roleReq, record);
        record.setCreateBy(redisUser.getSysUserName());
        record.setUpdateBy(redisUser.getSysUserName());
        record.setCreateTime(DateUtil.getDateTime());
        record.setUpdateTime(DateUtil.getDateTime());
        record.setCompId(redisUser.getGroupId());
        roleMapper.insertSelective(record);

        List<SelfRoleUserDO> selfRoleUserDOList = Lists.newArrayList();
        SelfRoleUserDO selfRoleUserDO = new SelfRoleUserDO();
        selfRoleUserDO.setCompId(insertSelfCompanyDO.getId());
        selfRoleUserDO.setRoleId(record.getId());
        selfRoleUserDO.setCreateTime(DateUtils.getCurrentDateTime());
        selfRoleUserDO.setUserId(insertselfUserDO.getId());
        selfRoleUserDOList.add(selfRoleUserDO);
        roleUserMapper.batchaddRoleUser(selfRoleUserDOList);

        BatchRoleUserReq batchRoleUserReq = new BatchRoleUserReq();
        List<SelfAclDefaultDO> acls = selfAclDefaultDAO.getAll();
        List<SelfRoleAclDO> aclsa = Lists.newArrayList();
        acls.forEach(selfAclDefaultDO -> {
            SelfRoleAclDO selfRoleAclDO = new SelfRoleAclDO();
            selfRoleAclDO.setSysAclId(selfAclDefaultDO.getAclId());
            selfRoleAclDO.setSysAclPermissionType(selfAclDefaultDO.getSysAclModuleType());
            aclsa.add(selfRoleAclDO);
        });
        batchRoleUserReq.setAcls(aclsa);
        batchRoleUserReq.setRoleUuid(roleUuid);
        JSONResult aclResult = aclsToRole(batchRoleUserReq, redisUser, record);

        if (aclResult.isOK()) {
            return JSONResult.ok("注册成功");
        }
        throw new BizException("注册失败");
    }

    public boolean checkRoleName(String roleName, Long id, Long compId) {
        return roleMapper.checkRoleName(roleName, id, compId) > 0 ? true : false;
    }

    public boolean checkAdminRole(String roleType, Long id, Long compId) {
        return roleMapper.checkAdminRole(id, roleType, compId) > 0 ? true : false;
    }

    public JSONResult aclsToRole(BatchRoleUserReq batchRoleUserReq, RedisUser redisUser, SelfRoleDO roleDO) {

        List<SelfRoleAclDO> roleAclDOS = batchRoleUserReq.getAcls();
        List<Long> acls = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roleAclDOS)) {
            roleAclDOS.forEach(roleAclDO -> {
                acls.add(roleAclDO.getSysAclId());
            });
        }
        List<Long> originAclIdList = authorityMapper.aclsByRoleId(Arrays.asList(roleDO.getId()), null);
        if (originAclIdList.size() == acls.size()) {
            Set<Long> originAclIdSet = Sets.newHashSet(originAclIdList);
            Set<Long> aclIdSet = Sets.newHashSet(acls);
            originAclIdSet.removeAll(aclIdSet);
            if (CollectionUtils.isEmpty(originAclIdSet)) {
                return JSONResult.ok("为角色授权权限成功");
            }
        }
        updateRoleAcls(roleDO.getId(), roleAclDOS, redisUser, roleDO.getCompId(), acls);
        return JSONResult.ok("为角色授权权限成功");
    }

    @Transactional
    public void updateRoleAcls(Long roleId, List<SelfRoleAclDO> aclIdList, RedisUser redisUser, Long groupId, List<Long> acls) {
        roleMapper.deleteRoleAclsByRoleId(roleId);

        if (CollectionUtils.isEmpty(aclIdList)) {
            return;
        }
        List<SelfRoleAclDO> roleUserList = Lists.newArrayList();
        for (SelfRoleAclDO aclId : aclIdList) {
            SelfRoleAclDO roleUserDO = new SelfRoleAclDO();
            roleUserDO.setDelFlag("0");
            roleUserDO.setGroupId(groupId);
            roleUserDO.setSysAclId(aclId.getSysAclId());
            roleUserDO.setSysRoleId(roleId);
            roleUserDO.setSysAclPermissionType(aclId.getSysAclPermissionType());
            roleUserDO.setSysRoleAclUuid(StrUtil.genUUID());
            roleUserDO.setCreateBy(redisUser.getSysUserName());
            roleUserDO.setUpdateBy(redisUser.getSysUserName());
            roleUserDO.setUpdateTime(DateUtil.getDateTime());
            roleUserDO.setCreateTime(DateUtil.getDateTime());
            roleUserList.add(roleUserDO);
        }
        roleMapper.batchInsertRoleAcls(roleUserList);
    }
}
