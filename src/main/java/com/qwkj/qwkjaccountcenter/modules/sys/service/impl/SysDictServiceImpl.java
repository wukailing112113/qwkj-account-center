/*
 * 项目名称:platform-plus
 * 类名称:SysDictServiceImpl.java
 * 包名称:com.qwkj.qwkjaccountcenter.modules.sys.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-15 11:42:20        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qwkj.qwkjaccountcenter.common.annotation.RedisCache;
import com.qwkj.qwkjaccountcenter.common.utils.JedisUtil;
import com.qwkj.qwkjaccountcenter.common.utils.Query;
import com.qwkj.qwkjaccountcenter.modules.sys.dao.SysDictDao;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysDictEntity;
import com.qwkj.qwkjaccountcenter.modules.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 数据字典Service实现类
 *
 * @author 李鹏军
 * @date 2019-01-15 11:42:20
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {
    @Autowired
    JedisUtil jedisUtil;

    @Override
    @RedisCache
    public List<SysDictEntity> queryAll(Map<String, Object> params) {
        return baseMapper.queryAll(params);
    }

    @Override
    public IPage queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "d.SORT");
        IPage<SysDictEntity> page = new Query<SysDictEntity>(params).getPage();
        return page.setRecords(baseMapper.selectDictPage(page, params));
    }

    @Override
    public void add(SysDictEntity sysDict) {
        this.save(sysDict);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictEntity sysDict) {
        this.updateById(sysDict);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    public void delete(String id) {
        this.removeById(id);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] ids) {
        this.removeByIds(Arrays.asList(ids));
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    public List<SysDictEntity> queryByCode(Map<String, Object> params) {
        return baseMapper.queryByCode(params);
    }
}
