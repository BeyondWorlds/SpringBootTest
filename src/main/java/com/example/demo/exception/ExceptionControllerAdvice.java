package com.example.demo.exception;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常统一处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ResultBean<String> methodArgumentNotValidExceptionHandler(BindException e){
        ObjectError error=e.getBindingResult().getAllErrors().get(0);
        return new ResultBean<>(ResultCode.VALIDATE_FAILED,error.getDefaultMessage());
    }


    /**
     * 处理自定义异常
     * @param apiException
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public String apiException(ApiException apiException){
        return apiException.getMsg();
    }


}
