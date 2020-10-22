package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("boot 项目API文档")
//                .description("简单优雅的restfun风格")
//                .termsOfServiceUrl("http://www.zimug.com")
//                .version("1.0")
//                .build();
//    }
//
//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //扫描basePackage包下面的“/articles”路径下的内容作为接口文档构建的目标
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                .paths(PathSelectors.regex("/rest/.*"))
//                .build();
//    }
//}
