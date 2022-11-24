package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot Board";
    }
}
