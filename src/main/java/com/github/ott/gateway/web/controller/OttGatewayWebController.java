package com.github.ott.gateway.web.controller;

import com.github.ott.gateway.web.model.AddOttAccDetailsRequest;
import com.github.ott.gateway.web.model.LogInRequest;
import com.github.ott.gateway.web.model.OttAccDetails;
import com.github.ott.gateway.web.model.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/")
@Controller
public class OttGatewayWebController {

    @CrossOrigin
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("loginRequest", new LogInRequest());
        model.addAttribute("registerRequest", new RegisterRequest());
        return "homepage";
    }

    @CrossOrigin
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest registerRequest, Model model)
    {
        AddOttAccDetailsRequest addOttAccDetailsRequest = new AddOttAccDetailsRequest();
        addOttAccDetailsRequest.getOttAccDetails().add(new OttAccDetails());
        model.addAttribute("form", addOttAccDetailsRequest);
        return "add-ott-details";
    }

    @CrossOrigin
    @PostMapping("/login")
    public String login(@ModelAttribute LogInRequest logInRequest) {
        return "";
    }

    @CrossOrigin
    @PostMapping("/ottAccounts")
    public String addOttDetails(@ModelAttribute AddOttAccDetailsRequest addOttAccDetailsRequest) {
        return "";
    }
}
