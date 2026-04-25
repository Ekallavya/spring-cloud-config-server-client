package com.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limitservice.beans.LimitConfig;

@RefreshScope
@RestController
public class LimitController {
    @Autowired
    private Environment env;
    @Autowired
    private LimitConfig limits;
    @Value("${msg:Default message}")
    private String message;
  
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        System.out.println("limits-maximum:"+limits.getMaximum());
        System.out.println("limits-minimum:"+limits.getMinimum());
        //return new ResponseEntity<String>(message, HttpStatus.OK);
        return new ResponseEntity<String>( String.format("Message :%s  MaxLimit : %d and MinLimit : %d",message,limits.getMaximum(),limits.getMinimum()), HttpStatus.OK);
        
    }

}
