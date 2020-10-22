package com.example.demo.service;

import com.example.demo.AjaxResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;
import java.io.IOException;

//@Service
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    //在响应前端的头部添加响应类型
    private static final MediaType EXCEL_TYPE= MediaType.valueOf("application/vnd.ms-excel");
    public ResponseToXlsConverter(){
        super(EXCEL_TYPE);
    }
    //针对哪一种数据或哪个类用当前类进行序列化,以下配置就是针对AjaxResponse类
    @Override
    protected boolean supports(Class<?> aClass) {
        return (AjaxResponse.class==aClass);
    }
    //请求的时候经过此方法序列化
    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }
    //响应的时候经过此方法序列化
    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
//        ajaxResponse对象以excel格式输出,首先要引入excel相关依赖
        final Workbook workbook=new HSSFWorkbook();
        final Sheet sheet=workbook.createSheet();
        final Row row=sheet.createRow(0);
        row.createCell(0).setCellValue(ajaxResponse.getMessage());
        row.createCell(1).setCellValue(ajaxResponse.getData().toString());
        workbook.write(httpOutputMessage.getBody());

    }
}
