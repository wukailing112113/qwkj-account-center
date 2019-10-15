
package com.qwkj.qwkjaccountcenter.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 * @author 李鹏军
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.second")
//    public DataSource secondDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        /*
         * map中2个元素，与2的n次方最接近的数是2，但是这里如果设置容量为2的话 2/2=1,
         * 已经超过默认加载因子(0.75)的大小了。因此会resize一次，变成4。所以最优的值是4。
         *
         * https://www.cnblogs.com/tiancai/p/9558895.html
         */
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}
