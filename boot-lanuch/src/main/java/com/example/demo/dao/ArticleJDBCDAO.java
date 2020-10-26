package com.example.demo.dao;

import com.example.demo.dao.testdb.Article;
import com.example.demo.model.ArticleVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJDBCDAO {

    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

//    添加
    public void save(ArticleVO article,JdbcTemplate jdbcTemplates){
        String sql="insert into article(author,title,content,create_time) values(?,?,?,?)";
        jdbcTemplates.update(sql,article.getAuthor(),article.getTitle(),article.getContent(),article.getCreateTime());
    }
//    修改
    public void update(ArticleVO article){
        String sql="update article set author=?,title=?,content=?,create_time=? where id=?";
        jdbcTemplate.update(sql,article.getAuthor(),article.getTitle(),article.getContent(),article.getCreateTime(),article.getId());
    }
//    删除
    public void delete(Long id){
        String sql="delete from article where id=?";
        jdbcTemplate.update(sql,id);
    }
//查询一条记录
    public void findById(Long id){
        String sql="select * from article where id=?";
        Article article=jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
        System.out.println(article.getAuthor());
    }
//查询所有
    public void findAll(){
        String sql="select * from article";
        List<Article> articleList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Article.class));
    }
}
