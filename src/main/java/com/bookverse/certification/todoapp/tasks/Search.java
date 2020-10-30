package com.bookverse.certification.todoapp.tasks;

import static com.bookverse.certification.todoapp.utils.Constants.EDIT_GAME_URL;
import static com.bookverse.certification.todoapp.utils.Constants.EDIT_TASK_URL;
import static com.bookverse.certification.todoapp.utils.Constants.LOGIN_FRONT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Search implements Task {

  private String user;
  private String password;
  private String id;
  private boolean isGame;

  public Search(String user, String password, String id, boolean isGame) {
    this.user = user;
    this.password = password;
    this.id = id;
    this.isGame = isGame;
  }

  public static Search elementById(String user, String password, String id, boolean isGame) {
    return Tasks.instrumented(Search.class, user, password, id, isGame);
  }

  @Step("{0} search element by id #id")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Open.url(LOGIN_FRONT),
        UserLogin.successfully(user, password)
    );

    if (isGame) {
      BrowseTheWeb.as(actor).getDriver().navigate().to(EDIT_GAME_URL + id);
    } else {
      BrowseTheWeb.as(actor).getDriver().navigate().to(EDIT_TASK_URL + id);
    }
  }
}
