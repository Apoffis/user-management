package com.user.usermanagement.service;

import com.user.usermanagement.exception.UserNotFoundException;
import com.user.usermanagement.persistence.user.User;
import com.user.usermanagement.persistence.user.profile.PersonalInformation;
import com.user.usermanagement.persistence.user.profile.UserIdentity;
import com.user.usermanagement.persistence.user.repository.UserRepository;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    DefaultUserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDetails> findById(Long id) {
        Assert.notNull(id, "Id must be imputed!");
        return userRepository.findById(id).map(UserDetails::new);
    }

    @Override
    public UserDetails getById(Long id) {
        Assert.notNull(id, "Id must be imputed!");
        return findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Long create(UserCreationParameter parameter) {

        User user = new User(parameter.getType(),
                new UserIdentity(
                        parameter.getUserIdentity().getEmail(),
                        parameter.getUserIdentity().getPhoneNumber()),
                new PersonalInformation(
                        parameter.getPersonalInformation().getFirstName(),
                        parameter.getPersonalInformation().getLastName(),
                        parameter.getPersonalInformation().getGender(),
                        parameter.getPersonalInformation().getBirthDate(),
                        parameter.getPersonalInformation().getAddress())
                );

        return userRepository.save(user).getId();
    }
}
