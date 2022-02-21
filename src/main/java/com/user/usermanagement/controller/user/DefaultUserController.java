package com.user.usermanagement.controller.user;

import com.user.usermanagement.controller.user.model.GetUserDetailResponse;
import com.user.usermanagement.controller.user.model.UserCreationRequest;
import com.user.usermanagement.controller.user.model.UserCreationResponse;
import com.user.usermanagement.controller.user.model.UserDetailsDto;
import com.user.usermanagement.exception.UserAlreadyException;
import com.user.usermanagement.service.UserService;
import com.user.usermanagement.service.model.PersonalPersistentInformation;
import com.user.usermanagement.service.model.UserCreationParameter;
import com.user.usermanagement.service.model.UserDetails;
import com.user.usermanagement.service.model.UserPersistentIdentity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserController implements UserController {

    private final UserService userService;

    DefaultUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserCreationResponse> create(UserCreationRequest request) {

        final UserCreationParameter creationParameter = new UserCreationParameter(
                request.getUserType(),
                new UserPersistentIdentity(
                        request.getUserIdentity().getEmail(),
                        request.getUserIdentity().getPhoneNumber()
                ),
                new PersonalPersistentInformation(
                        request.getPersonalInformation().getFirstName(),
                        request.getPersonalInformation().getLastName(),
                        request.getPersonalInformation().getGender(),
                        request.getPersonalInformation().getBirthDate(),
                        request.getPersonalInformation().getAddress()
                )
        );

        final UserCreationResponse creationResponse = new UserCreationResponse();

        try {
            creationResponse.setId(userService.create(creationParameter));
            return ResponseEntity.ok(creationResponse);
        } catch (UserAlreadyException ex) {
            creationResponse.setMessage(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(creationResponse);
        }
    }

    @Override
    public ResponseEntity<GetUserDetailResponse> get(Long id) {

        final GetUserDetailResponse detailResponse = new GetUserDetailResponse();

        try {
            UserDetails details = userService.getById(id);

            UserDetailsDto userDetailsDto = toDto(details);

            detailResponse.setUserDetailsDto(userDetailsDto);
            return ResponseEntity.ok(detailResponse);

        } catch (UserAlreadyException ex) {
            detailResponse.setMessage(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detailResponse);
        }

    }

    private UserDetailsDto toDto(UserDetails details) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setId(details.getId());
        userDetailsDto.setType(details.getType());
        userDetailsDto.setPersonalInformation(details.getPersonalInformation());
        userDetailsDto.setCreatedOn(details.getCreatedOn());
        userDetailsDto.setUpdatedOn(details.getUpdatedOn());
        return userDetailsDto;
    }

}
