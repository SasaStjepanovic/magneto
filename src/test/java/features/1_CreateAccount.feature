Feature: Create account scenarios including create account with random data and invalid scenarios when missed some of data

  @Magneto
  Scenario Outline: Create Account with random values and then verify Account information

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that account is created

    Examples:
      | TC_ID  |
      | SI_002 |