package com.bookverse.certification.todoapp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NavBarElements {

  public static final Target MENU_GAMES = Target.the("menu games from app")
      .locatedBy("//a[@id = 'navbarGames']");
  public static final Target MENU_TASKS = Target.the("menu games from app")
      .locatedBy("//a[@id = 'navbarTasks']");
  public static final Target MENU_LINK = Target.the("menu link of {0} from app")
      .locatedBy("//a[@href = '/{0}']");
  public static final Target MENU_ACCOUNT = Target.the("menu account from app")
      .locatedBy("//a[@id = 'navbarAccount']");
  public static final Target USER_LOGGED = Target.the("update profile button")
      .locatedBy("//a[@id = 'userLogged']");

  private NavBarElements() {
  }
}