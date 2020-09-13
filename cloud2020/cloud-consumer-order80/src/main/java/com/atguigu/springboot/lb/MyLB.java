package com.atguigu.springboot.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    //获取第几次访问
    public final int getAndIncrement(){
        int curren;
        int next;

        do{
            curren=this.atomicInteger.get();
            next=curren>=2147483647 ? 0 : curren+1;
        }while(!this.atomicInteger.compareAndSet(curren,next));
        System.out.println("***********第几次访问，"+next);
        return next;
    }

    @Override
     //循环返回每个服务
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index=getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
