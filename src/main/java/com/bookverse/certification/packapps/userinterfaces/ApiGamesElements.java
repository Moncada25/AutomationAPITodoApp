package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ApiGamesElements {

  public static final Target GAMES_IN_JSON_FORMAT = Target.the("games in json format")
      .locatedBy("//*/pre");

  private ApiGamesElements() {
  }
}