package com.example.demo.controller;

import com.example.demo.bean.OrderInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/getOrder")
    public OrderInfo getOrder(){
        return new OrderInfo();
    }
}
