package com.dig.des.document.management.exception;

public class NoSuchUsernameException extends RuntimeException {

    public NoSuchUsernameException() {
        super();
    }

    public NoSuchUsernameException(String message) {
        super(message);
    }

    public NoSuchUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
