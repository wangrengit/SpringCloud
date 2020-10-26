package com.example.demo.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactorySecondary",
//        transactionManagerRef = "transactionManagerSecondary",
//        basePackages = {"com.example.demo.dao.testdb2"}
//)
public class JPASecondaryConfig {

//    @Resource
//    private JpaProperties jpaProperties;
//
//    @Resource
//    private HibernateProperties hibernateProperties;
//
//    @Bean("secondaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary") //数据源的配置信息
//    public DataSource secondaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("entiryManagerSecondary")  //primary实体管理器
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//    @Bean("entityManagerFactorySecondary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder){
//        Map<String,Object> properties=
//                hibernateProperties.determineHibernateProperties(
//                        jpaProperties.getProperties(),
//                        new HibernateSettings()
//                );
//        return builder.dataSource(secondaryDataSource())
//                .properties(properties)
//                .packages("com.example.demo.dao.testdb2") //换成自己的实体类位置
//                .persistenceUnit("SecondaryPersistenceUnit")
//                .build();
//    }
//    @Bean("transactionManagerSecondary")  //primary事务管理器
//    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }
}
