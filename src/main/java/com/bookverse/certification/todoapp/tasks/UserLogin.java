package com.bookverse.certification.todoapp.tasks;

import static com.bookverse.certification.todoapp.userinterfaces.LoginElements.LOGIN_BUTTON;
import static com.bookverse.certification.todoapp.userinterfaces.LoginElements.PASSWOORD_INPUT;
import static com.bookverse.certification.todoapp.userinterfaces.LoginElements.USERNAME_INPUT;

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

  @Step("{0} login to app")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Enter.theValue(user).into(USERNAME_INPUT),
        Enter.theValue(password).into(PASSWOORD_INPUT),
        Click.on(LOGIN_BUTTON)
    );

    actor.remember("USER_LOGGED", user);
  }
}
