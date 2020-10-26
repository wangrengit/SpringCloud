package com.example.demo.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {

//    @Primary
//    @Bean("primaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.primary") //绑定primary配置信息
//    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("secondaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary") //绑定secondry配置信息
//    public DataSource secondaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }

    //Jta数据源primarydb
//    @Bean(initMethod = "init",destroyMethod = "close")
//    @ConfigurationProperties(prefix = "primarydb")
//    public DataSource primaryDataSource(){
//        //这里是关键，返回的是AtomikosDataSourceBean,所有配置属性也都是注入到这个类里面
//        return new AtomikosDataSourceBean();
//    }
//    //Jta数据源secondarydb
//    @Bean(initMethod = "init",destroyMethod = "close")
//    @ConfigurationProperties(prefix = "secondarydb")
//    public DataSource secondaryDataSource(){
//        return new AtomikosDataSourceBean();
//    }
//
//    @Bean()
//    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//    @Bean()
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }



}
