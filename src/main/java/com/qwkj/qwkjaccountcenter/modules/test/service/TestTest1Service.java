/*
 * 项目名称:platform-plus
 * 类名称:TestTest1Service.java
 * 包名称:com.platform.modules.test.service
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-05-15 15:49:24        李鹏军     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.test.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qwkj.qwkjaccountcenter.modules.test.entity.TestTest1Entity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 * @author 李鹏军
 * @date 2019-05-15 15:49:24
 */
public interface TestTest1Service extends IService<TestTest1Entity> {

    /**
     * 查询所有列表
     *
     * @param params 查询参数
     * @return List
     */
    List<TestTest1Entity> queryAll(Map<String, Object> params);

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return Page
     */
    Page queryPage(Map<String, Object> params);

    /**
     * 新增
     *
     * @param testTest1
     * @return 新增结果
     */
    boolean add(TestTest1Entity testTest1);

    /**
     * 根据主键更新
     *
     * @param testTest1
     * @return 更新结果
     */
    boolean update(TestTest1Entity testTest1);

    /**
     * 根据主键删除
     *
     * @param id id
     * @return 删除结果
     */
    boolean delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids ids
     * @return 删除结果
     */
    boolean deleteBatch(String[] ids);
}
