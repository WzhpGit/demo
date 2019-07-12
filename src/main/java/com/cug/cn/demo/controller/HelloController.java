package com.cug.cn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author wzhp
 * @Date 2019-07-10 19:27
 * @Version 1.0
 **/
@RestController
public class HelloController {

    /**
     * Say hello string.
     *
     * @return the string
     */
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello world!";
    }
}
