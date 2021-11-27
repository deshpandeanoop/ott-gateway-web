package com.github.ott.gateway.web.controller;

import com.github.ott.gateway.web.model.AddOttAccDetailsRequest;
import com.github.ott.gateway.web.model.LogInRequest;
import com.github.ott.gateway.web.model.OttAccDetails;
import com.github.ott.gateway.web.model.RegisterRequest;
import com.github.ott.gateway.web.utils.GatewayServiceRequestResponseBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RequestMapping("/")
@Controller
public class OttGatewayWebController {

    private final RestTemplate restTemplate = new RestTemplate();

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
        restTemplate.postForEntity("http://localhost:9000/ott-gateway-service/v1/users", GatewayServiceRequestResponseBuilder.buildRegisterPlatformUserRequest(registerRequest), String.class);
        AddOttAccDetailsRequest addOttAccDetailsRequest = new AddOttAccDetailsRequest();
        addOttAccDetailsRequest.getOttAccDetails().add(new OttAccDetails());
        model.addAttribute("form", addOttAccDetailsRequest);
        return "add-ott-details";
    }

    @CrossOrigin
    @GetMapping("/login")
    public String login(@ModelAttribute LogInRequest logInRequest) {
        return "display-ott-details";
    }

    @CrossOrigin
    @PostMapping("/ottAccounts")
    public String addOttDetails(@ModelAttribute AddOttAccDetailsRequest addOttAccDetailsRequest) {
        return "display-ott-details";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/homepage";
    }
}
