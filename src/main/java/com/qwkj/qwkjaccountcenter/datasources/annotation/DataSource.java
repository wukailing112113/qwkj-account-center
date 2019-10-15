
package com.qwkj.qwkjaccountcenter.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author 李鹏军
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
