Feature: Create account scenarios including create account

  @Magneto
  Scenario Outline: Create Account

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button

    Examples:
      | TC_ID  |
      | SI_001 |