package com.consultadd.controller;

import com.consultadd.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessage {

    @Autowired
    private MyProperties myProperties;

    @GetMapping("/msg")
    public String message() {
        return "Hello! " + myProperties.getName();
    }
}