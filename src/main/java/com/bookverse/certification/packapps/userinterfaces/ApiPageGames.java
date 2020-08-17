package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:3000/api/games")
public class ApiPageGames extends PageObject {

  public static final Target GAMES_IN_JSON_FORMAT = Target.the("games in json format")
      .locatedBy("//*/pre");
}
