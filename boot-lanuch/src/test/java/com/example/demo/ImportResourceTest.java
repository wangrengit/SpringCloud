package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ImportResourceTest {
    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testImport(){
//        判断有没有创建这个bean
        boolean isImport=ioc.containsBean("testBeanService");
        System.out.println(isImport);
    }
}
