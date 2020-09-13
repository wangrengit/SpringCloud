package com.atguigu.springcloud.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String springPort;

    @RequestMapping(value="/payment/zk")
    public String payment(){
        return  "springcloud with zookeeper:"+springPort+"\t"+ UUID.randomUUID().toString();
    }
}
