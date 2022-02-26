package com.user.usermanagement.service;

import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;
import com.user.usermanagement.service.model.UserSearchParameter;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    UserDetails getById(Long id);

    Optional<UserDetails> findById(Long id);

    List<UserDetails> findAll();

    CompletableFuture<List<UserDetails>> findAllPageable(UserSearchParameter parameter);

    Long create(UserCreationParameter parameter);

    Optional<UserDetails> findByIdentity(String identity);
}