package com.dig.des.document.management.exception;

public class CantSaveUserException extends RuntimeException {

    public CantSaveUserException() {
        super();
    }

    public CantSaveUserException(String message) {
        super(message);
    }

    public CantSaveUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
