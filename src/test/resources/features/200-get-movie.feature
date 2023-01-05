#Feature: Get Movie
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
##      | 201 | Mobile | +1      | 2141112222  |           |
##      | 202 | Office | +1      | 8362223000  | 333       |
#
#    When movie already exists
#
#
#  Scenario: GET BY ID
#
#    When user wants to get movie by id 11
#    Then the get 'IS SUCCESSFUL'
#    And following movie is returned
#      | movie_id | name        | year | cast                 | release_date |
#      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
#
##    And following employee phone numbers are returned
##      | id  | type   | isdCode | phoneNumber | extension |
##      | 201 | Mobile | +1      | 2141112222  |           |
##      | 202 | Office | +1      | 8362223000  | 333       |
