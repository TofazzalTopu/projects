package com.info.MongoDBDemo.controller.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by mdtofazzal.hossain on 3/28/2019.
 */


@RestController
@RequestMapping(value = "/hystrix")
public class HystrixController {

    @RequestMapping(value = "/responseTime")
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        return "Welcome Hystrix";
    }
    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }
}
