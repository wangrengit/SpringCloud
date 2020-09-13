package com.atguigu.springcloud.controller;

import com.atguigu.springboot.entities.CommonResult;
import com.atguigu.springboot.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
//        通过接口上的注解地址实现远程调用
       return paymentFeignService.getPaymentById(id);
    }

//    测试timeout，默认为1秒，可以配置
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String getPaymentTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }
}
