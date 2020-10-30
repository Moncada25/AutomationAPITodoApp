package com.bookverse.certification.todoapp.questions;

import static com.bookverse.certification.todoapp.userinterfaces.LoginElements.MESSAGE_ALERT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheMessageError implements Question<Boolean> {

  private String message;

  public TheMessageError(String message) {
    this.message = message;
  }

  public static TheMessageError is(String message) {
    return new TheMessageError(message);
  }

  @Subject("validate message alert")
  @Override
  public Boolean answeredBy(Actor actor) {

    String messageFront = Text.of(MESSAGE_ALERT).viewedBy(actor).asString();
    return messageFront.trim().equals(message.trim());
  }
}
