package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProfileElements {

  public static final Target UPDATE_PROFILE_BUTTON = Target.the("update profile button")
      .locatedBy("//button[@id = 'toggleUpdate']");
}
