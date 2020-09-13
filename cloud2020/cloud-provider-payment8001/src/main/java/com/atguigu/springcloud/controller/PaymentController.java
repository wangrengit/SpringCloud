package com.atguigu.springcloud.controller;



import com.atguigu.springboot.entities.CommonResult;
import com.atguigu.springboot.entities.Payment;
import com.atguigu.springcloud.service.PaymentServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentServie paymentServie;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient descoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("serial="+payment.getSerial());
        int i=paymentServie.create(payment);
        System.out.println("i="+i);
        if(i>0){
        return  new CommonResult(200,"插入数据库成功+port=8001");
        }else {
            return  new CommonResult(444,"插入数据库失败+port=8001");
        }
    }
    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")  long id){
        Payment payments=paymentServie.getPaymentById(id);
        System.out.println(payments.toString());
        if(payments != null){
            return  new CommonResult(200,"成功+port=8001",payments);
        }else {
            return  new CommonResult(444,"查询ID="+id+"失败+port=8001",null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){

        List<String> services=descoveryClient.getServices();
        for(String str:services){
            log.info("***********element"+str);
        }
        List<ServiceInstance> instances=descoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return  this.descoveryClient;

    }

    //测试自定义的轮询
    @GetMapping(value="/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value="/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return serverPort;

    }




}
