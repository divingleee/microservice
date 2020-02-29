package com.dl.serviceconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "dl-service-provider"
        //configuration = FeignConfig.class,
        //fallback和fallbackFactory二选一即可，区别在于fallbackFactory带有异常信息
        //fallbackFactory = HystrixFactoryProviderApiFeignFallback.class,
        //fallback = HystrixProviderApiFeignFallback.class
)
public interface ProviderApiFeign {
    @RequestMapping("/provider/test")
    String test();
}
