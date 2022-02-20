package com.user.usermanagement.exception;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException(final String message) {
        super(message);
    }

}
