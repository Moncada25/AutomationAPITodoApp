Feature: Login front
  I, as a user of the app
  I need to login with my credentials
  to verify correct operation

  @LoginSuccessfully
  Scenario: Login with correct credentials
    Given the user open page
    When he enter your correct credentials smoncada and 1234
    Then he should see his profile