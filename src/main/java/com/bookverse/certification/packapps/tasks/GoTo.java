package com.bookverse.certification.packapps.tasks;

import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_GAMES;
import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_LINK;
import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_TASKS;
import static com.bookverse.certification.packapps.utils.Constants.LOGIN_FRONT;
import static com.bookverse.certification.packapps.utils.Constants.ROUTE_GAMES;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
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

  @Step("{0} go to the route #route")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Open.url(LOGIN_FRONT),
        UserLogin.successfully(user, password),
        Check.whether(route.equals(ROUTE_GAMES)).
            andIfSo(Click.on(MENU_GAMES)).
            otherwise(Click.on(MENU_TASKS)),
        Click.on(MENU_LINK.of(route))
    );
  }
}
