package com.example.demo.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "com.example.demo.dao.testdb2", //注意这里
        entityManagerFactoryRef = "secondaryEntityManager",
        transactionManagerRef = "transactionManager"
)
public class JPAJTASecondaryConfig {
    @Resource
    private JpaVendorAdapter jpaVendorAdapter;


    @Bean("secondaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.secondary") //注意这里
    //创建一个配置对象
    public DataSourceProperties secondaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name="secondaryDataSource",initMethod ="init",destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    //初始化XA数据源
    public DataSource secondaryDataSource(){
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setURL(secondaryDataSourceProperties().getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(secondaryDataSourceProperties().getPassword());
        mysqlXADataSource.setUser(secondaryDataSourceProperties().getUsername());
        AtomikosDataSourceBean xaDataSource=new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("scondary");
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setMaxPoolSize(20);
        return xaDataSource;
    }


    @Bean("secondaryEntityManager")
    @DependsOn("transactionManager")
    //构建实体管理器
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager(){
        HashMap<String,Object> properties=new HashMap<>();
        properties.put("hibernate.transaction.jta.platform",AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType","JTA");
        LocalContainerEntityManagerFactoryBean entityManager=new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(secondaryDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        //这里修改马主数据源的扫描包
        entityManager.setPackagesToScan("com.example.demo.dao.testdb2");
        entityManager.setPersistenceUnitName("secondaryPersistenceUnit");
        return entityManager;
    }
}
