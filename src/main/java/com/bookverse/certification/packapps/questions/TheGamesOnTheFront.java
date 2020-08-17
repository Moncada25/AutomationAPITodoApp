package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.FrontListGames.DESCRIPTION_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontListGames.IMAGE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontListGames.TITLE_GAME;

import com.bookverse.certification.packapps.models.Game;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheGamesOnTheFront implements Question<Boolean> {

  public static TheGamesOnTheFront correspondToThoseOfTheService() {
    return new TheGamesOnTheFront();
  }

  @Subject("Compare results of frontend with service for games")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type gamesType = new TypeToken<List<Game>>() {
    }.getType();
    List<Game> resultGamesService = SerenityRest.lastResponse().body().as(gamesType);

    List<String> titles = Text.of(TITLE_GAME).viewedBy(actor).asList();
    List<String> descriptions = Text.of(DESCRIPTION_GAME).viewedBy(actor).asList();
    List<WebElementFacade> images = IMAGE_GAME.resolveAllFor(actor);

    for (int i = 0; i < resultGamesService.size(); i++) {

      String title = titles.get(i);
      String description = descriptions.get(i);
      String image = images.get(i).getAttribute("src");

      if (!resultGamesService.get(i).getTitle().equals(title)
          || !resultGamesService.get(i).getDescription().equals(description)
          || !resultGamesService.get(i).getImage().equals(image)) {
        return false;
      }
    }

    return true;
  }
}
