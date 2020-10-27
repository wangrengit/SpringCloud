package com.example.demo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@Schema(title = "通用响应数据结构")
public class AjaxResponse {
    @Schema(title="请求是否处理成功")
    private boolean isok;
    @Schema(title="请求响应状态码",example = "200,400,500")
    private int code;
    @Schema(title="请求结果描述信息")
    private String message;
    @Schema(title="请求结果数据")
    private Object data;
}
