
package com.qwkj.qwkjaccountcenter.config;

import com.qwkj.qwkjaccountcenter.common.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 控制台输出日志配置
 *
 * @author 李鹏军
 */
@Configuration
public class LogConfig implements WebMvcConfigurer {
    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**")//对所有请求都拦截，但是排除了/swagger-ui/**,//swagger-resources,
                .excludePathPatterns("/swagger-ui/**", "/swagger-resources", "/doc.html");
    }
}
