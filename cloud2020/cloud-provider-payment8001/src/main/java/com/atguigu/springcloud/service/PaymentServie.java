package com.atguigu.springcloud.service;


import com.atguigu.springboot.entities.Payment;

public interface PaymentServie {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
