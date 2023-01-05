#Feature: Update Movie
#
#  Background:
#
#    Given a movie with the following attributes
#      | movie_id | name        | year | cast                 | release_date |
#      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
#      | 12       | Joe         | 2022 | Rodrigue Medor       | 1919-03-01   |
#      | 14       | Zark        | 2021 | Sara Valentin        | 1919-03-01   |
#
##    And with the following phone numbers
##      | id  | type   | isdCode | phoneNumber | extension |
##      | 301 | Mobile | +1      | 2141112222  |           |
##      | 302 | Office | +1      | 8362223000  | 333       |
#
#    When movie already exists
#
#
#  Scenario Outline: <testCase> <expectedResult>
#
#    Given user wants to update an employee with the following attributes
#      | movie_id   | name   | year   | cast   | release_date   |
#      | <movie_id> | <name> | <year> | <cast> | <release_date> |
#
##    And with the following phone numbers
##      | id  | type   | isdCode | phoneNumber | extension |
##      | 301 | Mobile | +1      | 2141112222  |           |
##      | 302 | Office | +1      | 8362223000  | 333       |
#
#    When user saves the employee '<testCase>'
#    Then the save '<expectedResult>'
#
#    Examples:
#      | testCase                 | expectedResult | movie_id | name        | year | cast                 |
#      | WITHOUT ID               | FAILS          |          | Toy Story 4 | 2019 | Tom Hanks, Tim Allen |
#      | WITHOUT name             | FAILS          | 12       |             | 2022 | Rodrigue Medor       |
#      | WITHOUT year             | FAILS          | 14       | Zark        |      | Sara Valentin        |
#      | WITHOUT cast             | FAILS          | 15       | Toy Story 4 | 2019 |                      |
#      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | 16       | Joe         | 2022 | Rodrigue Medor       |
#      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | 17       | Zark        | 2021 | Sara Valentin        |
#
#
#
