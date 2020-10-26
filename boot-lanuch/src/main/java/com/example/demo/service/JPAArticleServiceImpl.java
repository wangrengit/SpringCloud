package com.example.demo.service;

import com.example.demo.dao.testdb.Article;
import com.example.demo.dao.testdb.ArticleRepository;
import com.example.demo.dao.testdb2.Message;
import com.example.demo.dao.testdb2.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class JPAArticleServiceImpl implements JPAArticleService{

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public void save() {
        Article article=Article.builder()
                .id(5L)
                .author("zimug1")
                .content("spring 从青铜到王者")
                .createTime(new Date())
                .title("t2").build();
        Message message=Message.builder()
                .name("zimug1").content("ok").build();
        articleRepository.save(article);
        messageRepository.save(message);

//        int i =10/0;
    }
}
