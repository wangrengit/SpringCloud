package com.example.demo.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    //自定义了一个方法，就会自动生成一个SQL,Jpa自带的是根据ID来查，这里就可以自定义一个根据author来查询
    //select * from article where author=author
    Article findByAuthor(String author);
}
