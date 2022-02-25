package com.user.usermanagement.service;

import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;

import java.util.Optional;

public interface UserService {

    UserDetails getById(Long id);

    Optional<UserDetails> findById(Long id);

    Long create(UserCreationParameter parameter);

    Optional<UserDetails> findByIdentity(String identity);
}