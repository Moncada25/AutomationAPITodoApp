package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ListGamesOnFrontElements {

  public static final Target TITLE_GAME = Target.the("title list of games on frontend")
      .locatedBy("//div[contains(@class, 'card-header')]//a");
  public static final Target DESCRIPTION_GAME = Target.the("description list of games on frontend")
      .locatedBy("//h6[@id = 'description']");
  public static final Target IMAGE_GAME = Target.the("image list of games on frontend")
      .locatedBy("//img[@class = 'card-img-top']");
}
