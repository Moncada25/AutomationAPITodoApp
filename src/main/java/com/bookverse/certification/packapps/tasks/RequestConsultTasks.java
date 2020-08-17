package com.bookverse.certification.packapps.tasks;

import static com.bookverse.certification.packapps.utils.RestService.GET_TASKS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class RequestConsultTasks implements Task {

  private String idTask = null;

  public RequestConsultTasks(String idTask) {
    this.idTask = idTask;
  }

  public RequestConsultTasks() {

  }

  public static RequestConsultTasks byId(String idTask) {
    return Tasks.instrumented(RequestConsultTasks.class, idTask);
  }

  public static RequestConsultTasks all() {
    return Tasks.instrumented(RequestConsultTasks.class);
  }

  @Step("Consult API for tasks")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Check.whether(idTask != null).andIfSo(
            Get.resource(GET_TASKS.toString() + idTask)
        ).otherwise(Get.resource(GET_TASKS.toString())));
  }
}