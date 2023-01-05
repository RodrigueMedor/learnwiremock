@getexample
Feature: Get movie details

  Scenario: calls all movies from web service
    Given A list of movies are available
    When we add a movie to the list
      | movie_id | name        | year | cast                 | release_date |
      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
      | 12       | Joe         | 2022 | Rodrigue Medor       | 1919-03-01   |
      | 14       | Zark        | 2021 | Sara Valentin        | 1919-03-01   |
    Given the following movie exist
      | movie_id | name        | year | cast                 | release_date |
      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
      | 12       | Joe         | 2022 | Rodrigue Medor       | 1919-03-01   |
      | 14       | Zark        | 2021 | Sara Valentin        | 1919-03-01   |
    Then the movie is added
    When the movie "Toy Story 4" remove from the list
    Then the movie is removed

  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL
    Given user wants to create and list a movie with the following attributes
      | movie_id | name        | year | cast                 | release_date |
      | 11       | Toy Story 4 | 2019 | Tom Hanks, Tim Allen | 1919-03-01   |
    When user saves the new movie1 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'


  Scenario Outline: <testCase> <expectedResult>

    Given user wants to create a movie with the following attributes
      | movie_id | name   | year   | cast   | release_date   |
      | 12       | <name> | <year> | <cast> | <release_date> |

    When user saves the new movie '<testCase>'
    Then the save '<expectedResult>'

    Examples:
      | testCase                 | expectedResult | name        | year | cast                   | release_date |
      | WITHOUT ID               | FAILS          | Toy Story 4 | 2019 | Tom Hanks, Tim Allen   | 2005-06-15   |
      | WITHOUT name             | FAILS          |             | 2022 | Rodrigue Medor         | 2005-06-16   |
      | WITHOUT year             | FAILS          | Zark        |      | Sara Valentin          | 2005-06-18   |
      | WITHOUT cast             | FAILS          | Toy Story 4 | 2019 |                        | 2005-06-20   |
      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | Joe         | 2022 | Rodrigue Medor         | 2005-06-28   |
      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | Zark        | 2021 | Sara Valentin Kayleigh | 2005-07-15   |

