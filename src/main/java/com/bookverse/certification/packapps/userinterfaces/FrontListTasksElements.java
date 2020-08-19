package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:4200/tasks")
public class FrontListTasksElements extends PageObject {

  public static final Target TITLE_TASK = Target.the("title list of tasks on frontend")
      .locatedBy("//div[contains(@class, 'card-header')]//a");
  public static final Target ASSIGNMENT_TASK = Target.the("assignment list of tasks on frontend")
      .locatedBy("//h3[@id = 'assignment']");
  public static final Target POINTS_TASK = Target.the("points list of tasks on frontend")
      .locatedBy("//h5[@id='points']");
  public static final Target DESCRIPTION_TASK = Target.the("description list of tasks on frontend")
      .locatedBy("//h5[@id='description']");

}
