package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ValueBindTest {
    @Autowired
    Family family;

    @Autowired
    Employee employee;

    @Test
    public void test2(){
        System.out.println(employee.getEmployeeNames());
    }

    @Test
    public void test1(){
        System.out.println(family.toString());
    }
}
