package com.cg.product_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> greet(){
        String welcomeMessage = "Welcome to Microservices training session!";
        return ResponseEntity.ok(welcomeMessage);
    }
}
