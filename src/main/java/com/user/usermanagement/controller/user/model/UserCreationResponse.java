package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.controller.AbstractResponse;

public class UserCreationResponse extends AbstractResponse {

    @JsonProperty("id")
    private Long id;

    public UserCreationResponse(Long id) {
        this.id = id;
    }

    public UserCreationResponse(String message) {
        super(message);
    }

    public Long getId() {
        return id;
    }
}