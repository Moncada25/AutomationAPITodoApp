package com.bookverse.certification.packapps.stepdefinitions;

import static com.bookverse.certification.packapps.utils.Constants.EDIT_TASK_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.packapps.questions.LastResponseStatusCode;
import com.bookverse.certification.packapps.questions.TheGameEditOnTheFront;
import com.bookverse.certification.packapps.questions.TheTaskEditOnTheFront;
import com.bookverse.certification.packapps.questions.TheTasksOnTheFront;
import com.bookverse.certification.packapps.questions.TheTasksOnTheJson;
import com.bookverse.certification.packapps.tasks.RequestConsultTasks;
import com.bookverse.certification.packapps.userinterfaces.ApiPageTasks;
import com.bookverse.certification.packapps.userinterfaces.FrontListTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

public class ConsultTasksStepDefinitions {

  @Given("^the user consults all tasks in the api$")
  public void theUserConsultsAllGamesInTheApi() {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultTasks.all()
    );
  }

  @Given("^the user consults a task by id (.*)$")
  public void theUserConsultsATaskById(String id) {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultTasks.byId(id)
    );
  }

  @When("^he looks for the task in the front with id (.*)$")
  public void heLooksForTheTaskInTheFrontWithId(String id) {
    theActorInTheSpotlight().attemptsTo(
        Open.url(EDIT_TASK_URL + id)
    );
  }

  @Then("^he should see that the frontend task are the same as the API$")
  public void heShouldSeeThatTheFrontendTaskAreTheSameAsTheAPI() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheTaskEditOnTheFront.correspondToTheOfTheService()));
  }

  @When("^he gets the tasks from the json$")
  public void heGetsTheTasksFromTheJson() {
    theActorInTheSpotlight().attemptsTo(
        Open.browserOn(new ApiPageTasks())
    );
  }

  @When("^he gets the tasks from the frontend$")
  public void heGetsTheTasksFromTheFrontend() {
    theActorInTheSpotlight().attemptsTo(
        Open.browserOn(new FrontListTasks())
    );
  }

  @Then("^he should see that the fronted tasks are the same as the API$")
  public void heShouldSeeThatTheFrontendTasksAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheTasksOnTheFront.correspondToThoseOfTheService()));
  }

  @Then("^he should see that the json tasks are the same as the API$")
  public void heShouldSeeThatTheJsonTasksAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheTasksOnTheJson.correspondToThoseOfTheService()));
  }
}
