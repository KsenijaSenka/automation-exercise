Feature: Login functionality

  Background:
    Given User is on the login page

  @invalidLogin @regression @negative
  Scenario Outline: Login with invalid credentials
    When User enters email "<email>" and password "<password>"
    And clicks on login button
    Then Error message should be displayed

    Examples:
      | email              | password       |
      | test@example.com   | wrongpass123   |
      | user@test.com      | invalid456     |

  @validLogin @regression @positive
  Scenario: Login with environment-specific valid credentials
    When User logs in with valid credentials
    And clicks on login button
    Then User should be logged in successfully
