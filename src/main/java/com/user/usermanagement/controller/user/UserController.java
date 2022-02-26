package com.user.usermanagement.controller.user;

import com.user.usermanagement.controller.user.model.GetUserDetailResponse;
import com.user.usermanagement.controller.user.model.UserCreationRequest;
import com.user.usermanagement.controller.user.model.UserCreationResponse;
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

    @GetMapping(value = "/all")
    List<GetUserDetailResponse> getAll();

    @GetMapping(value = "/details/{identity}")
    ResponseEntity<GetUserDetailResponse> getDetails(@PathVariable("identity") String identity);

    @PostMapping("/")
    ResponseEntity<UserCreationResponse> create(@Valid @RequestBody UserCreationRequest request);
}
