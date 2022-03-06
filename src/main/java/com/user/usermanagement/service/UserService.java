package com.user.usermanagement.service;

import com.user.usermanagement.persistence.user.profile.UserFullName;
import com.user.usermanagement.service.model.PersonalInformation;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDetails> findAll();

    UserDetails getById(Long id);

    void deleteById(Long id);

    void changeEmail(Long id, String email);

    void changePhone(Long id, String phone);

    void changePersonalInformation(Long id, PersonalInformation information);

    Optional<UserDetails> findById(Long id);

    Optional<UserFullName> getUserFullName(Long id);

    Long create(UserCreationParameter parameter);

    Optional<UserDetails> findByIdentity(String identity);
}