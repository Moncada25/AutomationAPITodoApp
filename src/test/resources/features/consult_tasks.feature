Feature: Consult tasks
  I, as a consumer of the API
  I, want to consult the tasks to know their information

  @CompareTasksWithJSON
  Scenario Outline: Consult tasks and compare with JSON
    Given the user consults all tasks in the api by user <idUser>
    When he gets the tasks from the json by user <idUser>
    Then he should see that the json tasks are the same as the API

    Examples:
      | idUser |
      | 1      |

  @CompareTasksWithFrontend
  Scenario Outline: Consult tasks and compare with Frontend
    Given the user consults all tasks in the api by user <idUser>
    When he gets the tasks from the frontend with credentials <user> and <password>
    Then he should see that the fronted tasks are the same as the API

    Examples:
      | idUser | user     | password |
      | 1      | smoncada | 1234     |

  @ConsultTaskById
  Scenario Outline: Consult a task by id
    Given the user consults a task by id <idTask>
    When he looks for the task in the front with id <idTask> and credentials <user> and <password>
    Then he should see that the frontend task are the same as the API

    Examples:
      | idTask | user     | password |
      | 7      | smoncada | 1234     |