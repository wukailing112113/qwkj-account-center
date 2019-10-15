/*
 * 项目名称:platform-plus
 * 类名称:TestTest1ServiceImpl.java
 * 包名称:com.platform.modules.test.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-05-15 15:49:24        李鹏军     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.test.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qwkj.qwkjaccountcenter.common.utils.Query;
import com.qwkj.qwkjaccountcenter.modules.test.dao.TestTest1Dao;
import com.qwkj.qwkjaccountcenter.modules.test.entity.TestTest1Entity;
import com.qwkj.qwkjaccountcenter.modules.test.service.TestTest1Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author 李鹏军
 * @date 2019-05-15 15:49:24
 */
@Service("testTest1Service")
public class TestTest1ServiceImpl extends ServiceImpl<TestTest1Dao, TestTest1Entity> implements TestTest1Service {

    @Override
    public List<TestTest1Entity> queryAll(Map<String, Object> params) {
        return baseMapper.queryAll(params);
    }

    @Override
    public Page queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "T.id");
        params.put("asc", false);
        Page<TestTest1Entity> page = new Query<TestTest1Entity>(params).getPage();
        return page.setRecords(baseMapper.selectTestTest1Page(page, params));
    }

    @Override
    public boolean add(TestTest1Entity testTest1) {
        return this.save(testTest1);
    }

    @Override
    public boolean update(TestTest1Entity testTest1) {
        return this.updateById(testTest1);
    }

    @Override
    public boolean delete(Integer id) {
        return this.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteBatch(String[] ids) {
        return this.removeByIds(Arrays.asList(ids));
    }
}
