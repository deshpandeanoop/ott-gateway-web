package com.github.ott.gateway.service.data;

import lombok.Data;

import java.util.List;

@Data
public class GetOttServiceAccResponse {

    private List<OttServiceAccount> ottServiceAccounts;
}
