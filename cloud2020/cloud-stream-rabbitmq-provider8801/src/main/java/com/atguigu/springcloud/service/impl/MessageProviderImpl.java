package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class) //消息的推送管道
public class MessageProviderImpl  implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());  //发送信息,发送用的withpayload方法，接收就用getpayload
        System.out.println("***********serial="+serial);
        return null;
    }
}
