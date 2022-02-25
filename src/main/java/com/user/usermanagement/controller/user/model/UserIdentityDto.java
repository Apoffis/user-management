package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class UserIdentityDto {

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("phone")
    private String phone;

    public UserIdentityDto() {
        super();
    }

    public UserIdentityDto(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}