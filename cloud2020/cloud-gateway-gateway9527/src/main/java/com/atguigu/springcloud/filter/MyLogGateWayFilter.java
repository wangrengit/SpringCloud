package com.atguigu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//需要实现 GlobalFilter, Ordered
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        获取参数uname的值
        String uname=exchange.getRequest().getQueryParams().getFirst("uname");

        if(uname == null){
//            设置返回码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
//        进入下一个拦截器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
