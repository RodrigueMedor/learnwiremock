package com.learnwiremock.steps;

import com.atlassian.ta.wiremockpactgenerator.WireMockPactGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.learnwiremock.dto.Movie;
import com.learnwiremock.SpringIntegrationTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.But;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.learnwiremock.constants.MoviesAppConstants.ADD_MOVIE_V1;
import static com.learnwiremock.constants.MoviesAppConstants.GET_ALL_MOVIES_V1;
import static org.junit.Assert.*;

public class MovieSteps extends SpringIntegrationTest {



    @Before
    public void setUp() {
        wireMockPact =
                WireMockPactGenerator
                        .builder("orderMs", "jsonPlaceHolderMs")
                        .withRequestPathWhitelist(
                                GET_ALL_MOVIES_V1+".*"
                        )
                        .build();
        wireMockRule.addMockServiceRequestListener(
                wireMockPact
        );
//        wireMockRule.stubFor(get(urlMatching(GET_ALL_MOVIES_V1+".*"))
//                    .willReturn(
//                            aResponse()
//                                    .withStatus(200)
//                                    .withHeader("Content-Type", "application/json")
//                                    .withBodyFile("all-movies.json")));

    }

    @Given("^A list of movies are available$")
    public void a_list_of_movies_are_available() {

        wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBodyFile("all-movies.json")));
        //whenx
        List<Movie> movieList = moviesRestClient.retrieveAllMovies();
        System.out.println("movieList : " + movieList);

        //then
        assertTrue(!movieList.isEmpty());
    }

    @When("^we add a movie to the list$")
    public void we_add_a_movie_to_the_list(List<Movie> stores) throws JsonProcessingException {
        System.out.println("LocalDate id "+ stores);
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name"), containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.cast"), containing("Medor")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(stores.stream().filter(player -> player.getName().contains("Joe"))
                                .findAny().orElse(null)))));
        Movie movie = stores.stream().filter(player -> player.getName().contains("Joe"))
                .findAny().orElse(null);
        System.out.println("List ***********"+ stores);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&"+ movie);

            Movie movie2 = moviesRestClient.addNewMovie(movie);
            assertEquals(movie2.getMovie_id(), movie.getMovie_id());


        //then
        assertFalse(stores.isEmpty());
    }

    @Given("^the following movie exist$")
    public void the_following_movie_exist(List<Movie> movies) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json =  objectMapper.writeValueAsString(movies);
                wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody(json)));
        System.out.println("movieList1 : " + json);
        //whenx
        List<Movie> movieList = moviesRestClient.retrieveAllMovies();
        System.out.println("movieList2 : " + movieList);

        //then
        assertTrue(!movieList.isEmpty());
        assertEquals(movieList.size(), movies.size());
    }


    @Then("^the movie is added$")
    public void the_movie_is_added() {
        wireMockRule.givenThat(get(urlPathMatching("/movieservice/v1/movie/.*")).willReturn(
                aResponse().withStatus(201)
        ));
    }

    @When("^the movie \"([^\"]*)\" remove from the list$")
    public void we_remove_a_movie_id_from_the_list(String name) {
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
                .withRequestBody(matchingJsonPath("$.name", equalTo(name)))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("add-movie.json")));

        wireMockRule.stubFor(delete(urlPathMatching("/movieservice/v1/movieName/.*"))
                .willReturn(WireMock.ok()));

        String toyStoryCrew = "Tom Hanks, Tim Allen";
        Movie toyStory = new Movie(null, name, 2019, toyStoryCrew, null);
        Movie movie = moviesRestClient.addNewMovie(toyStory);

        //when
        String responseMessage = moviesRestClient.deleteMovieByName(name);

        //then
        assertEquals("Movie Deleted SuccessFully", responseMessage);
    }


    @Then("^the movie is removed$")
    public void the_movie_is_removed() throws Throwable {
        givenThat(get(urlPathMatching("/movieservice/v1/movieName/.*")).willReturn(
                aResponse().withStatus(200)
        ));
    }

    private Movie movie;

    @Given("^user wants to create and list a movie with the following attributes$")
    public void user_wants_to_create_and_list_a_movie_with_the_following_attributes(List<Movie> movies) throws Throwable {
        movie = movies.stream().findAny().orElse(null);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(movie);
        List<String>  stringList = new ArrayList<>();
        stringList.add(json);
        System.out.println("Json array: "+stringList);

        wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody(stringList.toString())));
        System.out.println("movieList : " + movies);
        System.out.println("movie : " + movie);
        //whenx
        List<Movie> movieList = moviesRestClient.retrieveAllMovies();
        System.out.println("movieList : " + movieList);

        //then
        assertEquals(movies.size(), movieList.size());
    }

    @When("^user saves the new movie1 'WITH ALL REQUIRED FIELDS'$")
    public void user_saves_the_new_movie1_WITH_ALL_REQUIRED_FIELDS() throws Throwable {
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movie))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITH ALL REQUIRED FIELDS"+ movie);

        Movie movie2 = moviesRestClient.addNewMovie(movie);
        assertEquals(movie2.getMovie_id(), movie.getMovie_id());
    }

    @Then("^the save 'IS SUCCESSFUL'$")
    public void the_save_IS_SUCCESSFUL() throws Throwable {
        wireMockRule.givenThat(get(urlPathMatching("/movieservice/v1/movie/.*")).willReturn(
                aResponse().withStatus(201)
        ));
    }

    private Movie movieNew;
    @Given("^user wants to create a movie with the following attributes$")
    public void user_wants_to_create_a_movie_with_the_following_attributes(List<Movie> movies) throws Throwable {
        movieNew = movies.stream().findAny().orElse(null);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(movieNew);
//        List<String>  stringList = new ArrayList<>();
//        stringList.add(json);
//        System.out.println("Json array: "+stringList);

        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(json)));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& user wants to create a movie"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getMovie_id(), movieNew.getMovie_id());

    }

    @When("^user saves the new movie 'WITHOUT ID'$")
    public void user_saves_the_new_movie_WITHOUT_ID() throws Throwable {
        movieNew.setMovie_id(null);
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movieNew))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITHOUT ID"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getMovie_id(), movieNew.getMovie_id());
    }

    @Then("^the save 'FAILS'$")
    public void the_save_FAILS() {
            givenThat(post(urlPathMatching(ADD_MOVIE_V1)).willReturn(
                    aResponse().withStatus(404)
            ));
    }

    @When("^user saves the new movie 'WITHOUT name'$")
    public void user_saves_the_new_movie_WITHOUT_name() throws Throwable {
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movieNew))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITHOUT name"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getName(), movieNew.getName());
    }

    @When("^user saves the new movie 'WITHOUT year'$")
    public void user_saves_the_new_movie_WITHOUT_year() throws Throwable {
//        movieNew.setYear(null);
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movieNew))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITHOUT year"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getYear(), movieNew.getYear());
    }

    @When("^user saves the new movie 'WITHOUT cast'$")
    public void user_saves_the_new_movie_WITHOUT_cast() throws Throwable {
//        movieNew.setCast(null);
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
//                .withRequestBody(matchingJsonPath("$.name", containing("Joe")))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movieNew))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITHOUT cast"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getCast(), movieNew.getCast());
    }

    @When("^user saves the new movie 'WITH ALL REQUIRED FIELDS'$")
    public void user_saves_the_new_movie_WITH_ALL_REQUIRED_FIELDS() throws Throwable {
        wireMockRule.stubFor(post(urlPathEqualTo(ADD_MOVIE_V1))
                .withRequestBody(matchingJsonPath(("$.name")))
                .withRequestBody(matchingJsonPath(("$.cast")))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.CREATED.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(new ObjectMapper().writeValueAsString(movieNew))));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& WITH ALL REQUIRED FIELDS"+ movieNew);

        Movie movie2 = moviesRestClient.addNewMovie(movieNew);
        assertEquals(movie2.getMovie_id(), movieNew.getMovie_id());
    }

}
