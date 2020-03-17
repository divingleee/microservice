package com.dl.serviceprovider1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private Registration registration;// 服务注册
    @Autowired
    private DiscoveryClient client;

    @GetMapping("test")
    public String test() {
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        if (instances != null && instances.size() > 0) {
            log.info("host:" + instances.get(0).getHost() + ", service_id:" + instances.get(0).getServiceId());
        }

        try {
            //这里超时触发服务降级
            Thread.sleep(6000);
        } catch (InterruptedException e) {

        }

        log.info("执行服务提供者服务 1");
        return "dl service provider 1";
    }
}
