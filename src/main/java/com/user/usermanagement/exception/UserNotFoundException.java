package com.user.usermanagement.exception;

public class UserNotFoundException extends RuntimeException {

    private final Long id;

    public UserNotFoundException(final Long id) {
        super("User not found.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
