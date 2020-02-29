package com.dl.serviceconsumerfeign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    ProviderApiFeign providerApiFeign;


    //添加线程池隔离 HystrixCommand
    @HystrixCommand
    @GetMapping("test")
    public String test() {
        System.out.println("测试线程隔离，线程名称：" + Thread.currentThread().getName());
        String result = providerApiFeign.test();
        return result;
    }

    @GetMapping("test1")
    public String test1() {
        System.out.println("测试线程隔离，线程名称：" + Thread.currentThread().getName());
        String result = providerApiFeign.test();
        return result;
    }
}
