#Feature: Login scenarios include valid login and invalid login with combination of wrong credentials
#
#  @Magneto
#  Scenario Outline: Login valid user
#
#    Given I am logged in
#    Given I am logged in "<email>" AND "<password>"
#
#    Examples:
#      | email                |  password   |
#      | standard_user           |secret_sauce |