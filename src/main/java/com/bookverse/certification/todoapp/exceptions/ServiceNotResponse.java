package com.bookverse.certification.todoapp.exceptions;

public class ServiceNotResponse extends AssertionError {

  public ServiceNotResponse(String message, Throwable cause) {
    super(message, cause);
  }
}
