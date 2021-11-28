package com.github.ott.gateway.service.data;

import lombok.Data;

@Data
public class OttServiceAccount extends UserAccount{

    private String platformType;
    private String gateWayServiceUserId;
}
