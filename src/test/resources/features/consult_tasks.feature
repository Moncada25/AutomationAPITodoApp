Feature: Consult tasks
  I, as a consumer of the API
  I, want to consult the tasks to know their information

  @CompareTasksWithJSON
  Scenario: Consult tasks and compare with JSON
    Given the user consults all tasks in the api by user 1
    When he gets the tasks from the json by user 1
    Then he should see that the json tasks are the same as the API

  @CompareTasksWithFrontend
  Scenario: Consult tasks and compare with Frontend
    Given the user consults all tasks in the api by user 1
    When he gets the tasks from the frontend with credentials smoncada and 1234
    Then he should see that the fronted tasks are the same as the API

  @ConsultTaskById
  Scenario: Consult a task by id
    Given the user consults a task by id 7
    When he looks for the task in the front with id 7 and credentials smoncada and 1234
    Then he should see that the frontend task are the same as the API
