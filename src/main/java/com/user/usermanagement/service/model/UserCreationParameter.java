package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.UserType;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import org.springframework.util.Assert;

public class UserCreationParameter {

    private final UserType type;

    private final UserPersistentIdentity userIdentity;

    private final PersonalPersistentInformation personalInformation;

    public UserCreationParameter(
            UserType type, UserPersistentIdentity identity,
            PersonalPersistentInformation personalInformation) {

        Assert.notNull(type, "User Type dose not selected!");
        Assert.notNull(identity, "User Identity dose not selected!");
        Assert.notNull(personalInformation, "User personal information dose not selected!");

        this.type = type;
        this.userIdentity = identity;
        this.personalInformation = personalInformation;
    }

    public UserType getType() {
        return type;
    }

    public UserPersistentIdentity getUserIdentity() {
        return userIdentity;
    }

    public PersonalPersistentInformation getPersonalInformation() {
        return personalInformation;
    }
}
