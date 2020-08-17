package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.FrontListTasks.ASSIGNMENT_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontListTasks.DESCRIPTION_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontListTasks.POINTS_TASK;
import static com.bookverse.certification.packapps.userinterfaces.FrontListTasks.TITLE_TASK;

import com.bookverse.certification.packapps.models.Task;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheTasksOnTheFront implements Question<Boolean> {

  public static TheTasksOnTheFront correspondToThoseOfTheService() {
    return new TheTasksOnTheFront();
  }

  @Subject("Compare results of frontend with service for tasks")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type tasksType = new TypeToken<List<Task>>() {
    }.getType();
    List<Task> resultTasksService = SerenityRest.lastResponse().body().as(tasksType);

    List<String> titles = Text.of(TITLE_TASK).viewedBy(actor).asList();
    List<String> assignments = Text.of(ASSIGNMENT_TASK).viewedBy(actor).asList();
    List<String> points = Text.of(POINTS_TASK).viewedBy(actor).asList();
    List<String> descriptions = Text.of(DESCRIPTION_TASK).viewedBy(actor).asList();

    for (int i = 0; i < resultTasksService.size(); i++) {
      String title = titles.get(i);
      String assignment = assignments.get(i);
      String point = points.get(i).replace(" points", "");
      String description = descriptions.get(i);

      if (!resultTasksService.get(i).getTitle().equals(title)
          || !resultTasksService.get(i).getAssignment().equals(assignment)
          || !resultTasksService.get(i).getPoints().equals(point)
          || !resultTasksService.get(i).getDescription().equals(description)) {
        return false;
      }
    }

    return true;
  }
}
