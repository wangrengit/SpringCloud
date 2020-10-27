package com.example.demo;

import com.example.demo.generator.testdb.Article;
import com.example.demo.generator.testdb.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BootLanuch2ApplicationTests {

	@Autowired
	ArticleMapper articleMapper;

	@Test
	void contextLoads() {
		Article article= Article.builder()
				.author("zimug")
				.content("从青铜到王者")
				.createTime(new Date())
				.title("t1222")
				.build();
     articleMapper.insert(article);
	}

}
