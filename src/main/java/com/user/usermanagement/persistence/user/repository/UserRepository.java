package com.user.usermanagement.persistence.user.repository;

import com.user.usermanagement.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdentityEmail(String email);

    Optional<User> findByIdentityPhone(String phone);
}