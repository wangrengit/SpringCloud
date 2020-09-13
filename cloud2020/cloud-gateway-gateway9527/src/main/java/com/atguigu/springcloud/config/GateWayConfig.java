package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    //这里使用编码来配置，不用yml
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();
        //访问/guonei时映射到http://news.baidu.com/guonei
        routes.route("path_route_atguigu",r ->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return  routes.build();
    }
}
