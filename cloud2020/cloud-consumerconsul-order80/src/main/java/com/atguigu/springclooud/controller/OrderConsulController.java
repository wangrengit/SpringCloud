package com.atguigu.springclooud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {

    @Autowired
    RestTemplate restTemplate;

    //    通过注册的服务名来访问
    private static final String url="http://consul-provider-payment";

    @GetMapping(value="/consumer/payment/consul")
    public String paymentInfo(){

        String result=restTemplate.getForObject(url+"/payment/consul",String.class);
        return result;
    }
}
