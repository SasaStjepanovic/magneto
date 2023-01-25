Feature: Create account scenarios including create account with random data and invalid scenarios when missed some of data

  @Magneto
  Scenario Outline: Create account with random values and then verify Account information

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that account is created

    Examples:
      | TC_ID  |
      | SI_002 |

  @Magneto
  Scenario Outline: Try to create account without entered first name

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_003 |

  @Magneto
  Scenario Outline: Try to create account without entered last name

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_004 |

  @Magneto
  Scenario Outline: Try to create account without entered email

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_005 |

  @Magneto
  Scenario Outline: Try to create account with invalid email

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_008 |

  @Magneto
  Scenario Outline: Try to create account without entered password

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_006 |

  @Magneto
  Scenario Outline: Try to create account without entered confirm password

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_007 |

  @Magneto
  Scenario Outline: Try to create account without entered password [No password]

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_009 |

  @Magneto
  Scenario Outline: Try to create account with entered password [Weak password]

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_010 |

  @Magneto
  Scenario Outline: Try to create account with entered password [Medium password]

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_011 |

  @Magneto
  Scenario Outline: Try to create account with entered password [Very Strong password]

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_012 |

  @Magneto
  Scenario Outline: Try to create account when entered passwords are not equal

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks create account button
    And user enters account credentials
    Then user should verify that field is an invalid

    Examples:
      | TC_ID  |
      | SI_013 |