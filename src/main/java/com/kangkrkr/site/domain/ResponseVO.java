package com.kangkrkr.site.domain;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder(builderMethodName = "of")
@Data
public class ResponseVO<T> {
    private HttpStatus responseStatus;
    private String message;
    private T data;
}
