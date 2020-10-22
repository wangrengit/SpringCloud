package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder(value = {"title","content"}) //自定义输出排序
public class Article {
//    @JsonIgnore //忽略此属性
    private Long id;
//    @JsonProperty("auther") //设置别名
    private String author;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss") //定义接收和输出的格式
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL) //为空就不返回
    private String title;

    private List<Reader> readers;
}
