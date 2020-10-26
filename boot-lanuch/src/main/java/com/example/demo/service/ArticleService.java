package com.example.demo.service;

import com.example.demo.model.ArticleVO;


public interface ArticleService {
    String saveArticle(ArticleVO article);
    String updArticle(ArticleVO article);
    String delArticle(Long id);
    void findById(Long id);
    void findAll();
}
