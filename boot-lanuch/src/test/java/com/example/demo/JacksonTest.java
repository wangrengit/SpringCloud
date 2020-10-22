package com.example.demo;

import com.example.demo.model.Article;
import com.example.demo.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class JacksonTest {
    @Test
    public void test1() throws JsonProcessingException {
        //jackson的ObjectMapper 转换对象
        ObjectMapper mapper=new ObjectMapper();

     List<Reader> readerList=new ArrayList<>();
     readerList.add(new Reader("kobe",21));
     readerList.add(new Reader("james",20));

     Article article=new Article(1L,"zimug","spring boot从青铜到王者",new Date(),"t1",readerList);
//      json转string
     String str=mapper.writeValueAsString(article);
     System.out.println(str);
//     String转Json
     Article at=mapper.readValue("{\"id\":1,\"author\":\"zimug\",\"content\":\"spring boot从青铜到王者\",\"createTime\":\"2020/10/21 09:32:03\",\"title\":\"t1\",\"readers\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}]}",
             Article.class);
     System.out.println(at);


    }

}
