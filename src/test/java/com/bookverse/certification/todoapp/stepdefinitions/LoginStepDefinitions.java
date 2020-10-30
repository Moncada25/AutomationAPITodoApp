package com.bookverse.certification.todoapp.stepdefinitions;

import static com.bookverse.certification.todoapp.utils.Constants.LOGIN_FRONT;
import static com.bookverse.certification.todoapp.utils.Constants.MESSAGE_NOT_FOUND;
import static com.bookverse.certification.todoapp.utils.Constants.USER_NOT_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.todoapp.exceptions.MessageNotFound;
import com.bookverse.certification.todoapp.exceptions.UserNotFound;
import com.bookverse.certification.todoapp.questions.TheMessageError;
import com.bookverse.certification.todoapp.questions.TheUser;
import com.bookverse.certification.todoapp.tasks.UserLogin;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

public class LoginStepDefinitions {

  @Given("^the user open page$")
  public void theUserOpenPage() {
    theActorInTheSpotlight().attemptsTo(
        Open.url(LOGIN_FRONT)
    );
  }

  @When("^he enter your correct credentials (.*) and (.*)$")
  public void heEnterYourCorrectCredentials(String user, String password) {
    theActorInTheSpotlight().attemptsTo(UserLogin.successfully(user, password));
  }

  @Then("^he should see his profile$")
  public void heShouldSeeHisProfile() {
    theActorInTheSpotlight()
        .should(seeThat(TheUser.loggedIn()).orComplainWith(UserNotFound.class, USER_NOT_FOUND));
  }

  @Then("^he should see that the message(.*)$")
  public void heShouldSeeThatTheMessage(String message) {
    theActorInTheSpotlight().should(seeThat(TheMessageError.is(message)).orComplainWith(
        MessageNotFound.class, MESSAGE_NOT_FOUND));
  }

}
