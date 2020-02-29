package com.dl.serviceconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("test")
    public String test() {
//        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
//        if (instances != null && instances.size() > 0) {
//            log.info("/hello,host:" + instances.get(0).getHost() + ", service_id:" + instances.get(0).getServiceId());
//        }
        String result = restTemplate.getForObject("http://dl-service-provider/provider/test", String.class);
        return result;
    }
}
