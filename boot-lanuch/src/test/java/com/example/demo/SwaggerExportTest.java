package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

@SpringBootTest(webEnvironment  =SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class) //Junit4使用这个注解
public class SwaggerExportTest {

//    @Test
//    public void generateAsciiDocs() throws MalformedURLException {
//        //输出Ascii格式
//        Swagger2MarkupConfig config=new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)//设置生成格式，还有一个MARKDOWN
//                .withOutputLanguage(Language.ZH) //设置导出文档为中文
//                .withPathsGroupedBy(GroupBy.TAGS) //按照分组导出,如果没有在方法上注解分组，默认是一个controller为一个TAGS
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//        //从什么位置导出,然后放在什么位置.v2/api-docs这个路径可以在html页面上查询
//        Swagger2MarkupConverter.from(new URL("http://localhost:8888/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("src/main/resources/docs/asciidoc"));
//    }
}
