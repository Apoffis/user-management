package com.user.usermanagement.persistence.user.repository;

import com.user.usermanagement.persistence.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @EntityGraph("user.details")
    Optional<User> findById(@NonNull Long id);

    @EntityGraph("user.details")
    Optional<User> findByIdentityEmail(String email);

    @EntityGraph("user.details")
    List<User> findAll();

    @EntityGraph("user.details")
    Optional<User> findByIdentityPhone(String phone);
}