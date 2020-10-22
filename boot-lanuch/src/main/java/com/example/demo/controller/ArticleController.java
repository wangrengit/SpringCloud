package com.example.demo.controller;

import com.example.demo.AjaxResponse;
import com.example.demo.model.Article;
import com.example.demo.model.Reader;
import com.example.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class ArticleController {

    List<Reader> readerList=new ArrayList<>();

//    @Resource
//    ArticleService articleService;


    @RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){
        readerList.add(new Reader("kobe",21));
        readerList.add(new Reader("james",20));
        Article article=new Article(1L,"zimug","spring boot从青铜到王者",new Date(),"t1",readerList);
        log.info("article="+article);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"查询成功",article);
        return ajaxResponse;
    }

    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public AjaxResponse addArticle(@RequestBody Article article){
        log.info("article="+article);
        System.out.println(article.getReaders().get(0).getAge());
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"新增成功",null);
        return ajaxResponse;
    }
//    //描述方法,tags表示分组
//    @ApiOperation(value ="添加文章",notes="添加新的文章",tags="Article",httpMethod="POST")
//    //描述参数,required表示必填
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="title",value="文章标题",required=true,dataType = "String"),
//            @ApiImplicitParam(name="content",value="文章内容",required=true,dataType = "String")
//    })
   @PostMapping("/articles2")
    public AjaxResponse addArticle(@RequestParam String author,
                                   @RequestParam String title,
                                   @RequestParam String content,
                                   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                   @RequestParam Date createTime){
        log.info("article="+createTime);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"新增成功",null);
        return ajaxResponse;
    }



    @RequestMapping(value = "/articles",method=RequestMethod.PUT)
    public AjaxResponse updateArticle(@RequestBody  Article article){
        log.info("article="+article);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"修改成功",null);
        return ajaxResponse;
    }

    @RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){
        log.info("article="+id);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"删除",null);
        return ajaxResponse;
    }
}
