package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.EditGameOnFrontElements.DATE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.EditGameOnFrontElements.DESCRIPTION_GAME;
import static com.bookverse.certification.packapps.userinterfaces.EditGameOnFrontElements.ID_GAME;
import static com.bookverse.certification.packapps.userinterfaces.EditGameOnFrontElements.IMAGE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.EditGameOnFrontElements.TITLE_GAME;

import com.bookverse.certification.packapps.interactions.Logout;
import com.bookverse.certification.packapps.models.Game;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheGameEditOnTheFront implements Question<Boolean> {

  public static TheGameEditOnTheFront correspondToTheOfTheService() {
    return new TheGameEditOnTheFront();
  }

  @Subject("compare results of frontend with service for game to edit")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type gameType = new TypeToken<Game>() {
    }.getType();
    Game gameFromService = SerenityRest.lastResponse().body().as(gameType);

    String id = ID_GAME.resolveFor(actor).getAttribute("value");
    String title = TITLE_GAME.resolveFor(actor).getAttribute("value");
    String description = DESCRIPTION_GAME.resolveFor(actor).getAttribute("value");
    String image = IMAGE_GAME.resolveFor(actor).getAttribute("value");
    String date = DATE_GAME.resolveFor(actor).getAttribute("value");

    Game gameFromFront = new Game();
    gameFromFront.setId(id);
    gameFromFront.setTitle(title);
    gameFromFront.setDescription(description);
    gameFromFront.setImage(image);
    gameFromFront.setCreated_at(date);

    actor.attemptsTo(Logout.fromApp());
    return gameFromFront.toString().equals(gameFromService.toString());
  }
}
