package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProfileElements {

  public static final Target USER_LOGGED = Target.the("update profile button")
      .locatedBy("//a[@id = 'userLogged']");
}
