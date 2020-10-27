package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //表示一个实体类
@Table(name="article") //对应数据表名
public class ArticleJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 32)
    private String author;
    @Column(length = 512)
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(nullable = false,unique = false,length = 32)
    private String title;
}
