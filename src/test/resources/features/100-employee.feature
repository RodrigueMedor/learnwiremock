@postexample
Feature: Get Employee

  Background:

    Given an employee with the following attributes
      | matriculeId | firstname | lastname | dateOfBirth | startDate  | employmentType | email               | salaire |
      | 1           | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com | 12000   |
      | 2           | Rodrigue  | Medor    | 1984-01-01  | 2020-01-01 | Temporary      | rmedor.green@fs.com | 12300   |

    And with the following address
      | address_id | street          | city  | zip   | state | country | phone        |
      | 1          | 123 Main Street | 10001 | 32811 | OH    | USA     | 641-342-547  |
      | 2          | 124 Main Street | 10001 | 32812 | FL    | USA     | 771-342-4536 |

    When employee already exists


  Scenario: GET BY ID

    When user wants to get employee by id 2
    Then the get 'IS SUCCESSFUL'
    And following employee is returned
      | matriculeId | firstname | lastname | dateOfBirth | startDate  | employmentType | email               | salaire |
      | 200         | Rachel    | Green    | 1990-01-01  | 2018-01-01 | Permanent      | rachel.green@fs.com | 100000  |

    And following employee address are returned
      | address_id | street             | city     | zip   | state | country | phone        |
      | 1          | 123 Main Street    | Columbus | 32811 | OH    | USA     | 641-342-547  |
      | 2          | 124 Main Street    | Dallas   | 32812 | TX    | USA     | 771-342-4536 |
      | 3          | 4633 Cason Cove DR | Orlando  | 32810 | FL    | USA     | 771-342-4536 |
