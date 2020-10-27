package com.example.demo.service;

import com.example.demo.generator.testdb.Article;
import com.example.demo.generator.testdb.ArticleMapper;
import com.example.demo.generator.testdb2.Message;
import com.example.demo.generator.testdb2.MessageMapper;
import com.example.demo.model.ArticleVO;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Resource
    private Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageMapper messageMapper;

    @Override
    @Transactional
    public void insert(ArticleVO articleVO) {
     Article articlePO=dozerMapper.map(articleVO,Article.class);
     articleMapper.insert(articlePO);
        Message message=Message.builder()
                .name("wang")
                .content("wwwww")
                .build();
     messageMapper.insert(message);
//     int i=10/0; //模拟异常
    }
}
