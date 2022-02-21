package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.persistence.user.UserType;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserIdentity;

import javax.persistence.*;

public class UserCreationRequest {

    @JsonProperty("type")
    private UserType userType;

    @JsonProperty("identity_id")
    private UserIdentity userIdentity;

    @JsonProperty("personal_information_id")
    private PersonalInformation personalInformation;

    public UserCreationRequest() {
        super();
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
}
