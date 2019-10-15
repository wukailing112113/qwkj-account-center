package com.qwkj.qwkjaccountcenter.modules.swaggerbootstrapui.annotations;

import com.qwkj.qwkjaccountcenter.modules.swaggerbootstrapui.configuration.SwaggerBootstrapUiConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({SwaggerBootstrapUiConfiguration.class})
public @interface EnableSwaggerBootstrapUI {

}
