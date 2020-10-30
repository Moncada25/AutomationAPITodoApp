package com.bookverse.certification.todoapp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginElements {

  public static final Target USERNAME_INPUT = Target.the("username input from login")
      .locatedBy("//input[@id = 'username']");
  public static final Target PASSWOORD_INPUT = Target.the("password input from login")
      .locatedBy("//input[@id = 'password']");
  public static final Target LOGIN_BUTTON = Target.the("login button")
      .locatedBy("//button[@id = 'btnLogin']");
  public static final Target MESSAGE_ALERT = Target.the("message alert")
      .locatedBy("//div[@id = 'swal2-content']");

  private LoginElements() {
  }
}