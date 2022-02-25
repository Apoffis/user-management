package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.controller.AbstractResponse;

public class GetUserDetailResponse extends AbstractResponse {

    @JsonProperty("details")
    private UserDetailsDto details;

    public GetUserDetailResponse(String message) {
        super(message);
    }

    public GetUserDetailResponse(UserDetailsDto details) {
        this.details = details;
    }

    public UserDetailsDto getDetails() {
        return details;
    }
}