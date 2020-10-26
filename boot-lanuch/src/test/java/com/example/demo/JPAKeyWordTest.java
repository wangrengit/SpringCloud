package com.example.demo;

import com.example.demo.dao.testdb.Article;
import com.example.demo.dao.testdb.ArticleRepository;
import com.example.demo.dao.testdb2.Message;
import com.example.demo.dao.testdb2.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JPAKeyWordTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MessageRepository messageRepository;

    @Test
    public void test2(){
    Article article=Article.builder()
            .id(5L)
            .author("zimug")
            .content("spring 从青铜到王者")
            .createTime(new Date())
            .title("t1").build();
    Message message=Message.builder()
            .name("zimug").content("ok").build();
    //primary数据源插入数据
    articleRepository.save(article);
    //secondary数据源插入数据
    messageRepository.save(message);
    }

    @Test
    public void test1(){
        Article article=articleRepository.findByAuthor("zimug");
        System.out.println(article.toString());
    }
}
