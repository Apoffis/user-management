package com.user.usermanagement.service;

import com.user.usermanagement.persistence.user.profile.UserFullName;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDetails getById(Long id);

    Optional<UserDetails> findById(Long id);

    List<UserDetails> findAll();

    void changeEmail(Long id, String email);

    Optional<UserFullName> getUserFullName(Long id);

    Long create(UserCreationParameter parameter);

    Optional<UserDetails> findByIdentity(String identity);
}