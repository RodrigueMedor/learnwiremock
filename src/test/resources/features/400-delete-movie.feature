#Feature: Delete Movie
#
#  Background:
#
#    Given a movie with the following attributes
#      | movie_id | name        | year | cast                 | release_date |
#      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
#
##    And with the following phone numbers
##      | id  | type   | isdCode | phoneNumber | extension |
##      | 401 | Mobile | +1      | 2141112222  |           |
##      | 402 | Office | +1      | 8362223000  | 333       |
#
#    When movie already exists
#
#
#  Scenario: DELETE BY ID
#
#    When user wants to delete movie by id 10
#    Then the delete 'IS SUCCESSFUL'
