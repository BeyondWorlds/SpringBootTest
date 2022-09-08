package com.example.demo.bean;

import lombok.Getter;

/**
 * 统一响应实体
 * @param <T>
 */
@Getter
public class ResultBean<T> {

    private int code;
    private String msg;
    private T data;

    public ResultBean(T data){
        this(ResultCode.SUCCESS,data);
    }
    public ResultBean(ResultCode resultCode,T data){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.data=data;
    }
}
