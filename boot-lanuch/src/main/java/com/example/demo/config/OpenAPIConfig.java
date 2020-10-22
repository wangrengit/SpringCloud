package com.example.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    //rest请求的分成一组
    public GroupedOpenApi restApi(){
        return GroupedOpenApi.builder()
                .group("rest-api")
                .pathsToMatch("/rest/**")
                .build();
    }
    @Bean
    //hello请求的分成一组
    public GroupedOpenApi helloApi(){
        return GroupedOpenApi.builder()
                .group("hello")
                .pathsToMatch("/hello/**")
                .build();
    }
}
