package com.example.demo.controller;

import com.example.demo.AjaxResponse;
import com.example.demo.model.ArticleVO;
import com.example.demo.model.Reader;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ArticleServices;
import com.example.demo.service.JPAArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class ArticleController {

    List<Reader> readerList=new ArrayList<>();

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleServices articleServices;

    @Autowired
    JPAArticleService jpaArticleService;


    @RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){
        readerList.add(new Reader("kobe",21));
        readerList.add(new Reader("james",20));
        ArticleVO article=new ArticleVO(1L,"zimug","spring boot从青铜到王者",new Date(),"t1",readerList);
        log.info("article="+article);
        articleService.findById(id);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"查询成功",article);
        return ajaxResponse;
    }

    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public AjaxResponse addArticle(@RequestBody ArticleVO article){
        log.info("article="+article);
        System.out.println(article.getReaders().get(0).getAge());
//        articleService.saveArticle(article);
        //JPA测试
//        articleServices.saveArticle(article);
//        JPA分布式事务测试
         jpaArticleService.save();
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"新增成功",article);
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
                                   @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
                                   @RequestParam Date createTime){
        log.info("article="+createTime);
       log.info("article================================================================="+author);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"新增成功",null);
        return ajaxResponse;
    }



    @RequestMapping(value = "/articles",method=RequestMethod.PUT)
    public AjaxResponse updateArticle(@RequestBody  ArticleVO article){
        log.info("article="+article);
        articleService.updArticle(article);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"修改成功",null);
        return ajaxResponse;
    }

    @RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
    //这时使用地址传值，也可以通过请求体
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){
        log.info("article="+id);
        articleService.delArticle(id);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"删除",null);
        return ajaxResponse;
    }

}
