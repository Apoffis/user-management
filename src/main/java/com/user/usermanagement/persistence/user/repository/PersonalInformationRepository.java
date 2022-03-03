package com.user.usermanagement.persistence.user.repository;

import com.user.usermanagement.persistence.user.profile.PersistentPersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserFullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersistentPersonalInformation, Long> {

    @Query(
            "select new com.user.usermanagement.persistence.user.profile.UserFullName(info.firstName, info.lastName)" +
                    "from PersistentPersonalInformation info inner join User u on u.personalInformation.id = info.id where u.id = :userId"
    )
    Optional<UserFullName> getFullName(@Param("userId") Long userId);
}