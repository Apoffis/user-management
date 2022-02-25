package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.persistence.user.UserType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserCreationRequest {

    @NotNull
    @JsonProperty("type")
    private UserType type;

    @Valid
    @NotNull
    @JsonProperty("identity")
    private UserIdentityDto identity;

    @Valid
    @NotNull
    @JsonProperty("personalInformation")
    private PersonalInformationDto personalInformation;

    public UserCreationRequest() {
        super();
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserIdentityDto getIdentity() {
        return identity;
    }

    public void setIdentity(UserIdentityDto identity) {
        this.identity = identity;
    }

    public PersonalInformationDto getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformationDto personalInformation) {
        this.personalInformation = personalInformation;
    }
}