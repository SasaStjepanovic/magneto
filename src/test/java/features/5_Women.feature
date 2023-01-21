Feature: Women scenarios include selecting tops & bottoms product directly and over hover option
#
#  @Magneto
#  Scenario Outline: Enter Women menu item
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    Then user should be verify menu item page
#
#    Examples:
#      | TC_ID  |
#      | SI_001 |
#
#  @Magneto
#  Scenario Outline: Find Hod&Sweat product for TOPS
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops bottoms product
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_002 |
#
#  @Magneto
#  Scenario Outline: Find Jackets product for TOPS
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops bottoms product
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_003 |
#
#  @Magneto
#  Scenario Outline: Find Tees product for TOPS
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops bottoms product
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_004 |
#
#  @Magneto
#  Scenario Outline: Find Bras^Tanks product for TOPS
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops bottoms product
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_005 |
#
#  @Magneto
#  Scenario Outline: Find all products for BOTTOMS
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops bottoms product
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_006 |
#      | SI_007 |

  @Magneto
  Scenario Outline: Check women products over hover option

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user expands women menu item over hover option
    And user expands menu sub item over hover option

    Examples:
      | TC_ID  |
      | SI_001 |


