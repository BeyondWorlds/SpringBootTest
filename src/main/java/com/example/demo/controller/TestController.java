package com.example.demo.controller;

import com.example.demo.constant.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/logTest")
    public String logTest(){
        Constant.LOG.debug("debug 日志");
        Constant.LOG.info("info 日志");
        Constant.LOG.warn("warn 日志");
        Constant.LOG.error("error 日志");
        Constant.LOG.fatal("fatal 日志");
        return  "logTest success";
    }
}
