package com.user.usermanagement.service.model;

import org.springframework.util.Assert;

public class UserIdentity {

    private final String email;

    private final String phone;

    public UserIdentity(String email, String phone) {
        Assert.hasText(email, "Null or empty text was passed as an argument for parameter 'email'.");
        Assert.hasText(phone, "Null or empty text was passed as an argument for parameter 'phone'.");

        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}