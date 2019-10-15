/*
 * 项目名称:platform-plus
 * 类名称:ScheduleJobLogServiceImpl.java
 * 包名称:com.platform.modules.job.service.impl
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.job.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qwkj.qwkjaccountcenter.common.utils.Query;
import com.qwkj.qwkjaccountcenter.modules.job.dao.ScheduleJobLogDao;
import com.qwkj.qwkjaccountcenter.modules.job.entity.ScheduleJobLogEntity;
import com.qwkj.qwkjaccountcenter.modules.job.service.ScheduleJobLogService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 李鹏军
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {

    @Override
    public Page queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "T.CREATE_TIME");
        params.put("asc", false);
        Page<ScheduleJobLogEntity> page = new Query<ScheduleJobLogEntity>(params).getPage();
        return page.setRecords(baseMapper.selectScheduleJobLogPage(page, params));
    }

}
