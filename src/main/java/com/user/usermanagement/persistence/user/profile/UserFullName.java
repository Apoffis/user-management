package com.user.usermanagement.persistence.user.profile;

public class UserFullName {

    private final String firstName;

    private final String lastName;

    public UserFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getValue() {
        return firstName + " " + lastName;
    }
}
