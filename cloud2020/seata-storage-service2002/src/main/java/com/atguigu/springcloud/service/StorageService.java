package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public interface StorageService {

    void decrease(Long productId,Integer count);
}
