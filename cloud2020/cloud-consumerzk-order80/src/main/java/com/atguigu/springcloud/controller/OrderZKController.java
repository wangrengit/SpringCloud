package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZKController {

    @Autowired
    RestTemplate restTemplate;

//    通过注册的服务名来访问
    private static final String url="http://cloud-provider-payment";

    @GetMapping(value="/consumer/payment/zk")
    public String paymentInfo(){

        String result=restTemplate.getForObject(url+"/payment/zk",String.class);
        return result;
    }

}
