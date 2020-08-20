package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.USER_LOGGED;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheUser implements Question<Boolean> {

  public static TheUser loggedIn() {
    return new TheUser();
  }

  @Subject("validate that user logged in successfully")
  @Override
  public Boolean answeredBy(Actor actor) {

    String userFront = Text.of(USER_LOGGED).viewedBy(actor).asString();
    String userLogged = actor.recall("USER_LOGGED");

    return userFront.equals(userLogged);
  }
}
