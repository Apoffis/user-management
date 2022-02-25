package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.User;
import com.user.usermanagement.persistence.user.UserType;

import java.time.LocalDateTime;

public class UserDetails {

    private final Long id;

    private final UserType type;

    private final UserIdentity identity;

    private final PersonalInformation personalInformation;

    private final LocalDateTime createdOn;

    private final LocalDateTime updatedOn;

    public UserDetails(final User user) {
        this.id = user.getId();
        this.type = user.getType();
        this.identity = new UserIdentity(
                user.getIdentity().getEmail(),
                user.getIdentity().getPhone()
        );
        this.personalInformation = new PersonalInformation(
                user.getPersonalInformation().getFirstName(),
                user.getPersonalInformation().getLastName(),
                user.getPersonalInformation().getGender(),
                user.getPersonalInformation().getBirthDate(),
                user.getPersonalInformation().getAddress()
        );
        this.createdOn = user.getCreatedOn();
        this.updatedOn = user.getUpdatedOn();
    }

    public Long getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public UserIdentity getIdentity() {
        return identity;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}