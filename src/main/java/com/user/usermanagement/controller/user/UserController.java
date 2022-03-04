package com.user.usermanagement.controller.user;

import com.user.usermanagement.controller.user.model.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface UserController {

    @GetMapping(value = "/{id}")
    ResponseEntity<GetUserDetailResponse> getDetailsById(@PathVariable("id") Long id);

    @GetMapping(value = "/name/{id}")
    ResponseEntity<GetUserFullNameResponse> getFullNameById(@PathVariable("id") Long id);

    @GetMapping(value = "/all")
    List<GetUserDetailResponse> getAll();

    @GetMapping(value = "/details/{identity}")
    ResponseEntity<GetUserDetailResponse> getDetails(@PathVariable("identity") String identity);

    @PostMapping("/")
    ResponseEntity<UserCreationResponse> create(@Valid @RequestBody UserCreationRequest request);

    @PostMapping("/update/email/{id}")
    void changeEmail(@PathVariable("id") Long id, @Valid @RequestParam String email);

    @PostMapping("/update/phone/{id}")
    void changePhone(@PathVariable("id") Long id, @Valid @RequestParam String phone);

    @GetMapping(value = "/delete/{id}")
    void deleteUser(@PathVariable("id") Long id);

    @PostMapping("/update/user/{id}")
    void changeUser(@PathVariable("id") Long id, @RequestBody PersonalInformationRequest request);

}
