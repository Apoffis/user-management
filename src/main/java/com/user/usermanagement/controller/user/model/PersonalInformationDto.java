package com.user.usermanagement.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.usermanagement.persistence.user.profile.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonalInformationDto {

    @NotBlank
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank
    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @JsonProperty("gender")
    private Gender gender;

    @NotNull
    @JsonProperty("birthDate")
    private LocalDate birthDate;

    @NotBlank
    @JsonProperty("address")
    private String address;

    public PersonalInformationDto() {
        super();
    }

    public PersonalInformationDto(String firstName, String lastName, Gender gender, LocalDate birthDate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}