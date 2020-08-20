package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.FrontEditGameElements.DATE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditGameElements.ID_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontListGamesElements.DESCRIPTION_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontListGamesElements.IMAGE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontListGamesElements.TITLE_GAME;

import com.bookverse.certification.packapps.interactions.Logout;
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
import org.openqa.selenium.WebElement;

public class TheGamesOnTheFront implements Question<Boolean> {

  public static TheGamesOnTheFront correspondToThoseOfTheService() {
    return new TheGamesOnTheFront();
  }

  @Subject("compare results of frontend with service for games")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type gamesType = new TypeToken<List<Game>>() {
    }.getType();
    List<Game> resultGamesService = SerenityRest.lastResponse().body().as(gamesType);

    List<WebElementFacade> ids = ID_GAME.resolveAllFor(actor);
    List<String> titles = Text.of(TITLE_GAME).viewedBy(actor).asList();
    List<String> descriptions = Text.of(DESCRIPTION_GAME).viewedBy(actor).asList();
    List<WebElementFacade> images = IMAGE_GAME.resolveAllFor(actor);
    List<WebElementFacade> dates = DATE_GAME.resolveAllFor(actor);

    int index = 0;
    Game gameFromFront = new Game();

    for (Game game: resultGamesService) {

      gameFromFront.setId(ids.get(index).getAttribute("value"));
      gameFromFront.setTitle(titles.get(index));
      gameFromFront.setDescription(descriptions.get(index));
      gameFromFront.setImage(images.get(index).getAttribute("src"));
      gameFromFront.setCreated_at(dates.get(index).getAttribute("value"));

      index++;

      if(!gameFromFront.toString().equals(game.toString())){
        return false;
      }
    }

    actor.attemptsTo(Logout.fromApp());
    return true;
  }
}
