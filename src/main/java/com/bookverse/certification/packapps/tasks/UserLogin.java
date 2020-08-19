package com.bookverse.certification.packapps.tasks;

import static com.bookverse.certification.packapps.userinterfaces.LoginElements.LOGIN_BUTTON;
import static com.bookverse.certification.packapps.userinterfaces.LoginElements.PASSWOORD_INPUT;
import static com.bookverse.certification.packapps.userinterfaces.LoginElements.USERNAME_INPUT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class UserLogin implements Task {

  private String user;
  private String password;

  public UserLogin(String user, String password) {
    this.user = user;
    this.password = password;
  }

  public static UserLogin successfully(String user, String password) {
    return Tasks.instrumented(UserLogin.class, user, password);
  }

  @Step("{0} enter your credentials")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Enter.theValue(user).into(USERNAME_INPUT),
        Enter.theValue(password).into(PASSWOORD_INPUT),
        Click.on(LOGIN_BUTTON)
    );
  }
}
