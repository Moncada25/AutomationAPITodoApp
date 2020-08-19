package com.bookverse.certification.packapps.interactions;

import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_ACCOUNT;
import static com.bookverse.certification.packapps.userinterfaces.NavBarElements.MENU_LINK;
import static com.bookverse.certification.packapps.utils.Constants.ROUTE_LOGOUT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Logout implements Interaction {

  public static Logout fromApp() {
    return Tasks.instrumented(Logout.class);
  }

  @Step("{0} logout from app")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(MENU_ACCOUNT),
        Click.on(MENU_LINK.of(ROUTE_LOGOUT))
    );
  }
}
