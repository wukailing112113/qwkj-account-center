/*
 * 项目名称:platform-plus
 * 类名称:TestTest1Entity.java
 * 包名称:com.platform.modules.test.entity
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-05-15 15:49:24        李鹏军     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.qwkj.qwkjaccountcenter.modules.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 *
 * @author 李鹏军
 * @date 2019-05-15 15:49:24
 */
@Data
@TableName("TEST_TEST1")
public class TestTest1Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private String id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Integer age;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
}
