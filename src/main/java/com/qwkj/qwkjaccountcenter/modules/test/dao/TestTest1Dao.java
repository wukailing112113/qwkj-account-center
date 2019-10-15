/*
 * 项目名称:platform-plus
 * 类名称:TestTest1Dao.java
 * 包名称:com.platform.modules.test.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-05-15 15:49:24        李鹏军     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qwkj.qwkjaccountcenter.modules.test.entity.TestTest1Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 * @author 李鹏军
 * @date 2019-05-15 15:49:24
 */
@Mapper
public interface TestTest1Dao extends BaseMapper<TestTest1Entity> {

    /**
     * 查询所有列表
     *
     * @param params 查询参数
     * @return List
     */
    List<TestTest1Entity> queryAll(@Param("params") Map<String, Object> params);

    /**
     * 自定义分页查询
     *
     * @param page   分页参数
     * @param params 查询参数
     * @return List
     */
    List<TestTest1Entity> selectTestTest1Page(IPage page, @Param("params") Map<String, Object> params);
}
