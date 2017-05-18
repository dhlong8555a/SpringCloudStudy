package com.dhl.sc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hailong.dang on 5/18/2017.
 */
@FeignClient("compute-service")
public interface ComputeClient {
    @RequestMapping(method= RequestMethod.GET, value="/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
