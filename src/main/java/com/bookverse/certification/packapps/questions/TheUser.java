package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.ProfileElements.UPDATE_PROFILE_BUTTON;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheUser implements Question<Boolean> {

  public static TheUser loggedIn() {
    return new TheUser();
  }

  @Subject("validate that user logged in successfully")
  @Override
  public Boolean answeredBy(Actor actor) {
    return UPDATE_PROFILE_BUTTON.resolveFor(actor).isVisible();
  }
}
