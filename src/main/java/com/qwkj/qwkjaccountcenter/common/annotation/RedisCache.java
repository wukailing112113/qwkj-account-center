
package com.qwkj.qwkjaccountcenter.common.annotation;


import com.qwkj.qwkjaccountcenter.common.utils.Constant;

import java.lang.annotation.*;

/**
 * 加上该注解，代理service命中缓存则从缓存中读取数据，否则从service业务逻辑获得，并存入缓存
 *
 * @author 李鹏军
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface RedisCache {
    /**
     * 缓存key
     * 若destine为true，存入redis的键为cacheKey的值
     * 若destine为false，存入redis的的键为service方法的 cacheKey:userId_id_packageName.className.methodName
     */
    String cacheKey() default Constant.SYS_CACHE;

    /**
     * 数据缓存时间单位s秒 默认5分钟
     */
    int cacheTime() default 300;

    /**
     * 是否使用指定的key
     * 若为true，存入redis的键为cacheKey的值
     */
    boolean destine() default false;
}
