package com.bookverse.certification.todoapp.exceptions;

public class UserNotFound extends AssertionError {

  public UserNotFound(String message, Throwable cause) {
    super(message, cause);
  }

}
