package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FrontEditGameElements {

  public static final Target TITLE_GAME = Target.the("Title of game to edit on frontend")
      .locatedBy("//input[@id = 'title']");
  public static final Target DESCRIPTION_GAME = Target
      .the("Description of game to edit on frontend")
      .locatedBy("//input[@id = 'description']");
  public static final Target IMAGE_GAME = Target.the("Image of game to edit on frontend")
      .locatedBy("//input[@id = 'image']");
  public static final Target ID_GAME = Target.the("ID of game to edit on frontend")
      .locatedBy("//input[@id = 'idHidden']");
  public static final Target DATE_GAME = Target.the("Date of game to edit on frontend")
      .locatedBy("//input[@id = 'dateHidden']");
}
