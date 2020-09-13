package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------------------paymentFallbackservice fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------------------paymentFallbackService fall bak-paymentInfo_TimeOut";
    }
}
