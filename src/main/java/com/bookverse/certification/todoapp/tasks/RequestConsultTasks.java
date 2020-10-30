package com.bookverse.certification.todoapp.tasks;

import static com.bookverse.certification.todoapp.utils.RestService.GET_TASKS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class RequestConsultTasks implements Task {

  private String idTask = null;
  private int idUser;

  public RequestConsultTasks(String idTask) {
    this.idTask = idTask;
  }

  public RequestConsultTasks(int idUser) {
    this.idUser = idUser;
  }

  public static RequestConsultTasks byId(String idTask) {
    return Tasks.instrumented(RequestConsultTasks.class, idTask);
  }

  public static RequestConsultTasks byUser(int idUser) {
    return Tasks.instrumented(RequestConsultTasks.class, idUser);
  }

  @Step("{0} consult API for tasks")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Check.whether(idTask != null).andIfSo(
            Get.resource(GET_TASKS.toString() + idTask)
        ).otherwise(Get.resource(GET_TASKS.toString() + "user/" + idUser)));
  }
}