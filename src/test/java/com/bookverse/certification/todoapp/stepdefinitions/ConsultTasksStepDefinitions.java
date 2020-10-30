package com.bookverse.certification.todoapp.stepdefinitions;

import static com.bookverse.certification.todoapp.utils.Constants.ROUTE_TASKS;
import static com.bookverse.certification.todoapp.utils.Constants.TASKS_OF_FRONT_NOT_FOUND;
import static com.bookverse.certification.todoapp.utils.Constants.TASKS_OF_JSON_NOT_FOUND;
import static com.bookverse.certification.todoapp.utils.Constants.TASKS_SERVICE_NOT_RESPONSE;
import static com.bookverse.certification.todoapp.utils.Constants.TASKS_USER_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.todoapp.exceptions.FrontendNotPaint;
import com.bookverse.certification.todoapp.exceptions.JsonNotFound;
import com.bookverse.certification.todoapp.exceptions.ServiceNotResponse;
import com.bookverse.certification.todoapp.questions.LastResponseStatusCode;
import com.bookverse.certification.todoapp.questions.TheTaskEditOnTheFront;
import com.bookverse.certification.todoapp.questions.TheTasksOnTheFront;
import com.bookverse.certification.todoapp.questions.TheTasksOnTheJson;
import com.bookverse.certification.todoapp.tasks.GoTo;
import com.bookverse.certification.todoapp.tasks.RequestConsultTasks;
import com.bookverse.certification.todoapp.tasks.Search;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

public class ConsultTasksStepDefinitions {

  @Given("^the user consults all tasks in the api by user (.*)$")
  public void theUserConsultsAllGamesInTheApiByUser(int idUser) {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultTasks.byUser(idUser)
    );
  }

  @Given("^the user consults a task by id (.*)$")
  public void theUserConsultsATaskById(String id) {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultTasks.byId(id)
    );
  }

  @When("^he looks for the task in the front with id (.*) and credentials (.*) and (.*)$")
  public void heLooksForTheTaskInTheFrontWithId(String id, String user, String password) {

    theActorInTheSpotlight().attemptsTo(
        Search.elementById(user, password, id, false)
    );
  }

  @Then("^he should see that the frontend task are the same as the API$")
  public void heShouldSeeThatTheFrontendTaskAreTheSameAsTheAPI() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, TASKS_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight().should(seeThat(TheTaskEditOnTheFront.correspondToTheOfTheService())
        .orComplainWith(FrontendNotPaint.class, TASKS_OF_FRONT_NOT_FOUND));
  }

  @When("^he gets the tasks from the json by user (.*)$")
  public void heGetsTheTasksFromTheJsonByUser(String id) {
    theActorInTheSpotlight().attemptsTo(
        Open.url(TASKS_USER_URL + id)
    );
  }

  @When("^he gets the tasks from the frontend with credentials (.*) and (.*)$")
  public void heGetsTheTasksFromTheFrontendWitCredentils(String user, String password) {
    theActorInTheSpotlight().attemptsTo(
        GoTo.route(user, password, ROUTE_TASKS)
    );
  }

  @Then("^he should see that the fronted tasks are the same as the API$")
  public void heShouldSeeThatTheFrontendTasksAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, TASKS_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight()
        .should(seeThat(TheTasksOnTheFront.correspondToThoseOfTheService()).orComplainWith(
            FrontendNotPaint.class, TASKS_OF_FRONT_NOT_FOUND));
  }

  @Then("^he should see that the json tasks are the same as the API$")
  public void heShouldSeeThatTheJsonTasksAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, TASKS_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight()
        .should(seeThat(TheTasksOnTheJson.correspondToThoseOfTheService()).orComplainWith(
            JsonNotFound.class, TASKS_OF_JSON_NOT_FOUND));
  }
}
