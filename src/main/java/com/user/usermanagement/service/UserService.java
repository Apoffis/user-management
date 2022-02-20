package com.user.usermanagement.service;

import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;

import java.util.Optional;

public interface UserService {

    Optional<UserDetails> findById(Long id);

    UserDetails getById(Long id);

    Long create(UserCreationParameter parameter);
}
