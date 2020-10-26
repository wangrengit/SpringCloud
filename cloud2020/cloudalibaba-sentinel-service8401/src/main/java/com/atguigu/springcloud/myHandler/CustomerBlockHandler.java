package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springboot.entities.CommonResult;
import com.atguigu.springboot.entities.Payment;

public class CustomerBlockHandler {
    public static CommonResult handlerException2(BlockException exception){
        return  new CommonResult(4444,"按客户自定义,globel handlerException",new Payment(2020L,"serial003"));

    }
}
