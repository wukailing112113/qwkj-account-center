/*
 * 项目名称:platform-plus
 * 类名称:SysUserTokenServiceImpl.java
 * 包名称:com.qwkj.qwkjaccountcenter.modules.sys.service.impl
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qwkj.qwkjaccountcenter.common.utils.Constant;
import com.qwkj.qwkjaccountcenter.common.utils.Query;
import com.qwkj.qwkjaccountcenter.modules.dto.UserAccessDto;
import com.qwkj.qwkjaccountcenter.modules.sys.dao.SysUserTokenDao;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysUserTokenEntity;
import com.qwkj.qwkjaccountcenter.modules.sys.oauth2.TokenGenerator;
import com.qwkj.qwkjaccountcenter.modules.sys.service.ShiroService;
import com.qwkj.qwkjaccountcenter.modules.sys.service.SysUserTokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author 李鹏军
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

    @Autowired
    private ShiroService shiroService;

    @Override
    public String createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + Constant.EXPIRE * 1000);

        //判断是否生成过token
        SysUserTokenEntity tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        return token;
    }

    @Override
    public void logout(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

    @Override
    public Page queryPage(Map<String, Object> params) {
        Page<SysUserTokenEntity> page = new Query<SysUserTokenEntity>(params).getPage();

        params.put("nowDate", new Date());
        return page.setRecords(baseMapper.selectSysUserTokenPage(page, params));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String userId) {
        this.removeById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void offlineBatch(String[] userIds) {
        this.removeByIds(Arrays.asList(userIds));
    }

    @Override
    public UserAccessDto selectAccess(String token) {
        UserAccessDto userAccessDto = new UserAccessDto();
        SysUserTokenEntity sysUserTokenEntity = baseMapper.queryByToken(token);
        if (Objects.nonNull(sysUserTokenEntity)) {
            //用户权限列表
            Set<String> permsSet = shiroService.getUserPermissions(sysUserTokenEntity.getUserId());
            BeanUtils.copyProperties(sysUserTokenEntity, userAccessDto);
            userAccessDto.setPermsSet(permsSet);
        }
        return userAccessDto;
    }
}
