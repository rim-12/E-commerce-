package com.example.UsersServices.RegistrationValidatorClient;

import com.sun.net.httpserver.Authenticator;

public enum ValidationResult {
    SUCCESS("Success"),
    PHONE_NUMBER_NOT_VALID("Phone Number Not Valid"),
    FIRST_NAME_IS_NULL("First Name is Null"),
    LAST_NAME_IS_NULL("LastName is null"),
    GENRE_IS_NULL("Genre is null"),
    EMAIL_NOT_VALID("Email Not Valid"),
    PHONE_IS_NULL("phone Number Not Valid"),
    PASSWORD_IS_NULL("Password Not Valid"),
    STATUS_IS_NULL("status is null"),
    PHONE_IS_NOT_VALID("PHONE_IS_NOT_VALID"),
    TITLE_IS_NULL("Title is null"),
    INVALID_DUE_DATE("Invalide due date");
    private final String msg;
    ValidationResult(String msg) {this.msg = msg;}
    public String getMessage() {return this.msg;}
}
