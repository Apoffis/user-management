package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.persistence.user.UserType;
import com.user.usermanagement.service.model.UserDetails;

import java.time.LocalDateTime;

public class UserDetailsDto {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("type")
    private final UserType type;

    @JsonProperty("identity")
    private final UserIdentityDto identity;

    @JsonProperty("personalInformation")
    private final PersonalInformationDto personalInformation;

    @JsonProperty("createdOn")
    private final LocalDateTime createdOn;

    @JsonProperty("updatedOn")
    private final LocalDateTime updatedOn;

    public UserDetailsDto(final UserDetails details) {
        this.id = details.getId();
        this.type = details.getType();
        this.identity = new UserIdentityDto(
                details.getIdentity().getEmail(),
                details.getIdentity().getPhone()
        );
        this.personalInformation = new PersonalInformationDto(

        );
        this.createdOn = details.getCreatedOn();
        this.updatedOn = details.getUpdatedOn();
    }

    public Long getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public UserIdentityDto getIdentity() {
        return identity;
    }

    public PersonalInformationDto getPersonalInformation() {
        return personalInformation;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}