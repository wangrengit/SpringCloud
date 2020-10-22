package com.example.demo;

import com.example.demo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.plugins.MockMaker;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc //自动构建MocMvc对象，就不能下面的代码构建了
@SpringBootTest //加载Spring容器
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest {

    @Resource
    private  MockMvc mockMvc;

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

        MvcResult mvcResult= null;
            mvcResult = mockMvc.perform(
            MockMvcRequestBuilders
                    .request(HttpMethod.POST,"/articles")
                    .contentType("application/json")
                    .content(str)
            ).andExpect(MockMvcResultMatchers.status().isOk()) //andExpect配置预期的值
             .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
             .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(21))
             .andDo(print())
             .andReturn();


        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info("------"+mvcResult.getResponse().getContentAsString());
    }
}
