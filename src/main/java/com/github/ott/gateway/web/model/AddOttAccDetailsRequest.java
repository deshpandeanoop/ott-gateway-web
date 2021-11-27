package com.github.ott.gateway.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddOttAccDetailsRequest {

    private List<OttAccDetails> ottAccDetails = new ArrayList<>();
}
