package com.example.demo.service;

import com.example.demo.model.ArticleVO;

import java.util.List;

public interface ArticleServices {
    void saveArticle(ArticleVO articleVO);
    void deleteArticle(Long id);
    void updateAritcle(ArticleVO articleVO);
    ArticleVO getAritcle(Long id);
    List<ArticleVO> getAll();
}
