package com.example.demo.controller;

import com.example.demo.AjaxResponse;
import com.example.demo.model.ArticleVO;
import com.example.demo.model.Reader;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/rest")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public AjaxResponse addArticle(@RequestBody ArticleVO articleVO){
        System.out.println("--------------------------------------");
        articleService.insert(articleVO);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"查询成功",null);
        return ajaxResponse;
    }

    @RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){
//        readerList.add(new Reader("kobe",21));
//        readerList.add(new Reader("james",20));
//        ArticleVO article=new ArticleVO(1L,"zimug","spring boot从青铜到王者",new Date(),"t1",readerList);
//        log.info("article="+article);
//        articleService.findById(id);
        AjaxResponse ajaxResponse=new AjaxResponse(true,200,"查询成功",null);
        return ajaxResponse;
    }
}
