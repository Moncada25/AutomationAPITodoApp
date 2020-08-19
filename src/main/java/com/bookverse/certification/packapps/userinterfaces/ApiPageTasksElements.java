package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:3000/api/tasks")
public class ApiPageTasksElements extends PageObject {

  public static final Target TASKS_IN_JSON_FORMAT = Target.the("tasks in json format")
      .locatedBy("//*/pre");
}
