package com.github.ott.gateway.web.controller;

import com.github.ott.gateway.service.data.GetOttServiceAccResponse;
import com.github.ott.gateway.service.data.OttServiceAccount;
import com.github.ott.gateway.web.model.AddOttAccDetailsRequest;
import com.github.ott.gateway.web.model.LogInRequest;
import com.github.ott.gateway.web.model.OttAccDetails;
import com.github.ott.gateway.web.model.RegisterRequest;
import com.github.ott.gateway.web.utils.GatewayServiceRequestResponseBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@RequestMapping("/")
@Controller
public class OttGatewayWebController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String SVC_BASE_URL = "http://localhost:9000/ott-gateway-service";

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
        restTemplate.postForEntity(SVC_BASE_URL + "/v1/users", GatewayServiceRequestResponseBuilder.buildRegisterPlatformUserRequest(registerRequest), String.class);
        AddOttAccDetailsRequest addOttAccDetailsRequest = new AddOttAccDetailsRequest();
        addOttAccDetailsRequest.getOttAccDetails().add(new OttAccDetails());
        model.addAttribute("form", addOttAccDetailsRequest);
        model.addAttribute("userId", registerRequest.getUsername());
        return "add-ott-details";
    }

    @CrossOrigin
    @GetMapping("/login")
    public String login(@ModelAttribute LogInRequest logInRequest) {
        return "redirect:/display-ott-details";
    }

    @CrossOrigin
    @PostMapping("/ottAccounts")
    public String addOttDetails(@ModelAttribute AddOttAccDetailsRequest addOttAccDetailsRequest,
                                HttpServletRequest httpRequest,
                                Model model) {
        String gatewayServiceId = httpRequest.getParameter("gatewayUserId");
        restTemplate.postForEntity(SVC_BASE_URL + "/v1/ottaccounts",
                GatewayServiceRequestResponseBuilder.buildAddPttSvcAccRequest(addOttAccDetailsRequest, gatewayServiceId), String.class);
        populateOttPlatformsInModel(getOttPlatformNamesOfUser(gatewayServiceId), model);
        return "display-ott-details";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/homepage";
    }

    private Set<String> getOttPlatformNamesOfUser(String gatewayUserId) {
        return Objects.requireNonNull(restTemplate.getForEntity(SVC_BASE_URL + "/v1/ottaccounts?gatewayUserId="+gatewayUserId+"&fetchOnlyNames=true&platformType=",
                GetOttServiceAccResponse.class).getBody())
                .getOttServiceAccounts()
                .stream()
                .map(OttServiceAccount::getPlatformType)
                .collect(Collectors.toSet());
    }

    private void populateOttPlatformsInModel(Set<String> ottPlatforms, Model model) {
        model.addAttribute("hasAmazonPrimeDetails", ottPlatforms.contains("AMAZON_PRIME"));
        model.addAttribute("hasNetflixDetails", ottPlatforms.contains("NETFLIX"));
        model.addAttribute("hasHotstarDetails", ottPlatforms.contains("HOTSTAR"));
    }
}
