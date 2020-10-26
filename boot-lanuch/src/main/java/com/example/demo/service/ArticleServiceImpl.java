package com.example.demo.service;

import com.example.demo.dao.ArticleJDBCDAO;
import com.example.demo.model.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements  ArticleService{

//    @Autowired
//    @Qualifier("primaryJdbcTemplate")
//    JdbcTemplate primaryJdbcTemplate;
//
//    @Autowired
//    @Qualifier("secondaryJdbcTemplate")
//    JdbcTemplate secondaryJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ArticleJDBCDAO articleJDBCDAO;

    @Override
    @Transactional
    public String saveArticle(ArticleVO article) {
        articleJDBCDAO.save(article,jdbcTemplate);
//        articleJDBCDAO.save(article,secondaryJdbcTemplate);
//        int i=10/0;
        return "成功";
    }

    @Override
    public String updArticle(ArticleVO article) {
        articleJDBCDAO.update(article);
        return "成功";
    }

    @Override
    public String delArticle(Long id) {
        articleJDBCDAO.delete(id);
        return "成功";
    }

    @Override
    public void findById(Long id) {
        articleJDBCDAO.findById(id);
    }

    @Override
    public void findAll() {
        articleJDBCDAO.findAll();
    }
}
