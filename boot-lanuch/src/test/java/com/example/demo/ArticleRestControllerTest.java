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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc //自动构建MocMvc对象，就不用下面的代码构建了
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
                "\"createTime\":\"2020/10/21 09:36:36\",\"title\":\"t123\"," +
                "\"readers\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}]}";

        MvcResult mvcResult= null;
            mvcResult = mockMvc.perform(
            MockMvcRequestBuilders
                    .request(HttpMethod.POST,"/rest/articles")
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


    @Test
    //测试模拟表单提交
    public void test2() throws Exception {

        //因为下面参数是需要一个MultiValueMap类型的，所以没有用Map
        MultiValueMap<String,String> map1=new LinkedMultiValueMap<>();
        map1.add("id","123");
        map1.add("author","test123");
        map1.add("content","test456");
        map1.add("createTime","2020/10/21 09:36:36");
        map1.add("title","t2");

        MvcResult mvcResult=null;
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST,"/rest/articles")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE) //默认就是表格提交application/x-www-form-urlencoded
                        .params(map1)
        )
                .andDo(print())
                .andReturn();

    }

    @Test
    public void test3() throws Exception {
        MvcResult mvcResult=null;
        mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.GET,"/rest/articles/2")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE) //默认就是表格提交application/x-www-form-urlencoded
                        .param("id","123")
        )
                .andDo(print())
                .andReturn();
    }

}
