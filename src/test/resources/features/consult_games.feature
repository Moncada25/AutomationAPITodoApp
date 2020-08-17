Feature: Consult games
  I as a consumer of the API
  I want to consult the games to know their information

  @CompareGamesWithJSON
  Scenario: Consult all games and compare with JSON
    Given the user consults all games in the api
    When he gets the games from the json
    Then he should see that the json games are the same as the API

  @CompareGamesWithFrontend
  Scenario: Consult all games and compare with Frontend
    Given the user consults all games in the api
    When he gets the games from the frontend
    Then he should see that the frontend games are the same as the API

  @ConsultGameById
  Scenario: Consult a game by id
    Given the user consults a game by id 3
    When he looks for the game in the front with id 3
    Then he should see that the frontend game are the same as the API