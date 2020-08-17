package com.bookverse.certification.packapps.stepdefinitions;

import static com.bookverse.certification.packapps.utils.Constants.*;
import static com.bookverse.certification.packapps.utils.RestService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.packapps.questions.LastResponseStatusCode;
import com.bookverse.certification.packapps.questions.TheGameEditOnTheFront;
import com.bookverse.certification.packapps.questions.TheGamesOnTheFront;
import com.bookverse.certification.packapps.questions.TheGamesOnTheJson;
import com.bookverse.certification.packapps.tasks.RequestConsultGames;
import com.bookverse.certification.packapps.userinterfaces.ApiPageGames;
import com.bookverse.certification.packapps.userinterfaces.FrontListGames;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ConsultGamesStepDefinitions {

  private static final String USER = "Santiago";

  @Before
  public void prepareStage() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled(USER).whoCan(CallAnApi.at(BASE_URL.toString()));
  }

  @Given("^the user consults all games in the api$")
  public void theUserConsultsAllGamesInTheApi() {
    theActorInTheSpotlight().attemptsTo(RequestConsultGames.all());
  }

  @Given("^the user consults a game by id (.*)$")
  public void theUserConsultsAGameById(String id) {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultGames.byId(id)
    );
  }

  @When("^he looks for the game in the front with id (.*)$")
  public void heLooksForTheGameInTheFront(String id) {
    theActorInTheSpotlight().attemptsTo(
      Open.url(EDIT_GAME_URL + id)
    );
  }

  @Then("^he should see that the frontend game are the same as the API$")
  public void heShouldSeeThatTheFrontendGameAreTheSameAsTheAPI() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheGameEditOnTheFront.correspondToTheOfTheService()));
  }

  @When("^he gets the games from the json$")
  public void heGetsTheGamesFromTheJson() {
    theActorInTheSpotlight().attemptsTo(
        Open.browserOn(new ApiPageGames())
    );
  }

  @When("^he gets the games from the frontend$")
  public void heGetTheGamesFromTheFrontend() {
    theActorInTheSpotlight().attemptsTo(
        Open.browserOn(new FrontListGames())
    );
  }

  @Then("^he should see that the frontend games are the same as the API$")
  public void heShouldSeeThatTheFrontendGamesAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheGamesOnTheFront.correspondToThoseOfTheService()));
  }

  @Then("^he should see that the json games are the same as the API$")
  public void heShouldSeeThatTheJsonGamesAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)));
    theActorInTheSpotlight().should(seeThat(TheGamesOnTheJson.correspondToThoseOfTheService()));
  }
}
