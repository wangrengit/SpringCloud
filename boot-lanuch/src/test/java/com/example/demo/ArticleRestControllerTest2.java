package com.example.demo;

import com.example.demo.controller.ArticleController;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc //自动构建MocMvc对象，就不能下面的代码构建了
//@SpringBootTest //加载Spring容器
@WebMvcTest(ArticleController.class) //只创建ArticleController中需要的Bean,减少程序启动时间
@ExtendWith(SpringExtension.class) 
public class ArticleRestControllerTest2 {

    @Resource
    private  MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

//    @BeforeAll
//    static void setUP(){
//        //针对ArticleController类进行测试
//        mockMvc= MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

    @Test
    public void test1() throws Exception {
        String str="{\"id\":1,\"author\":\"zimug\",\"content\":\"spring boot从青铜到王者\"," +
                "\"createTime\":\"2020/10/21 09:36:36\",\"title\":\"t1\"," +
                "\"readers\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}]}";

        ObjectMapper objectMapper=new ObjectMapper();
        Article article=objectMapper.readValue(str,Article.class);

        //打桩,当Controller层中有执行articleService.saveArticle(article)时直接就返回“OK”
        when(articleService.saveArticle(article)).thenReturn("OK");

        MvcResult mvcResult= null;
            mvcResult = mockMvc.perform(
            MockMvcRequestBuilders
                    .request(HttpMethod.POST,"/articles")
                    .contentType("application/json")
                    .content(str)
            )
             .andDo(print())
             .andReturn();


        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info("------"+mvcResult.getResponse().getContentAsString());
    }
}
