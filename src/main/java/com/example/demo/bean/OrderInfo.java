package com.example.demo.bean;

import lombok.Data;

@Data
public class OrderInfo {
    private String orderId;
    private String orderName;

    public OrderInfo(){
        this.orderId="-1";
        this.orderName="orderDefaultName";
    }
}
