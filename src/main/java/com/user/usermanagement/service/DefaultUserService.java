package com.user.usermanagement.service;

import com.user.usermanagement.exception.UserNotFoundException;
import com.user.usermanagement.persistence.user.User;
import com.user.usermanagement.persistence.user.profile.PersistentPersonalInformation;
import com.user.usermanagement.persistence.user.profile.PersistentUserIdentity;
import com.user.usermanagement.persistence.user.profile.UserFullName;
import com.user.usermanagement.persistence.user.repository.PersonalInformationRepository;
import com.user.usermanagement.persistence.user.repository.UserIdentityRepository;
import com.user.usermanagement.persistence.user.repository.UserRepository;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;
import com.user.usermanagement.service.model.UserIdentity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Service
class DefaultUserService implements UserService {

    private final Executor executor;

    private final UserRepository userRepository;

    private final UserIdentityRepository userIdentityRepository;

    private final PersonalInformationRepository personalInformationRepository;

    DefaultUserService(Executor executor, UserRepository userRepository, UserIdentityRepository userIdentityRepository, PersonalInformationRepository personalInformationRepository) {
        this.executor = executor;
        this.userRepository = userRepository;
        this.userIdentityRepository = userIdentityRepository;
        this.personalInformationRepository = personalInformationRepository;
    }

    @Override
    public UserDetails getById(Long id) {
        Assert.notNull(id, "Null was passed as an argument for parameter 'id'.");
        return userRepository.findById(id).map(UserDetails::new)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Optional<UserDetails> findById(Long id) {
        return userRepository.findById(id).map(UserDetails::new);
    }

    @Override
    public List<UserDetails> findAll() {
        return userRepository.findAll().stream().map(UserDetails::new).collect(Collectors.toList());
    }

    @Override
    public void changeEmail(Long id, String email) {
        Assert.notNull(id, "Null was passed as an argument for parameter 'id'.");
        Assert.hasText(email, "Null or empty text was passed as an argument for parameter 'email'.");

        userIdentityRepository.findByUserId(id).ifPresentOrElse(identity -> {
                    if (userIdentityRepository.existsByEmail(email)) {
                        throw new IllegalArgumentException(email + " is not exists!");
                    }
                    userIdentityRepository.save(identity.changeEmail(email));
                },
                () -> {
                    throw new UserNotFoundException(id);
                }
        );
    }

    @Override
    public Optional<UserFullName> getUserFullName(Long id) {
        return personalInformationRepository.getFullName(id);
    }

    @Override
    public Optional<UserDetails> findByIdentity(String identity) {
        Assert.hasText(identity, "Null or empty text was passed as an argument for parameter 'identity'.");
        Optional<User> userHolder = identity.indexOf('@') > 0
                ? userRepository.findByIdentityEmail(identity)
                : userRepository.findByIdentityPhone(identity);
        return userHolder.map(UserDetails::new);
    }

    @Override
    public Long create(UserCreationParameter parameter) {
        Assert.notNull(parameter, "Null was passed as an argument for parameter 'parameter'.");
        if (userIdentityRepository.existsByEmail(parameter.getIdentity().getEmail())) {

        }
        if (userIdentityRepository.existsByPhone(parameter.getIdentity().getPhone())) {

        }
        User user = new User(
                parameter.getType(),
                new PersistentUserIdentity(
                        parameter.getIdentity().getEmail(),
                        parameter.getIdentity().getPhone()
                ),
                new PersistentPersonalInformation(
                        parameter.getPersonalInformation().getFirstName(),
                        parameter.getPersonalInformation().getLastName(),
                        parameter.getPersonalInformation().getGender(),
                        parameter.getPersonalInformation().getBirthDate(),
                        parameter.getPersonalInformation().getAddress()
                )
        );
        return userRepository.save(user).getId();
    }
}
