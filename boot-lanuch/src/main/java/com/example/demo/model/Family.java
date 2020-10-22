package com.example.demo.model;

import com.example.demo.service.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@ConfigurationProperties(prefix = "family") //绑定配置属性
@PropertySource(value = {"classpath:family.yml"},factory = MixPropertySourceFactory.class)
@Validated //开启数据校验
public class Family {

//    @Value("${family.family-name}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
