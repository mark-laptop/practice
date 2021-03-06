package ru.ndg.practice.common.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceController implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return converterType == MappingJackson2HttpMessageConverter.class || converterType == StringHttpMessageConverter.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return putViewInBody("result", "success");
        }

        if (returnType.getNestedParameterType() == ResponseEntity.class) {
            return putViewInBody("error", body);
        }

        return putViewInBody("data", body);

    }

    private Map<String, Object> putViewInBody(String param, Object view) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(param, view);
        return body;
    }
}
