package com.example.demo.exception;

import com.example.demo.bean.ResultCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private int code;
    private String msg;

    public ApiException() {
        this(ResultCode.FAILED.getCode(), "接口异常");
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
