package com.bookverse.certification.todoapp.questions;

import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.ASSIGNMENT_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.DATE_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.DESCRIPTION_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.ID_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.POINTS_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.TITLE_TASK;
import static com.bookverse.certification.todoapp.utils.Constants.ATTRIBUTE_VALUE;

import com.bookverse.certification.todoapp.interactions.Logout;
import com.bookverse.certification.todoapp.models.Task;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class TheTaskEditOnTheFront implements Question<Boolean> {

  private TheTaskEditOnTheFront() {
  }

  public static TheTaskEditOnTheFront correspondToTheOfTheService() {
    return new TheTaskEditOnTheFront();
  }

  @Subject("compare results of frontend with service for task to edit")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type taskType = new TypeToken<Task>() {
    }.getType();
    Task taskFromService = SerenityRest.lastResponse().body().as(taskType);

    String id = ID_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String assignment = ASSIGNMENT_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String title = TITLE_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String points = POINTS_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String description = DESCRIPTION_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);
    String date = DATE_TASK.resolveFor(actor).getAttribute(ATTRIBUTE_VALUE);

    Task taskFromFront = new Task();
    taskFromFront.setId(id);
    taskFromFront.setAssignment(assignment);
    taskFromFront.setTitle(title);
    taskFromFront.setPoints(points);
    taskFromFront.setDescription(description);
    taskFromFront.setCreatedAt(date);

    actor.attemptsTo(Logout.fromApp());
    return taskFromFront.toString().equals(taskFromService.toString());
  }
}
