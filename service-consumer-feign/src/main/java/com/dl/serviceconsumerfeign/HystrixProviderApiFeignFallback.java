package com.dl.serviceconsumerfeign;

import org.springframework.stereotype.Component;

@Component
public class HystrixProviderApiFeignFallback implements ProviderApiFeign {
    @Override
    public String test() {
        return "服务器异常，请稍候重试！！！";
    }
}
