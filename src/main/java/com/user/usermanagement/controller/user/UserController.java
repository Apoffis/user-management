package com.user.usermanagement.controller.user;

import com.user.usermanagement.controller.user.model.GetUserDetailResponse;
import com.user.usermanagement.controller.user.model.UserCreationRequest;
import com.user.usermanagement.controller.user.model.UserCreationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface UserController {

    @PostMapping("/")
    ResponseEntity<UserCreationResponse> create(@RequestBody UserCreationRequest request);

    @GetMapping(value = "/{id}")
    ResponseEntity<GetUserDetailResponse> get(@PathVariable("id") Long id);

}
