package com.atguigu.springcloud.service.Impl;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.service.AccountService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl  implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(long userid, BigDecimal money) {
        log.info("----------->扣减帐户余额开始");
        accountDao.decrease(money,userid);
        log.info("----------->扣减帐户余额结束");
    }
}
