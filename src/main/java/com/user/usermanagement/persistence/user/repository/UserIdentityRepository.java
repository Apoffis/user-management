package com.user.usermanagement.persistence.user.repository;

import com.user.usermanagement.persistence.user.profile.PersistentUserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdentityRepository extends JpaRepository<PersistentUserIdentity, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}