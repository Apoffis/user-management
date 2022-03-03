package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.controller.AbstractResponse;

public class GetUserFullNameResponse extends AbstractResponse {

    @JsonProperty("details")
    private UserFullNameDto details;

    public GetUserFullNameResponse(String message) {
        super(message);
    }

    public GetUserFullNameResponse(UserFullNameDto details) {
        this.details = details;
    }

    public UserFullNameDto getDetails() {
        return details;
    }
}