package com.user.usermanagement.persistence.user;

import com.user.usermanagement.persistence.AbstractEntity;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserIdentity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "identity_id",
            referencedColumnName = "id",
            nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_users_identity_id")
    )
    private UserIdentity identity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "personal_information_id",
            referencedColumnName = "id",
            nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_users_personal_information_id")
    )
    private PersonalInformation personalInformation;

    protected User() {
        super();
    }

    public User(UserType type, UserIdentity identity, PersonalInformation personalInformation) {
        this.type = type;
        this.identity = identity;
        this.personalInformation = personalInformation;
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
