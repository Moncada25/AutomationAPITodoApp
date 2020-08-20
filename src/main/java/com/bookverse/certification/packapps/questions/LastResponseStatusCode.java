package com.bookverse.certification.packapps.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class LastResponseStatusCode {

  @Subject("verify last response status code is 200")
  public static Question<Boolean> is(int code) {
    return a -> SerenityRest.lastResponse().statusCode() == code;
  }
}
