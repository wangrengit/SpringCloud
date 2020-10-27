package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVO {
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
