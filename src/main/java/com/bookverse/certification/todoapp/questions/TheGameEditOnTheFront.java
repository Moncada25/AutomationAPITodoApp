package com.bookverse.certification.todoapp.questions;

import static com.bookverse.certification.todoapp.userinterfaces.EditGameOnFrontElements.DATE_GAME;
import static com.bookverse.certification.todoapp.userinterfaces.EditGameOnFrontElements.DESCRIPTION_GAME;
import static com.bookverse.certification.todoapp.userinterfaces.EditGameOnFrontElements.ID_GAME;
import static com.bookverse.certification.todoapp.userinterfaces.EditGameOnFrontElements.IMAGE_GAME;
import static com.bookverse.certification.todoapp.userinterfaces.EditGameOnFrontElements.TITLE_GAME;
import static com.bookverse.certification.todoapp.utils.Constants.ATTRIBUTE_VALUE;

import com.bookverse.certification.todoapp.interactions.Logout;
import com.bookverse.certification.todoapp.models.Game;
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

    String id = ID_GAME.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String title = TITLE_GAME.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String description = DESCRIPTION_GAME.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String image = IMAGE_GAME.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String date = DATE_GAME.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);

    Game gameFromFront = new Game();
    gameFromFront.setId(id);
    gameFromFront.setTitle(title);
    gameFromFront.setDescription(description);
    gameFromFront.setImage(image);
    gameFromFront.setCreatedAt(date);

    actor.attemptsTo(Logout.fromApp());
    return gameFromFront.toString().equals(gameFromService.toString());
  }
}
