package com.user.usermanagement.service.model;

import org.springframework.util.Assert;

public class UserPersistentIdentity {

    private final String email;

    private final String phoneNumber;

    public UserPersistentIdentity(String email, String phoneNumber) {

        Assert.hasText(email, "mail address must bu imputed!");
        Assert.hasText(phoneNumber, "phone number must bu imputed!");

        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
