package com.abel.activemqapi.demoactivemqapi.controller;

import com.abel.activemqapi.demoactivemqapi.dto.SuccessResponse;
import com.abel.activemqapi.demoactivemqapi.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class DemoController {

    @Autowired
    ProducerService producerService;

    private static final String message = "Success sent";

    @PostMapping(value = "produceQueue")
    ResponseEntity<SuccessResponse> produceQueue(@RequestBody String strMsg){
        producerService.produceQueue(strMsg);
        return ResponseEntity.ok(SuccessResponse.body(message, strMsg));
    }

    @PostMapping(value = "produceTopic")
    ResponseEntity<SuccessResponse> produceTopic(@RequestBody String strMsg){
        producerService.produceTopic(strMsg);
        return ResponseEntity.ok(SuccessResponse.body(message, strMsg));
    }
}
