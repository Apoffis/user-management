package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.controller.AbstractResponse;
import com.user.usermanagement.persistence.user.UserType;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserIdentity;

import java.time.LocalDateTime;

public class UserDetailsDto extends AbstractResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private UserType type;

    @JsonProperty("identity")
    private UserIdentity identity;

    @JsonProperty("personal_information")
    private PersonalInformation personalInformation;

    @JsonProperty("created_on")
    private LocalDateTime createdOn;

    @JsonProperty("updated_on")
    private LocalDateTime updatedOn;

    public UserDetailsDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(UserIdentity identity) {
        this.identity = identity;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

}
