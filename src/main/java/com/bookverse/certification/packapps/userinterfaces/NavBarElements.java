package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NavBarElements {

  public static final Target MENU_GAMES = Target.the("menu games from app")
      .locatedBy("//a[@id = 'navbarGames']");
  public static final Target MENU_LINK = Target.the("menu link of {0} from app")
      .locatedBy("//a[@href = '/{0}']");
  public static final Target MENU_ACCOUNT = Target.the("menu account from app")
      .locatedBy("//a[@id = 'navbarAccount']");
}
