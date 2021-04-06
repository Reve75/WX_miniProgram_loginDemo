package com.yangtongxue.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentTestController {
    @GetMapping("/test")
    @ResponseBody
    public String testEnvironment(){
        return "We can use the springboot environment";
    }
}
