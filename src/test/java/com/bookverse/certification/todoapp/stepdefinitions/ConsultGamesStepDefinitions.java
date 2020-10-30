package com.bookverse.certification.todoapp.stepdefinitions;

import static com.bookverse.certification.todoapp.utils.Constants.GAMES_OF_FRONT_NOT_FOUND;
import static com.bookverse.certification.todoapp.utils.Constants.GAMES_OF_JSON_NOT_FOUND;
import static com.bookverse.certification.todoapp.utils.Constants.GAMES_SERVICE_NOT_RESPONSE;
import static com.bookverse.certification.todoapp.utils.Constants.GAMES_USER_URL;
import static com.bookverse.certification.todoapp.utils.Constants.ROUTE_GAMES;
import static com.bookverse.certification.todoapp.utils.Constants.USER;
import static com.bookverse.certification.todoapp.utils.RestService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.todoapp.exceptions.FrontendNotPaint;
import com.bookverse.certification.todoapp.exceptions.JsonNotFound;
import com.bookverse.certification.todoapp.exceptions.ServiceNotResponse;
import com.bookverse.certification.todoapp.questions.LastResponseStatusCode;
import com.bookverse.certification.todoapp.questions.TheGameEditOnTheFront;
import com.bookverse.certification.todoapp.questions.TheGamesOnTheFront;
import com.bookverse.certification.todoapp.questions.TheGamesOnTheJson;
import com.bookverse.certification.todoapp.tasks.GoTo;
import com.bookverse.certification.todoapp.tasks.RequestConsultGames;
import com.bookverse.certification.todoapp.tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ConsultGamesStepDefinitions {

  @Before
  public void prepareStage() {
    OnStage.setTheStage(new OnlineCast());
    theActorCalled(USER).whoCan(CallAnApi.at(BASE_URL.toString()));
  }

  @Given("^the user consults all games in the api by user (.*)$")
  public void theUserConsultsAllGamesInTheApiByUser(int idUser) {
    theActorInTheSpotlight().attemptsTo(RequestConsultGames.byUser(idUser));
  }

  @Given("^the user consults a game by id (.*)$")
  public void theUserConsultsAGameById(String id) {
    theActorInTheSpotlight().attemptsTo(
        RequestConsultGames.byId(id)
    );
  }

  @When("^he looks for the game in the front with id (.*) and credentials (.*) and (.*)$")
  public void heLooksForTheGameInTheFrontWithIdAndCredentials(String id, String user,
      String password) {
    theActorInTheSpotlight().attemptsTo(
        Search.elementById(user, password, id, true)
    );
  }

  @Then("^he should see that the frontend game are the same as the API$")
  public void heShouldSeeThatTheFrontendGameAreTheSameAsTheAPI() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, GAMES_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight()
        .should(seeThat(TheGameEditOnTheFront.correspondToTheOfTheService()).orComplainWith(
            FrontendNotPaint.class, GAMES_OF_FRONT_NOT_FOUND));
  }

  @When("^he gets the games from the json by user (.*)$")
  public void heGetsTheGamesFromTheJson(String id) {
    theActorInTheSpotlight().attemptsTo(
        Open.url(GAMES_USER_URL + id)
    );
  }

  @When("^he gets the games from the frontend with credentials (.*) and (.*)$")
  public void heGetTheGamesFromTheFrontendWithCredentials(String user, String password) {
    theActorInTheSpotlight().attemptsTo(GoTo.route(user, password, ROUTE_GAMES));
  }

  @Then("^he should see that the frontend games are the same as the API$")
  public void heShouldSeeThatTheFrontendGamesAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, GAMES_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight()
        .should(seeThat(TheGamesOnTheFront.correspondToThoseOfTheService()).orComplainWith(
            FrontendNotPaint.class, GAMES_OF_FRONT_NOT_FOUND));
  }

  @Then("^he should see that the json games are the same as the API$")
  public void heShouldSeeThatTheJsonGamesAreTheSameAsTheApi() {
    theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(200)).orComplainWith(
        ServiceNotResponse.class, GAMES_SERVICE_NOT_RESPONSE));
    theActorInTheSpotlight()
        .should(seeThat(TheGamesOnTheJson.correspondToThoseOfTheService()).orComplainWith(
            JsonNotFound.class, GAMES_OF_JSON_NOT_FOUND));
  }
}
