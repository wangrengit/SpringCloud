package com.example.demo.config;


import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = "com.example.demo.generator.testdb",
        sqlSessionTemplateRef = "primarySqlSessionTemplate"
)
public class PrimaryDataSourceConfig {

    @Bean(name="primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "primarydb")
    //配置数据源
    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
        return new AtomikosDataSourceBean(); //分布式事务用这个数据源
    }
    @Bean(name="primarySqlSessionFactory")
    @Primary
    //配置SqlsessionFactory
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //配置XML文件存储位置，这里就不是用application.yml中的配置信息
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources("classpath:generator/ArticleMapper.xml"));
        return bean.getObject();
    }
    //分布式事务时不需要这个
//    @Primary
//    @Bean("primaryTransactionManager")
//    //配置事务管理器
//    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name="primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier(value="primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
