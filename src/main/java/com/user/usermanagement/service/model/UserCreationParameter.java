package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.UserType;
import org.springframework.util.Assert;

public class UserCreationParameter {

    private final UserType type;

    private final UserIdentity identity;

    private final PersonalInformation personalInformation;

    public UserCreationParameter(UserType type, UserIdentity identity, PersonalInformation information) {
        Assert.notNull(type, "Null was passed as an argument for parameter 'type'.");
        Assert.notNull(identity, "Null was passed as an argument for parameter 'identity'.");
        Assert.notNull(information, "Null was passed as an argument for parameter 'information'.");

        this.type = type;
        this.identity = identity;
        this.personalInformation = information;
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
}