package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springboot.entities.CommonResult;
import com.atguigu.springboot.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Value(value="${service-url.nacos-user-service}")
    public   String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;


    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value="fallback",fallback = "handlerFallback") //只负责业务异常
//    @SentinelResource(value="fallback",blockHandler = "blockHandler") //只负责sentinel控制台配置违规
    @SentinelResource(value="fallback",fallback = "handlerFallback" ,
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class}) //都配置
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result =restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class);
        if(id==4){
            throw new IllegalArgumentException("IlleaglAccessException,非法参数异常....");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
      return result;
    }

//    本例是fallback,Throwable e可以把异常带过来
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment =new Payment(id,null);
        return  new CommonResult(444,"兜底异常handlerFallcack,exception内容"+e.getMessage(),payment);
    }
//    本例是blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment=new Payment(id,null);
        return  new CommonResult(445,"blockHandler-sentinel限流,无此流水:"+blockException.getMessage(),payment);

    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public  CommonResult<Payment> paymentSQL(@PathVariable Long id){
        return paymentService.paymentSQL(id);
    }




}
