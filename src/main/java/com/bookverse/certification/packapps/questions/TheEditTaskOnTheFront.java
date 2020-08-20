package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.ASSIGNMENT_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.DATE_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.DESCRIPTION_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.ID_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.POINTS_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditTaskElements.TITLE_TASK;

import com.bookverse.certification.packapps.models.Task;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheEditTaskOnTheFront implements Question<Boolean> {

  public static TheEditTaskOnTheFront correspondToTheOfTheService() {
    return new TheEditTaskOnTheFront();
  }

  @Subject("Compare results of frontend with service for task to edit")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type taskType = new TypeToken<Task>() {
    }.getType();
    Task taskFromService = SerenityRest.lastResponse().body().as(taskType);

    String id = ID_TASK.resolveFor(actor).getAttribute("value");
    String assignment = ASSIGNMENT_TASK.resolveFor(actor).getAttribute("value");
    String title = TITLE_TASK.resolveFor(actor).getAttribute("value");
    String points = POINTS_TASK.resolveFor(actor).getAttribute("value");
    String description = DESCRIPTION_TASK.resolveFor(actor).getAttribute("value");
    String date = DATE_TASK.resolveFor(actor).getAttribute("value");

    Task taskFromFront = new Task();
    taskFromFront.setId(id);
    taskFromFront.setAssignment(assignment);
    taskFromFront.setTitle(title);
    taskFromFront.setPoints(points);
    taskFromFront.setDescription(description);
    taskFromFront.setCreated_at(date);

    return taskFromFront.toString().equals(taskFromService.toString());
  }
}
