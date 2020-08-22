Feature: Login front
  I, as a user of the app
  I need to login with my credentials
  to verify correct operation

#  @LoginSuccessfully
#  Scenario Outline: Login with correct credentials
#    Given the user open page
#    When he enter your correct credentials <user> and <password>
#    Then he should see his profile
#
#    Examples:
#      | user     | password |
#      | smoncada | 1234     |
#      | root     | root     |

  @LoginFailed
  Scenario Outline: Login with incorrect credentials
    Given the user open page
    When he enter your correct credentials <user> and <password>
    Then he should see that the message The user is not registered

    Examples:
      | user    | password |
      | example | example  |
      | user    | password |
