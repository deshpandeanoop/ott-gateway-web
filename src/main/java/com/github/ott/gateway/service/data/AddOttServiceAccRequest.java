package com.github.ott.gateway.service.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AddOttServiceAccRequest {

    private final List<OttServiceAccount> ottServiceAccountsDetails = new ArrayList<>();
}
