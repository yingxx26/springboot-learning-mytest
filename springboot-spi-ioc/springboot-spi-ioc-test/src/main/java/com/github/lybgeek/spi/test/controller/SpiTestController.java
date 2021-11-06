package com.github.lybgeek.spi.test.controller;


import com.github.lybgeek.spi.HelloService;
import com.github.lybgeek.spi.framework.anotation.SpiAutowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SpiTestController {


    @SpiAutowired("helloServiceEnImpl")
    private HelloService helloEnService;

    @SpiAutowired("helloServiceCnImpl")
    private HelloService helloCnService;

    @GetMapping(value="/en/{username}")
    public String sayEnHello(@PathVariable("username") String username){
        return helloEnService.sayHello(username);
    }

    @GetMapping(value="/cn/{username}")
    public String sayCnHello(@PathVariable("username") String username){
        return helloCnService.sayHello(username);
    }
}
