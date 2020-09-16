package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.ApiGamesElements.GAMES_IN_JSON_FORMAT;

import com.bookverse.certification.packapps.models.Game;
import com.bookverse.certification.packapps.utils.ConverterJson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheGamesOnTheJson implements Question<Boolean> {

  public static TheGamesOnTheJson correspondToThoseOfTheService() {
    return new TheGamesOnTheJson();
  }

  @Subject("Compare results of json with service for game")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type gamesType = new TypeToken<Collection<Game>>(){}.getType();

    Collection<Game> resultGamesWeb = ConverterJson
        .fromJson(GAMES_IN_JSON_FORMAT.resolveFor(actor).getText(), gamesType);
    Collection<Game> resultGamesService = SerenityRest.lastResponse().body().as(gamesType);

    return resultGamesWeb.toString().equals(resultGamesService.toString());
  }

  private TheGamesOnTheJson() {
  }
}
