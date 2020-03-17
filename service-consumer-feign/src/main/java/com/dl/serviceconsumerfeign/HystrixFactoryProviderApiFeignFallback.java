package com.dl.serviceconsumerfeign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class HystrixFactoryProviderApiFeignFallback implements FallbackFactory<ProviderApiFeign> {
    @Override
    public ProviderApiFeign create(Throwable throwable) {
        return new ProviderApiFeign() {
            @Override
            public String test() {
                log.error("带有 error 的 fallback：" + throwable.getMessage());

                return "服务器异常，请稍候重试！！！";
            }
        };
    }
}
