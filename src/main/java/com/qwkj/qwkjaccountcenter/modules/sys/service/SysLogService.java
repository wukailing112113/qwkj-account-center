/*
 * 项目名称:platform-plus
 * 类名称:SysLogService.java
 * 包名称:com.qwkj.qwkjaccountcenter.modules.sys.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qwkj.qwkjaccountcenter.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 * @author 李鹏军
 */
public interface SysLogService extends IService<SysLogEntity> {

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return IPage
     */
    IPage queryPage(Map<String, Object> params);
}
