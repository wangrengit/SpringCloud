package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "---------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        System.out.println(Thread.currentThread().getName()+"\t"+"....testB");
        return "---------testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try{
//            TimeUnit.SECONDS.sleep(2);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        int i=10/0;
        log.info("testD 测试RT");
        return "------------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHetKey")
    public String testE(@RequestParam(value = "p1" ,required = false) String p1,
                        @RequestParam(value = "p2",required = false) String p2 ){
        int age=10/0;
        return "----------testE";
    }
    //兜底方法
    public String deal_testHetKey(String p1, String p2, BlockException exception){
        return "---------------deal_testHetKey";
    }

}
