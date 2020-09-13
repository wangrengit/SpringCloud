package com.atguigu.springcloud.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    int TimeOuts=2;

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_OK"+id;
    }

    //设置兜底的方法和设置眼里峰值,到达峰值时此方法还没有返回或者报了异常，都会走兜底方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
    })
    public String paymentInfo_TimeOut(Integer id){
        System.out.println("payment_timeout");
        try{
        TimeUnit.SECONDS.sleep(TimeOuts);
        }catch(Exception ex){
            ex.printStackTrace();
        }
//        测试运行异常，能否降级
//        int i=10/0;
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_TimeOut"+id;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        System.out.println("payment_timeouts");
        return "调用支付接口超时或异常，\t"+"\t当前线程池名字"+Thread.currentThread().getName();
    }

    //----------服务熔断
    //以下意思是10次访问中，有60%都失败了，就跳闸。然后等待10后再尝试恢复
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakeer_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), /*是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),/*请求次数*/
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),/*时间窗口期*/
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") /*失败率达到多少后跳闸*/
    })
    public String paymentCircuitBreaker( Integer id){
        if(id<0){
            throw new RuntimeException("*******id 不能为负数");
        }
        //生成唯一的流水号
        String serialNumber= IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreakeer_fallback(@PathVariable Integer id){
        return "id 不能为负数，请稍后再试，id="+id;
    }



}
