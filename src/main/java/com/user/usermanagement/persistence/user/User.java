package com.user.usermanagement.persistence.user;

import com.user.usermanagement.persistence.AbstractEntity;
import com.user.usermanagement.persistence.user.profile.PersistentPersonalInformation;
import com.user.usermanagement.persistence.user.profile.PersistentUserIdentity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "identity_id",
            referencedColumnName = "id",
            nullable = false, updatable = false, unique = true,
            foreignKey = @ForeignKey(name = "FK_users_identity_id")
    )
    private PersistentUserIdentity identity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "personal_information_id",
            referencedColumnName = "id",
            nullable = false, updatable = false, unique = true,
            foreignKey = @ForeignKey(name = "FK_users_personal_information_id")
    )
    private PersistentPersonalInformation personalInformation;

    protected User() {
        super();
    }

    public User(UserType type, PersistentUserIdentity identity, PersistentPersonalInformation personalInformation) {
        this.type = type;
        this.identity = identity;
        this.personalInformation = personalInformation;
    }

    public UserType getType() {
        return type;
    }

    public PersistentUserIdentity getIdentity() {
        return identity;
    }

    public PersistentPersonalInformation getPersonalInformation() {
        return personalInformation;
    }
}