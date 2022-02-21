package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.User;
import com.user.usermanagement.persistence.user.UserType;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserIdentity;

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
        this.identity = user.getIdentity();
        this.personalInformation = user.getPersonalInformation();
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

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", type=" + type +
                ", identity=" + identity +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
