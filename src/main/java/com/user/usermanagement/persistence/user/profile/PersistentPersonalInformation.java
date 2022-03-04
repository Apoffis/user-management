package com.user.usermanagement.persistence.user.profile;

import com.user.usermanagement.persistence.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person_information")
public class PersistentPersonalInformation extends AbstractEntity {

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date", nullable = false, length = 12)
    private LocalDate birthDate;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    protected PersistentPersonalInformation() {
        super();
    }

    public PersistentPersonalInformation(String firstName, String lastName, Gender gender, LocalDate birthDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}