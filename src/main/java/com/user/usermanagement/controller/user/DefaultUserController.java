package com.user.usermanagement.controller.user;

import com.user.usermanagement.controller.user.model.*;
import com.user.usermanagement.exception.UserAlreadyException;
import com.user.usermanagement.service.UserService;
import com.user.usermanagement.service.model.PersonalInformation;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserIdentity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
public class DefaultUserController implements UserController {

    private final UserService userService;

    DefaultUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserCreationResponse> create(UserCreationRequest request) {
        final UserCreationParameter creationParameter = new UserCreationParameter(
                request.getType(),
                new UserIdentity(
                        request.getIdentity().getEmail(),
                        request.getIdentity().getPhone()
                ),
                new PersonalInformation(
                        request.getPersonalInformation().getFirstName(),
                        request.getPersonalInformation().getLastName(),
                        request.getPersonalInformation().getGender(),
                        request.getPersonalInformation().getBirthDate(),
                        request.getPersonalInformation().getAddress()
                )
        );
        try {
            return ResponseEntity.ok(new UserCreationResponse(userService.create(creationParameter)));
        } catch (UserAlreadyException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserCreationResponse(ex.getMessage()));
        }
    }

    @Override
    public void changeEmail(Long id, String email) {
        userService.changeEmail(id, email);
    }

    @Override
    public void changePhone(Long id, String phone) {
        userService.changePhone(id, phone);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteById(id);
    }

    @Override
    public void changeUser(Long id, PersonalInformationRequest request) {

        System.out.println(request.getFirstName());
        System.out.println(request.getLastName());
        System.out.println(request.getGender());
        System.out.println(request.getBirthDate());
        System.out.println(request.getAddress());

        userService.changePersonalInformation(id,
                new PersonalInformation(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getGender(),
                        request.getBirthDate(),
                        request.getAddress()
                )
        );
    }

    @Override
    public ResponseEntity<GetUserDetailResponse> getDetailsById(Long id) {

        return userService.findById(id)
                .map(UserDetailsDto::new)
                .map(GetUserDetailResponse::new)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<GetUserFullNameResponse> getFullNameById(Long id) {
        return userService.getUserFullName(id)
                .map(UserFullNameDto::new)
                .map(GetUserFullNameResponse::new)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public List<GetUserDetailResponse> getAll() {
        return userService.findAll().stream()
                .map(UserDetailsDto::new)
                .map(GetUserDetailResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<GetUserDetailResponse> getDetails(String identity) {
        return userService.findByIdentity(identity)
                .map(UserDetailsDto::new)
                .map(GetUserDetailResponse::new)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
