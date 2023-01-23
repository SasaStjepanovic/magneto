Feature: General scenarios include check web cart and enter/verify each of menu items

  @Magneto
  Scenario Outline: Check that shopping cart is initially empty

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    And user clicks shoping cart button
    Then user should verify that shopping cart is empty

    Examples:
      | TC_ID  |
      | SI_001 |

  @Magneto
  Scenario Outline: Enter each of menu items and verify them

    Given a user reads test data from "magneto" "login" by id "<TC_ID>"
    Then user click menu shoping items and verify them

    Examples:
      | TC_ID  |
      | SI_001 |

  @Magneto
  Scenario Outline: Check women TOPS-1 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_016 |

  @Magneto
  Scenario Outline: Check women TOPS-2 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_006 |

  @Magneto
  Scenario Outline: Check women TOPS-3 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_005 |

  @Magneto
  Scenario Outline: Check women TOPS-4 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_004 |

  @Magneto
  Scenario Outline: Check women BOTTOMS-1 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_011 |

  @Magneto
  Scenario Outline: Check women BOTTOMS-2 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_015 |

  @Magneto
  Scenario Outline: Check men TOPS-1 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_002 |

  @Magneto
  Scenario Outline: Check men TOPS-2 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_007 |

  @Magneto
  Scenario Outline: Check men TOPS-3 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_009 |

  @Magneto
  Scenario Outline: Check men TOPS-4 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_014 |

  @Magneto
  Scenario Outline: Check men BOTTOMS-1 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_012 |

  @Magneto
  Scenario Outline: Check men BOTTOMS-2 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_017 |

  @Magneto
  Scenario Outline: Check gear-1 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_003 |

  @Magneto
  Scenario Outline: Check gear-2 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_008 |

  @Magneto
  Scenario Outline: Check gear-3 products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_013 |

  @Magneto
  Scenario Outline: Check training products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands menu item over hover option
    And user expands menu sub item over hover option
    Then user should verify final page title

    Examples:
      | TC_ID  |
      | SI_010 |

