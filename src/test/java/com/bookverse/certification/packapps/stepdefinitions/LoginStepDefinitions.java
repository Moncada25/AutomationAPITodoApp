package com.bookverse.certification.packapps.stepdefinitions;

import static com.bookverse.certification.packapps.utils.Constants.MESSAGE_NOT_FOUND;
import static com.bookverse.certification.packapps.utils.Constants.USER_NOT_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bookverse.certification.packapps.exceptions.MessageNotFound;
import com.bookverse.certification.packapps.exceptions.UserNotFound;
import com.bookverse.certification.packapps.questions.TheMessageError;
import com.bookverse.certification.packapps.questions.TheUser;
import com.bookverse.certification.packapps.tasks.UserLogin;
import com.bookverse.certification.packapps.userinterfaces.LoginElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

public class LoginStepDefinitions {

  @Given("^the user open page$")
  public void theUserOpenPage() {
    theActorInTheSpotlight().attemptsTo(
        Open.browserOn(new LoginElements())
    );
  }

  @When("^he enter your correct credentials (.*) and (.*)$")
  public void heEnterYourCorrectCredentials(String user, String password) {
    theActorInTheSpotlight().attemptsTo(UserLogin.successfully(user, password));
  }

  @Then("^he should see his profile$")
  public void heShouldSeeHisProfile() {
    theActorInTheSpotlight().should(seeThat(TheUser.loggedIn()).orComplainWith(UserNotFound.class, USER_NOT_FOUND));
  }

  @Then("^he should see that (.*)$")
  public void heShouldSeeThatTheUserIsNotRegistered(String message) {
    theActorInTheSpotlight().should(seeThat(TheMessageError.is(message)).orComplainWith(
        MessageNotFound.class, MESSAGE_NOT_FOUND));
  }

}
