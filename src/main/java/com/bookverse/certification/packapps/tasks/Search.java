package com.bookverse.certification.packapps.tasks;

import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_GAMES;
import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_LINK;
import static com.bookverse.certification.packapps.utils.Constants.EDIT_GAME_URL;

import com.bookverse.certification.packapps.userinterfaces.LoginElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Search implements Task {

  private String user;
  private String password;
  private String id;

  public Search(String user, String password, String id) {
    this.user = user;
    this.password = password;
    this.id = id;
  }

  public static Search taskById(String user, String password, String id) {
    return Tasks.instrumented(Search.class, user, password, id);
  }

  @Step("{0} search element by id")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Open.browserOn(new LoginElements()),
        UserLogin.successfully(user, password)
    );

    BrowseTheWeb.as(actor).getDriver().navigate().to(EDIT_GAME_URL + id);
  }
}
