package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.persistence.user.profile.UserFullName;

public class UserFullNameDto {

    @JsonProperty("firstName")
    private final String firstName;

    @JsonProperty("lastName")
    private final String lastName;

    public UserFullNameDto(final UserFullName userFullName) {
        this.firstName = userFullName.getFirstName();
        this.lastName = userFullName.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
