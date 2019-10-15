package com.qwkj.qwkjaccountcenter.modules.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserAccessDto {

    private Set<String> permsSet;

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户名
     */
    private String userName;

    public UserAccessDto() {

    }

}
