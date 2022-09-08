package com.example.demo.configure;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.ResultCode;
import com.example.demo.exception.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回类统一封装处理
 */
@RestControllerAdvice(basePackages = {"com.example.demo.controller"})//加上需要扫描的包名
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //如果类型是ResultBean不用处理
        return !returnType.getParameterType().equals(ResultBean.class);
    }

    /**
     * 返回实体之前进行封装
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
       //String 类型不能直接包装，需要特别处理
        if (returnType.getParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultBean<>(body));
            } catch (JsonProcessingException e) {
                throw new ApiException(ResultCode.FAILED.getCode(), "返回String类型错误");
            }
        }
        return new ResultBean<>(body);
    }
}
