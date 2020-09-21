package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class) //这里是Sink，生产者配的是Source
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //添加监听注解
    public void input(Message<String> message){

        //发送用的withpayload方法，接收就用getpayload
        System.out.println("消费者1号，---------->接受到消息："+message.getPayload()+"port="+serverPort);

    }

}
