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
@MapperScan(basePackages = "com.example.demo.generator.testdb2",
        sqlSessionTemplateRef = "secondarySqlSessionTemplate"
)
public class SecondaryDataSourceConfig {

    @Bean("secondaryDatasource")
    @ConfigurationProperties(prefix = "secondarydb")
    //创建数据源
    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
        return new AtomikosDataSourceBean(); //分布式事务用这个数据源
    }
    @Bean("secondarySqlSessionFactory")
    //创建SqlSessionFactory
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("secondaryDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources("classpath:generator/MessageMapper.xml")
        );
        return bean.getObject();
    }
    //分布式事务时不需要这个
//    @Bean("secondaryTransactionManager")
    //创建事务管理器
//    public DataSourceTransactionManager secondaryTransactionManager(@Qualifier("secondaryDatasource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
    @Bean(name="secondarySqlSessionTemplate")
    //函数操作
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ){
        return new SqlSessionTemplate(sqlSessionFactory);

    }
}
