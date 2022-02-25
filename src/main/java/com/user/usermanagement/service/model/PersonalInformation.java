package com.user.usermanagement.service.model;

import com.user.usermanagement.persistence.user.profile.Gender;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class PersonalInformation {

    private final String firstName;

    private final String lastName;

    private final Gender gender;

    private final LocalDate birthDate;

    private final String address;

    public PersonalInformation(String firstName, String lastName, Gender gender, LocalDate birthDate, String address) {
        Assert.hasText(firstName, "Null or empty text was passed as an argument for parameter 'firstName'.");
        Assert.hasText(lastName, "Null or empty text was passed as an argument for parameter 'lastName'.");
        Assert.notNull(gender, "Null was passed as an argument for parameter 'gender'.");
        Assert.notNull(birthDate, "Null was passed as an argument for parameter 'birthDate'.");
        Assert.hasText(address, "Null or empty text was passed as an argument for parameter 'address'.");

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