package com.abel.activemqapi.demoactivemqapi.dto;

import lombok.Data;

@Data
public class Response {
    protected Integer status;
    protected Long timeStamp;
    protected String message;
}
