package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="articles") //自动生成的接口，就是通过这里设置的articles进行访问
public interface ArticleRespository  extends JpaRepository<ArticleJPA,Long> {
    ArticleJPA findByAuthor(String author); //生成一个按author查询的SQL
}
