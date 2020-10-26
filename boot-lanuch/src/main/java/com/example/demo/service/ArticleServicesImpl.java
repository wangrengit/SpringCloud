package com.example.demo.service;

import com.example.demo.dao.testdb.Article;
import com.example.demo.dao.testdb.ArticleRepository;
import com.example.demo.model.ArticleVO;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServicesImpl implements ArticleServices{


    @Resource
    private ArticleRepository articleRepository;

    //用于bean转换的
    @Resource
    private Mapper dozerMapper;

    @Override
    public void saveArticle(ArticleVO articleVO) {
        //把articleVO转成Article对象
    Article articlePO=dozerMapper.map(articleVO, Article.class);
    articleRepository.save(articlePO);
    }

    @Override
    public void deleteArticle(Long id) {
    articleRepository.deleteById(id);
    }

    @Override
    public void updateAritcle(ArticleVO articleVO) {
        Article articlePO=dozerMapper.map(articleVO, Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getAritcle(Long id) {
        Optional<Article> article=articleRepository.findById(id);
        //返回一条记录
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        return null;
    }
}
