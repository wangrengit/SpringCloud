package com.atguigu.springcloud.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.atguigu.springcloud.dao")
public class MyBatisConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSourceOne() {
//        return DruidDataSourceBuilder.create().build();
//    }
}
