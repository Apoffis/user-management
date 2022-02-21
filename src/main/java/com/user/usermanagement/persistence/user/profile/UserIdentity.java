package com.user.usermanagement.persistence.user.profile;

import com.user.usermanagement.persistence.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        name = "user_identity",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_user_identity_email", columnNames = "email"),
                @UniqueConstraint(name = "UQ_user_identity_phone_number", columnNames = "phone_number")
        }
)
public class UserIdentity extends AbstractEntity {

    @Column(name = "email", length = 64, nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 128, nullable = false, unique = true)
    private String phoneNumber;

    protected UserIdentity() {
        super();
    }

    public UserIdentity(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
