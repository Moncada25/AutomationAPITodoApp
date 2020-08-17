package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:4200/tasks")
public class FrontListTasks extends PageObject {

  public static final Target TITLE_TASK = Target.the("Title list of tasks on frontend")
      .locatedBy("//div[contains(@class, 'card-header')]//a");
  public static final Target ASSIGNMENT_TASK = Target.the("Assignment list of tasks on frontend")
      .locatedBy("//div[contains(@class, 'card-body')]//h4");
  public static final Target POINTS_TASK = Target.the("Points list of tasks on frontend")
      .locatedBy("//div[contains(@class, 'card-body')]//h5[@id='points']");
  public static final Target DESCRIPTION_TASK = Target.the("Description list of tasks on frontend")
      .locatedBy("//div[contains(@class, 'card-body')]//h5[@id='description']");

}
