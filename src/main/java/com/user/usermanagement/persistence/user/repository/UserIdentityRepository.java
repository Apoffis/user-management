package com.user.usermanagement.persistence.user.repository;

import com.user.usermanagement.persistence.user.profile.PersistentUserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserIdentityRepository extends JpaRepository<PersistentUserIdentity, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    @Query(
            value = "from PersistentUserIdentity identity " +
                    "inner join User u on u.identity.id = identity.id  " +
                    "where u.id = :userId"
    )
    Optional<PersistentUserIdentity> findByUserId(@Param("userId") Long userId);
}