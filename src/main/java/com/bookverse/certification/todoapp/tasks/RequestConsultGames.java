package com.bookverse.certification.todoapp.tasks;

import static com.bookverse.certification.todoapp.utils.RestService.GET_GAMES;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class RequestConsultGames implements Task {

  private String idGame = null;
  private int idUser;

  public RequestConsultGames(String idGame) {
    this.idGame = idGame;
  }

  public RequestConsultGames(int idUser) {
    this.idUser = idUser;
  }

  public static RequestConsultGames byId(String idGame) {
    return Tasks.instrumented(RequestConsultGames.class, idGame);
  }

  public static RequestConsultGames byUser(int idUser) {
    return Tasks.instrumented(RequestConsultGames.class, idUser);
  }

  @Step("{0} consult API for games")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Check.whether(idGame != null).andIfSo(
            Get.resource(GET_GAMES.toString() + idGame)
        ).otherwise(Get.resource(GET_GAMES.toString() + "user/" + idUser)));
  }
}