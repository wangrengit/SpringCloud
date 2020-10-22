package com.example.demo.service;

import com.example.demo.model.Article;
import org.springframework.stereotype.Service;


public interface ArticleService {
    String saveArticle(Article article);
}
