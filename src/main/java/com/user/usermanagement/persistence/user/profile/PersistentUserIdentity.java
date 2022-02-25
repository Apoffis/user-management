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
                @UniqueConstraint(name = "UQ_user_identity_phone", columnNames = "phone")
        }
)
public class PersistentUserIdentity extends AbstractEntity {

    @Column(name = "email", length = 64, nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 64, nullable = false, unique = true)
    private String phone;

    protected PersistentUserIdentity() {
        super();
    }

    public PersistentUserIdentity(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}