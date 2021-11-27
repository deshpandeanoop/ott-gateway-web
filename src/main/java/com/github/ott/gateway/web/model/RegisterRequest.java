package com.github.ott.gateway.web.model;

import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
}