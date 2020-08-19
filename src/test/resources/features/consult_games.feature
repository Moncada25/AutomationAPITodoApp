Feature: Consult games
  I, as a consumer of the API
  I, want to consult the games to know their information

  @CompareGamesWithJSON
  Scenario: Consult games and compare with JSON
    Given the user consults all games in the api by user 1
    When he gets the games from the json by user 1
    Then he should see that the json games are the same as the API

  @CompareGamesWithFrontend
  Scenario: Consult games and compare with Frontend
    Given the user consults all games in the api by user 1
    When he gets the games from the frontend with credentials smoncada and 1234
    Then he should see that the frontend games are the same as the API

  @ConsultGameById
  Scenario: Consult a game by id
    Given the user consults a game by id 3
    When he looks for the game in the front with id 3 and credentials smoncada and 1234
    Then he should see that the frontend game are the same as the API