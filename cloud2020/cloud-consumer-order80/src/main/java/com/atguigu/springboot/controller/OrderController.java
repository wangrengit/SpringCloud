package com.atguigu.springboot.controller;


import com.atguigu.springboot.entities.CommonResult;
import com.atguigu.springboot.entities.Payment;
import com.atguigu.springboot.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class OrderController {
//    单机版本
//    private static final String url="http://localhost:8001/";
//      集群,访问的是提供者注册的服务名
    private static final String url="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;


    @PostMapping(value="/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("serial="+payment.getSerial());
        return restTemplate.postForObject(url+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping(value="/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("收到请求");
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }

//    使用getForEntity获取数据
    @GetMapping(value="/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity= restTemplate.getForEntity(url+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }


    @GetMapping(value="/consumer/payment/lb")
    public String getPaymentLB(){

        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances ==null&& instances.size()<=0){
            return null;
        }

//        通过返回的服务，获取到url地址
        ServiceInstance serviceInstance=loadBalancer.instances(instances);
        URI uri=serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }


//    =================>zipkin + sleuth

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result=restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/",String.class);
        return result;
    }
}
