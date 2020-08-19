package com.bookverse.certification.packapps.tasks;

import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_GAMES;
import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_LINK;

import com.bookverse.certification.packapps.userinterfaces.LoginElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task {

  private String route;
  private String user;
  private String password;

  public GoTo(String user, String password, String route) {
    this.user = user;
    this.password = password;
    this.route = route;
  }

  public static GoTo route(String user, String password, String route) {
    return Tasks.instrumented(GoTo.class, user, password, route);
  }

  @Step("{0} go to the #route")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Open.browserOn(new LoginElements()),
        UserLogin.successfully(user, password),
        Click.on(MENU_GAMES),
        Click.on(MENU_LINK.of(route))
    );
  }
}
