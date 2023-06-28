package com.cts.authenticationmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @GetMapping("/hello")
    public String serverPort(){
        return "Your code is running on server port "+environment.getProperty("local.server.port");
    }
}
