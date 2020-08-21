package com.bookverse.certification.packapps.exceptions;

public class UserNotFound extends AssertionError {

  public UserNotFound(String message, Throwable cause) {
    super(message, cause);
  }

}
