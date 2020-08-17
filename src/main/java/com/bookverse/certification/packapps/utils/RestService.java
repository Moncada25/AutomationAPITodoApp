package com.bookverse.certification.packapps.utils;

public enum RestService {

  BASE_URL("http://localhost:3000/api"),
  GET_TASKS("/tasks/"),
  GET_GAMES("/games/");

  private String api;

  RestService(String api) {
    this.api = api;
  }

  @Override
  public String toString() {
    return api;
  }
}
