package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@PropertySource(value = "classpath:employee.properties",encoding = "utf-8")
@Data
public class Employee {
    //根据|分隔
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;
    //分隔后，获取第一个值
    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private String firstEmployeeName;
    //获取Map格式的值
    @Value("#{${employee.age}}")
    private Map<String,Integer> employeeAge;
    //获取Map中键为two的值
    @Value("#{${employee.age}['tow']}")
    private String employeeAgeTwo;
    //获取Map中键为five的值,没有则是取33
    @Value("#{${employee.age}['five'] ?: 33}")
    private String ageWithDefaultValue;
    //获取系统环境的值
    @Value("#{systemProperties['java.home']}")
    private String javaHome;
    //获取系统环境的值
    @Value("#{systemProperties['user.dir']}")
    private String userDir;


}
