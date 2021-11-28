package com.github.ott.gateway.web.utils;

import com.github.ott.gateway.service.data.AddOttServiceAccRequest;
import com.github.ott.gateway.service.data.OttServiceAccount;
import com.github.ott.gateway.service.data.PlatformUser;
import com.github.ott.gateway.service.data.RegisterPlatformUserRequest;
import com.github.ott.gateway.web.model.AddOttAccDetailsRequest;
import com.github.ott.gateway.web.model.RegisterRequest;

import java.util.List;
import java.util.stream.Collectors;

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

    public static AddOttServiceAccRequest buildAddPttSvcAccRequest(AddOttAccDetailsRequest accDetailsRequest, final String gatewayUserId) {
        AddOttServiceAccRequest addOttServiceAccRequest = new AddOttServiceAccRequest();
        List<OttServiceAccount> ottServiceAccounts = accDetailsRequest
                .getOttAccDetails()
                .stream()
                .map(ottAccDetails -> {
                    OttServiceAccount ottServiceAccount = new OttServiceAccount();
                    ottServiceAccount.setUsername(ottAccDetails.getUsername());
                    ottServiceAccount.setPassword(ottAccDetails.getPassword());
                    ottServiceAccount.setGateWayServiceUserId(gatewayUserId);
                    ottServiceAccount.setPlatformType(ottAccDetails.getPlatform());
                    return ottServiceAccount;
                }).collect(Collectors.toList());
        addOttServiceAccRequest.getOttServiceAccountsDetails().addAll(ottServiceAccounts);

        return addOttServiceAccRequest;
    }
}
