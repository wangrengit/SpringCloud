package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atguigu.springcloud.dao")
public class MyBatisConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSourceOne() {
//        return DruidDataSourceBuilder.create().build();
//    }
}
