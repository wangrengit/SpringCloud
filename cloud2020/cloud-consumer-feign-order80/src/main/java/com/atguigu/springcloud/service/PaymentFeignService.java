package com.atguigu.springcloud.service;

import com.atguigu.springboot.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //获取到微服务后，再通过地址调用
    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")  long id);

   //测试超时
    @GetMapping(value="/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
