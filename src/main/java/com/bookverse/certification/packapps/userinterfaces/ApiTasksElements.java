package com.bookverse.certification.packapps.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ApiTasksElements {

  public static final Target TASKS_IN_JSON_FORMAT = Target.the("tasks in json format")
      .locatedBy("//*/pre");

  private ApiTasksElements(){
  }
}
