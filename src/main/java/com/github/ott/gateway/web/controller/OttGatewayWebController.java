package com.github.ott.gateway.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class OttGatewayWebController {

    @CrossOrigin
    @GetMapping("/home")
    public String homePage() {
        return "homepage";
    }

    @CrossOrigin
    @GetMapping("/register")
    public String register() {
        return "add-ott-details";
    }
}
