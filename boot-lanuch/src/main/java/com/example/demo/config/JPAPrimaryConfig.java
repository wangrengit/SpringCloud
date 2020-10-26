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
//        entityManagerFactoryRef = "entityManagerFactoryPrimary",
//        transactionManagerRef = "transactionManagerPrimary", //事务管理器
//        basePackages = {"com.example.demo.dao.testdb"} //换成自己的Repository所在的位置
//)
public class JPAPrimaryConfig {
//    @Resource
//    private JpaProperties jpaProperties;
//
//    @Resource
//    private HibernateProperties hibernateProperties;
//
//    @Primary
//    @Bean("primaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.primary") //数据源的配置信息
//    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Primary
//    @Bean("entiryManagerPrimary")  //primary实体管理器
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//    @Primary
//    @Bean("entityManagerFactoryPrimary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder){
//        Map<String,Object> properties=
//                hibernateProperties.determineHibernateProperties(
//                        jpaProperties.getProperties(),
//                        new HibernateSettings()
//                );
//        return builder.dataSource(primaryDataSource())
//                .properties(properties)
//                .packages("com.example.demo.dao.testdb") //换成自己的实体类位置
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
//    }
//    @Primary
//    @Bean("transactionManagerPrimary")  //primary事务管理器
//    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }

}
