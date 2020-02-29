package com.dl.serviceconsumerfeign;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//全局配置，所有服务都是用同一个配置的 ribbon
@Configuration
public class RibbonConfig {
    @Bean
    public IRule iRule() {
        return new RoundRobinRule();//轮询
    }
}
