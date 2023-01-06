$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/100-employee.feature");
formatter.feature({
  "line": 2,
  "name": "Get Employee",
  "description": "",
  "id": "get-employee",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@postexample"
    }
  ]
});
formatter.before({
  "duration": 420089300,
  "status": "passed"
});
formatter.before({
  "duration": 6939899,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "an employee with the following attributes",
  "rows": [
    {
      "cells": [
        "matriculeId",
        "firstname",
        "lastname",
        "dateOfBirth",
        "startDate",
        "employmentType",
        "email",
        "salaire"
      ],
      "line": 7
    },
    {
      "cells": [
        "1",
        "Rachel",
        "Green",
        "1990-01-01",
        "2018-01-01",
        "Permanent",
        "rachel.green@fs.com",
        "12000"
      ],
      "line": 8
    },
    {
      "cells": [
        "2",
        "Rodrigue",
        "Medor",
        "1984-01-01",
        "2020-01-01",
        "Temporary",
        "rmedor.green@fs.com",
        "12300"
      ],
      "line": 9
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "with the following address",
  "rows": [
    {
      "cells": [
        "address_id",
        "street",
        "city",
        "zip",
        "state",
        "country",
        "phone"
      ],
      "line": 12
    },
    {
      "cells": [
        "1",
        "123 Main Street",
        "10001",
        "32811",
        "OH",
        "USA",
        "641-342-547"
      ],
      "line": 13
    },
    {
      "cells": [
        "2",
        "124 Main Street",
        "10001",
        "32812",
        "FL",
        "USA",
        "771-342-4536"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "employee already exists",
  "keyword": "When "
});
formatter.match({
  "location": "EmployeeSteps.an_employee_with_the_following_attributes(Employee\u003e)"
});
formatter.result({
  "duration": 816458000,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeSteps.with_the_following_address(Address\u003e)"
});
formatter.result({
  "duration": 34411600,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeSteps.employee_already_exists()"
});
formatter.result({
  "duration": 74000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "GET BY ID",
  "description": "",
  "id": "get-employee;get-by-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "user wants to get employee by id 2",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the get \u0027IS SUCCESSFUL\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "following employee is returned",
  "rows": [
    {
      "cells": [
        "matriculeId",
        "firstname",
        "lastname",
        "dateOfBirth",
        "startDate",
        "employmentType",
        "email",
        "salaire"
      ],
      "line": 24
    },
    {
      "cells": [
        "200",
        "Rachel",
        "Green",
        "1990-01-01",
        "2018-01-01",
        "Permanent",
        "rachel.green@fs.com",
        "100000"
      ],
      "line": 25
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "following employee address are returned",
  "rows": [
    {
      "cells": [
        "address_id",
        "street",
        "city",
        "zip",
        "state",
        "country",
        "phone"
      ],
      "line": 28
    },
    {
      "cells": [
        "1",
        "123 Main Street",
        "Columbus",
        "32811",
        "OH",
        "USA",
        "641-342-547"
      ],
      "line": 29
    },
    {
      "cells": [
        "2",
        "124 Main Street",
        "Dallas",
        "32812",
        "TX",
        "USA",
        "771-342-4536"
      ],
      "line": 30
    },
    {
      "cells": [
        "3",
        "4633 Cason Cove DR",
        "Orlando",
        "32810",
        "FL",
        "USA",
        "771-342-4536"
      ],
      "line": 31
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 33
    }
  ],
  "location": "EmployeeSteps.user_wants_to_get_employee_by_id(int)"
});
formatter.result({
  "duration": 26811399,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeSteps.the_get_IS_SUCCESSFUL()"
});
formatter.result({
  "duration": 66100,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeSteps.following_employee_is_returned(Employee\u003e)"
});
formatter.result({
  "duration": 780999,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeSteps.following_employee_address_are_returned(Address\u003e)"
});
formatter.result({
  "duration": 1451301,
  "status": "passed"
});
formatter.after({
  "duration": 15777600,
  "status": "passed"
});
formatter.after({
  "duration": 80300,
  "status": "passed"
});
formatter.uri("features/100-movie.feature");
formatter.feature({
  "line": 2,
  "name": "Get movie details",
  "description": "",
  "id": "get-movie-details",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.before({
  "duration": 8732000,
  "status": "passed"
});
formatter.before({
  "duration": 743400,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "calls all movies from web service",
  "description": "",
  "id": "get-movie-details;calls-all-movies-from-web-service",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "A list of movies are available",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "we add a movie to the list",
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 7
    },
    {
      "cells": [
        "11",
        "Toy Story 4",
        "2019",
        "Tom Hanks, Tim Allen",
        "1919-03-01"
      ],
      "line": 8
    },
    {
      "cells": [
        "12",
        "Joe",
        "2022",
        "Rodrigue Medor",
        "1919-03-01"
      ],
      "line": 9
    },
    {
      "cells": [
        "14",
        "Zark",
        "2021",
        "Sara Valentin",
        "1919-03-01"
      ],
      "line": 10
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the following movie exist",
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 12
    },
    {
      "cells": [
        "11",
        "Toy Story 4",
        "2019",
        "Tom Hanks, Tim Allen",
        "1919-03-01"
      ],
      "line": 13
    },
    {
      "cells": [
        "12",
        "Joe",
        "2022",
        "Rodrigue Medor",
        "1919-03-01"
      ],
      "line": 14
    },
    {
      "cells": [
        "14",
        "Zark",
        "2021",
        "Sara Valentin",
        "1919-03-01"
      ],
      "line": 15
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the movie is added",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the movie \"Toy Story 4\" remove from the list",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the movie is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.a_list_of_movies_are_available()"
});
formatter.result({
  "duration": 82408399,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.we_add_a_movie_to_the_list(Movie\u003e)"
});
formatter.result({
  "duration": 198964300,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_following_movie_exist(Movie\u003e)"
});
formatter.result({
  "duration": 32823101,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_movie_is_added()"
});
formatter.result({
  "duration": 258901,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Toy Story 4",
      "offset": 11
    }
  ],
  "location": "MovieSteps.we_remove_a_movie_id_from_the_list(String)"
});
formatter.result({
  "duration": 36250000,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_movie_is_removed()"
});
formatter.result({
  "duration": 78801,
  "status": "passed"
});
formatter.after({
  "duration": 6568100,
  "status": "passed"
});
formatter.after({
  "duration": 53300,
  "status": "passed"
});
formatter.before({
  "duration": 9853300,
  "status": "passed"
});
formatter.before({
  "duration": 604600,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "WITH ALL REQUIRED FIELDS IS SUCCESSFUL",
  "description": "",
  "id": "get-movie-details;with-all-required-fields-is-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "user wants to create and list a movie with the following attributes",
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 22
    },
    {
      "cells": [
        "11",
        "Toy Story 4",
        "2019",
        "Tom Hanks, Tim Allen",
        "1919-03-01"
      ],
      "line": 23
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "user saves the new movie1 \u0027WITH ALL REQUIRED FIELDS\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "the save \u0027IS SUCCESSFUL\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_and_list_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 33409899,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie1_WITH_ALL_REQUIRED_FIELDS()"
});
formatter.result({
  "duration": 17377200,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_IS_SUCCESSFUL()"
});
formatter.result({
  "duration": 227999,
  "status": "passed"
});
formatter.after({
  "duration": 2634700,
  "status": "passed"
});
formatter.after({
  "duration": 186199,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 28,
  "name": "\u003ctestCase\u003e \u003cexpectedResult\u003e",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "\u003cname\u003e",
        "\u003cyear\u003e",
        "\u003ccast\u003e",
        "\u003crelease_date\u003e"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027\u003ctestCase\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027\u003cexpectedResult\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;",
  "rows": [
    {
      "cells": [
        "testCase",
        "expectedResult",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 39,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;1"
    },
    {
      "cells": [
        "WITHOUT ID",
        "FAILS",
        "Toy Story 4",
        "2019",
        "Tom Hanks, Tim Allen",
        "2005-06-15"
      ],
      "line": 40,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;2"
    },
    {
      "cells": [
        "WITHOUT name",
        "FAILS",
        "",
        "2022",
        "Rodrigue Medor",
        "2005-06-16"
      ],
      "line": 41,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;3"
    },
    {
      "cells": [
        "WITHOUT year",
        "FAILS",
        "Zark",
        "",
        "Sara Valentin",
        "2005-06-18"
      ],
      "line": 42,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;4"
    },
    {
      "cells": [
        "WITHOUT cast",
        "FAILS",
        "Toy Story 4",
        "2019",
        "",
        "2005-06-20"
      ],
      "line": 43,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;5"
    },
    {
      "cells": [
        "WITH ALL REQUIRED FIELDS",
        "IS SUCCESSFUL",
        "Joe",
        "2022",
        "Rodrigue Medor",
        "2005-06-28"
      ],
      "line": 44,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;6"
    },
    {
      "cells": [
        "WITH ALL REQUIRED FIELDS",
        "IS SUCCESSFUL",
        "Zark",
        "2021",
        "Sara Valentin Kayleigh",
        "2005-07-15"
      ],
      "line": 45,
      "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;7"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6808899,
  "status": "passed"
});
formatter.before({
  "duration": 749600,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "WITHOUT ID FAILS",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "Toy Story 4",
        "2019",
        "Tom Hanks, Tim Allen",
        "2005-06-15"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITHOUT ID\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027FAILS\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 63624599,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 18673401,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITHOUT_ID()"
});
formatter.result({
  "duration": 17392800,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_FAILS()"
});
formatter.result({
  "duration": 64000,
  "status": "passed"
});
formatter.after({
  "duration": 3754400,
  "status": "passed"
});
formatter.after({
  "duration": 73501,
  "status": "passed"
});
formatter.before({
  "duration": 7042401,
  "status": "passed"
});
formatter.before({
  "duration": 661000,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "WITHOUT name FAILS",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "",
        "2022",
        "Rodrigue Medor",
        "2005-06-16"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITHOUT name\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027FAILS\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 121300200,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 17314699,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITHOUT_name()"
});
formatter.result({
  "duration": 23017000,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_FAILS()"
});
formatter.result({
  "duration": 80800,
  "status": "passed"
});
formatter.after({
  "duration": 3227500,
  "status": "passed"
});
formatter.after({
  "duration": 74499,
  "status": "passed"
});
formatter.before({
  "duration": 9051800,
  "status": "passed"
});
formatter.before({
  "duration": 780199,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "WITHOUT year FAILS",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "Zark",
        "",
        "Sara Valentin",
        "2005-06-18"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITHOUT year\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027FAILS\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 131532200,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 16729100,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITHOUT_year()"
});
formatter.result({
  "duration": 16409400,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_FAILS()"
});
formatter.result({
  "duration": 68900,
  "status": "passed"
});
formatter.after({
  "duration": 2523799,
  "status": "passed"
});
formatter.after({
  "duration": 58200,
  "status": "passed"
});
formatter.before({
  "duration": 6242701,
  "status": "passed"
});
formatter.before({
  "duration": 910901,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "WITHOUT cast FAILS",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "Toy Story 4",
        "2019",
        "",
        "2005-06-20"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITHOUT cast\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027FAILS\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 66132500,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 17263701,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITHOUT_cast()"
});
formatter.result({
  "duration": 14675199,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_FAILS()"
});
formatter.result({
  "duration": 64199,
  "status": "passed"
});
formatter.after({
  "duration": 4453000,
  "status": "passed"
});
formatter.after({
  "duration": 58601,
  "status": "passed"
});
formatter.before({
  "duration": 9344500,
  "status": "passed"
});
formatter.before({
  "duration": 658000,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "WITH ALL REQUIRED FIELDS IS SUCCESSFUL",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "Joe",
        "2022",
        "Rodrigue Medor",
        "2005-06-28"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITH ALL REQUIRED FIELDS\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027IS SUCCESSFUL\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 111151401,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 18003600,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITH_ALL_REQUIRED_FIELDS()"
});
formatter.result({
  "duration": 14816301,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_IS_SUCCESSFUL()"
});
formatter.result({
  "duration": 469900,
  "status": "passed"
});
formatter.after({
  "duration": 4716500,
  "status": "passed"
});
formatter.after({
  "duration": 61300,
  "status": "passed"
});
formatter.before({
  "duration": 7034000,
  "status": "passed"
});
formatter.before({
  "duration": 752300,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "WITH ALL REQUIRED FIELDS IS SUCCESSFUL",
  "description": "",
  "id": "get-movie-details;\u003ctestcase\u003e-\u003cexpectedresult\u003e;;7",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@getexample"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "fetch list of movies",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "user wants to create a movie with the following attributes",
  "matchedColumns": [
    2,
    3,
    4,
    5
  ],
  "rows": [
    {
      "cells": [
        "movie_id",
        "name",
        "year",
        "cast",
        "release_date"
      ],
      "line": 32
    },
    {
      "cells": [
        "12",
        "Zark",
        "2021",
        "Sara Valentin Kayleigh",
        "2005-07-15"
      ],
      "line": 33
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "user saves the new movie \u0027WITH ALL REQUIRED FIELDS\u0027",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "the save \u0027IS SUCCESSFUL\u0027",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "MovieSteps.getListOfMovies()"
});
formatter.result({
  "duration": 83335999,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_wants_to_create_a_movie_with_the_following_attributes(Movie\u003e)"
});
formatter.result({
  "duration": 15529000,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.user_saves_the_new_movie_WITH_ALL_REQUIRED_FIELDS()"
});
formatter.result({
  "duration": 14003600,
  "status": "passed"
});
formatter.match({
  "location": "MovieSteps.the_save_IS_SUCCESSFUL()"
});
formatter.result({
  "duration": 158999,
  "status": "passed"
});
formatter.after({
  "duration": 6647801,
  "status": "passed"
});
formatter.after({
  "duration": 57199,
  "status": "passed"
});
});