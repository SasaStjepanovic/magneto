Feature: Women scenarios include selecting tops & bottoms product directly and over hover option

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
#  Scenario Outline: Find WOMEN'S Hod&Sweat product for TOPS and select Category and sub category
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops or bottoms product
#    And user selects women category
#    And user selects women category sub item
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_002 |

  @Magneto
  Scenario Outline: Find WOMEN'S Jackets product for TOPS and select Category and sub category

    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
    And user enters menu item
    And user selects tops or bottoms product
    And user selects women category
    And user selects women category sub item
    Then user should verify next page title

    Examples:
      | TC_ID  |
      | SI_003 |

#  @Magneto
#  Scenario Outline: Find WOMEN'S Tees product for TOPS and select Category and sub category
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops or bottoms product
#    And user selects women category
#    And user selects women category sub item
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_004 |
#
#  @Magneto
#  Scenario Outline: Find WOMEN'S Bras^Tanks product for TOPS and select Category and sub category
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops or bottoms product
#    And user selects women category
#    And user selects women category sub item
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_005 |
#
#  @Magneto
#  Scenario Outline: Find all WOMEN'S products for BOTTOMS and select Category and sub category
#
#    Given a user reads test data from "magneto" "women" by id "<TC_ID>"
#    And user enters menu item
#    And user selects tops or bottoms product
#    And user selects women category
#    And user selects women category sub item
#    Then user should verify next page title
#
#    Examples:
#      | TC_ID  |
#      | SI_002 |





