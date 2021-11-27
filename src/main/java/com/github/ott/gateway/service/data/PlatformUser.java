package com.github.ott.gateway.service.data;

import lombok.Data;

@Data
public class PlatformUser extends UserAccount {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
