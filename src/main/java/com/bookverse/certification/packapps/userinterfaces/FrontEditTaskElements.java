package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FrontEditTaskElements {

  public static final Target ASSIGNMENT_TASK = Target.the("Assignment of task to edit on frontend")
      .locatedBy("//input[@id = 'assignment']");
  public static final Target TITLE_TASK = Target.the("Title of task to edit on frontend")
      .locatedBy("//input[@id = 'title']");
  public static final Target POINTS_TASK = Target.the("Points of task to edit on frontend")
      .locatedBy("//input[@id = 'points']");
  public static final Target DESCRIPTION_TASK = Target.the("Title of task to edit on frontend")
      .locatedBy("//input[@id = 'descriptionHidden']");
  public static final Target ID_TASK = Target.the("ID of task to edit on frontend")
      .locatedBy("//input[@id = 'id']");
  public static final Target DATE_TASK = Target.the("Date of task to edit on frontend")
      .locatedBy("//input[@id = 'dateHidden']");
}
