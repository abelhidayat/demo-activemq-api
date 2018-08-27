package com.abel.activemqapi.demoactivemqapi.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse extends Response {
    private Object data;

    public SuccessResponse(Integer status, Long timeStamp, String message, Object data) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
        this.data = data;
    }

    public static SuccessResponse body(String message, Object data) {
        return body(HttpStatus.OK.value(), System.currentTimeMillis(), message, data);
    }

    public static SuccessResponse body(Integer status, Long timeStamp, String message, Object data) {
        return new SuccessResponse(status, timeStamp, message, data);
    }
}
