/*
 * 项目名称:platform-plus
 * 类名称:TestTest1Controller.java
 * 包名称:com.platform.modules.test.controller
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-05-15 15:49:24        李鹏军     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qwkj.qwkjaccountcenter.common.annotation.SysLog;
import com.qwkj.qwkjaccountcenter.common.utils.RestResponse;
import com.qwkj.qwkjaccountcenter.modules.sys.controller.AbstractController;
import com.qwkj.qwkjaccountcenter.modules.test.entity.TestTest1Entity;
import com.qwkj.qwkjaccountcenter.modules.test.service.TestTest1Service;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 李鹏军
 * @date 2019-05-15 15:49:24
 */
@RestController
@RequestMapping("test/test1")
public class TestTest1Controller extends AbstractController {
    @Autowired
    private TestTest1Service testTest1Service;

    /**
     * 查看所有列表
     *
     * @param params 查询参数
     * @return RestResponse
     */
    @RequestMapping("/queryAll")
    @RequiresPermissions("test:test1:list")
    public RestResponse queryAll(@RequestParam Map<String, Object> params) {
        List<TestTest1Entity> list = testTest1Service.queryAll(params);

        return RestResponse.success().put("list", list);
    }

    /**
     * 分页查询
     * TestTest1Entity
     *
     * @param params 查询参数
     * @return RestResponse
     */
    @GetMapping("/list")
    @RequiresPermissions("test:test1:list")
    public RestResponse list(@RequestParam Map<String, Object> params) {
        Page page = testTest1Service.queryPage(params);

        return RestResponse.success().put("page", page);
    }

    /**
     * 根据主键查询详情
     *
     * @param id 主键
     * @return RestResponse
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:test1:info")
    public RestResponse info(@PathVariable("id") String id) {
        TestTest1Entity testTest1 = testTest1Service.getById(id);

        return RestResponse.success().put("test1", testTest1);
    }

    /**
     * 新增
     *
     * @param testTest1 testTest1
     * @return RestResponse
     */
    @SysLog("新增")
    @RequestMapping("/save")
    @RequiresPermissions("test:test1:save")
    public RestResponse save(@RequestBody TestTest1Entity testTest1) {

        testTest1Service.add(testTest1);

        return RestResponse.success();
    }

    /**
     * 修改
     *
     * @param testTest1 testTest1
     * @return RestResponse
     */
    @SysLog("修改")
    @RequestMapping("/update")
    @RequiresPermissions("test:test1:update")
    public RestResponse update(@RequestBody TestTest1Entity testTest1) {

        testTest1Service.update(testTest1);

        return RestResponse.success();
    }

    /**
     * 根据主键删除
     *
     * @param ids ids
     * @return RestResponse
     */
    @SysLog("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("test:test1:delete")
    public RestResponse delete(@RequestBody String[] ids) {
        testTest1Service.deleteBatch(ids);

        return RestResponse.success();
    }
}
