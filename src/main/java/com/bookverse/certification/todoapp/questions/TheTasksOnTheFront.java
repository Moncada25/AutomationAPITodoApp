package com.bookverse.certification.todoapp.questions;

import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.DATE_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.EditTaskOnFrontElements.ID_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.ListTasksOnFrontElements.ASSIGNMENT_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.ListTasksOnFrontElements.DESCRIPTION_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.ListTasksOnFrontElements.POINTS_TASK;
import static com.bookverse.certification.todoapp.userinterfaces.ListTasksOnFrontElements.TITLE_TASK;
import static com.bookverse.certification.todoapp.utils.Constants.ATTRIBUTE_VALUE;

import com.bookverse.certification.todoapp.interactions.Logout;
import com.bookverse.certification.todoapp.models.Task;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheTasksOnTheFront implements Question<Boolean> {

  public static TheTasksOnTheFront correspondToThoseOfTheService() {
    return new TheTasksOnTheFront();
  }

  @Subject("compare results of frontend with service for tasks")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type tasksType = new TypeToken<List<Task>>() {
    }.getType();
    List<Task> resultTasksService = SerenityRest.lastResponse().body().as(tasksType);

    List<WebElementFacade> ids = ID_TASK.resolveAllFor(actor);
    List<String> titles = Text.of(TITLE_TASK).viewedBy(actor).asList();
    List<String> assignments = Text.of(ASSIGNMENT_TASK).viewedBy(actor).asList();
    List<String> points = Text.of(POINTS_TASK).viewedBy(actor).asList();
    List<String> descriptions = Text.of(DESCRIPTION_TASK).viewedBy(actor).asList();
    List<WebElementFacade> dates = DATE_TASK.resolveAllFor(actor);

    int index = 0;
    Task taskFromFront = new Task();

    for (Task task: resultTasksService) {

      taskFromFront.setId(ids.get(index).getAttribute(ATTRIBUTE_VALUE));
      taskFromFront.setTitle(titles.get(index));
      taskFromFront.setAssignment(assignments.get(index));
      taskFromFront.setPoints(points.get(index).replace(" points", ""));
      taskFromFront.setDescription(descriptions.get(index));
      taskFromFront.setCreatedAt(dates.get(index).getAttribute(ATTRIBUTE_VALUE));

      index++;

      if(!taskFromFront.toString().equals(task.toString())){
        return false;
      }
    }

    actor.attemptsTo(Logout.fromApp());
    return true;
  }

  private TheTasksOnTheFront() {
  }
}
