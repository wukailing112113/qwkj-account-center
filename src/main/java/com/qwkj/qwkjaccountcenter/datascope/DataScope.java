
package com.qwkj.qwkjaccountcenter.datascope;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author 李鹏军
 * <p>
 * 数据权限查询参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataScope extends HashMap {

    /**
     * SQL中数据创建用户（通常传入CREATE_USER_ID）的别名
     */
    private String userAlias = "T.CREATE_USER_ID";

    /**
     * SQL中数据CREATE_USER_ORG_NO的别名
     */
    private String orgAlias = "T.CREATE_USER_ORG_NO";

    /**
     * 具体的数据范围
     */
    private String orgNos;

    /**
     * true：没有机构数据权限，也能查询本人数据
     */
    private Boolean self = true;
}
