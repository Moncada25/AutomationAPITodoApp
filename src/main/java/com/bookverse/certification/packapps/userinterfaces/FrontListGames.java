package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:4200/games")
public class FrontListGames extends PageObject {

  public static final Target TITLE_GAME = Target.the("Title list of games on frontend")
      .locatedBy("//div[contains(@class, 'card-header')]//a");
  public static final Target DESCRIPTION_GAME = Target.the("Description list of games on frontend")
      .locatedBy("//div[contains(@class, 'card-body')]//p");
  public static final Target IMAGE_GAME = Target.the("Image list of games on frontend")
      .locatedBy("//img[@class = 'card-img-top']");
}
