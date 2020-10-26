package com.example.demo.config;


import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

//@Configuration
public class TransactionManagerConfig {

//    @Bean
//    public UserTransaction userTransaction() throws SystemException {
//        UserTransactionImp userTransactionImp=new UserTransactionImp();
//        userTransactionImp.setTransactionTimeout(10000);
//        return userTransactionImp;
//    }
//    @Bean(name = "atomikosTransactionManager",initMethod = "init",destroyMethod = "close")
//    public TransactionManager atomikosTransactionManager(){
//        UserTransactionManager userTransactionManager=new UserTransactionManager();
//        userTransactionManager.setForceShutdown(false);
//        return userTransactionManager;
//    }
//    @Bean(name="transactionManager")
//    @DependsOn({"userTransaction","atomikosTransactionManager"})
//    public PlatformTransactionManager transactionManager() throws SystemException {
//        UserTransaction userTransaction=userTransaction();
//
//        JtaTransactionManager manager=new JtaTransactionManager(userTransaction,atomikosTransactionManager());
//        return manager;
//    }

}
