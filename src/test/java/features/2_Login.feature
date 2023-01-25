Feature: Login scenarios include valid login and invalid login with combination of wrong credentials

  @Magneto
  Scenario Outline: Login valid user

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks sign in button
    And user enters account credentials for login
    Then user should verify that login is successfully

    Examples:
      | TC_ID  |
      | SI_001 |

  @Magneto
  Scenario Outline: Try to login without email

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks sign in button
    And user enters account credentials for login
    Then user should verify that login field is an invalid

    Examples:
      | TC_ID  |
      | SI_002 |

  @Magneto
  Scenario Outline: Try to login without password

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks sign in button
    And user enters account credentials for login
    Then user should verify that login field is an invalid

    Examples:
      | TC_ID  |
      | SI_006 |

  @Magneto
  Scenario Outline: Try to login with valid email and invalid password

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks sign in button
    And user enters account credentials for login
    Then user should verify that login field is an invalid

    Examples:
      | TC_ID  |
      | SI_014 |