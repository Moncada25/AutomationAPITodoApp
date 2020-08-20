package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.ASSIGNMENT_TASK;
import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.DATE_TASK;
import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.DESCRIPTION_TASK;
import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.ID_TASK;
import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.POINTS_TASK;
import static com.bookverse.certification.packapps.userinterfaces.EditTaskOnFrontElements.TITLE_TASK;

import com.bookverse.certification.packapps.interactions.Logout;
import com.bookverse.certification.packapps.models.Task;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheTaskEditOnTheFront implements Question<Boolean> {

  public static TheTaskEditOnTheFront correspondToTheOfTheService() {
    return new TheTaskEditOnTheFront();
  }

  @Subject("compare results of frontend with service for task to edit")
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

    actor.attemptsTo(Logout.fromApp());
    return taskFromFront.toString().equals(taskFromService.toString());
  }
}
