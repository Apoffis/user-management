package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.profile.Gender;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class PersonalPersistentInformation {

    private final String firstName;

    private final String lastName;

    private final Gender gender;

    private final LocalDate birthDate;

    private final String address;

    public PersonalPersistentInformation(String firstName, String lastName, Gender gender, LocalDate birthDate, String address) {

        Assert.hasText(firstName, "Input first name!");
        Assert.hasText(lastName, "Input last name!");
        Assert.notNull(gender, "Select the gender!");
        Assert.notNull(birthDate, "input the birth date!");
        Assert.hasText(address, "input the address!");

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
}
