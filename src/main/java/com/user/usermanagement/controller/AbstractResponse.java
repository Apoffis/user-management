package com.user.usermanagement.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResponse {

    @JsonProperty("error_msg")
    private String message;

    public AbstractResponse() {
        super();
    }

    public AbstractResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
