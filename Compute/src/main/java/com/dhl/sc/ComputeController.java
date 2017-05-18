package com.dhl.sc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hailong.dang on 5/18/2017.
 */
@RestController
public class ComputeController {
    private final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient discClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b){
        ServiceInstance instance = discClient.getLocalServiceInstance();
        Integer ret = a+b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + ret);
        return ret;
    }
}
