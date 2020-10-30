package com.bookverse.certification.todoapp.exceptions;

public class MessageNotFound extends AssertionError{

  public MessageNotFound(String message, Throwable cause) {
    super(message, cause);
  }

}
