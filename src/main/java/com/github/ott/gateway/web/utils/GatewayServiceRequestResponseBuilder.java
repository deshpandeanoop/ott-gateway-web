package com.github.ott.gateway.web.utils;

import com.github.ott.gateway.service.data.PlatformUser;
import com.github.ott.gateway.service.data.RegisterPlatformUserRequest;
import com.github.ott.gateway.web.model.RegisterRequest;

public final class GatewayServiceRequestResponseBuilder {

    private GatewayServiceRequestResponseBuilder() {}

    public static RegisterPlatformUserRequest buildRegisterPlatformUserRequest(RegisterRequest registerRequest) {
        RegisterPlatformUserRequest platformUserRequest = new RegisterPlatformUserRequest();
        PlatformUser platformUser = new PlatformUser();
        platformUser.setFirstName(registerRequest.getFirstName());
        platformUser.setLastName(registerRequest.getLastName());
        platformUser.setUsername(registerRequest.getUsername());
        platformUser.setPassword(registerRequest.getPassword());
        platformUserRequest.setUserDetails(platformUser);

        return platformUserRequest;
    }
}
