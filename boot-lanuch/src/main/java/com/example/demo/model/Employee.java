package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@PropertySource(value = "classpath:employee.properties",encoding = "utf-8")
@Data
public class Employee {
    //根据|分隔
    @Value("#{'${employee.names}'}.split('\\|')}")
    private List<String> employeeNames;


}
