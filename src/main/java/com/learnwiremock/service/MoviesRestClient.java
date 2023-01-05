package com.learnwiremock.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnwiremock.dto.Employee;
import com.learnwiremock.dto.Movie;
import com.learnwiremock.exception.MovieErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.learnwiremock.constants.MoviesAppConstants.*;

@Slf4j
@RestController
public class MoviesRestClient {

    @Value("${movieapp.baseUrl}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/all")
    public List<Movie> retrieveAllMovies() {
        List<Movie> movieList;
        try {
            log.info("Inside retrieve all movies");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Movie>> responseEntity = restTemplate.exchange(GET_ALL_MOVIES_V1,HttpMethod.GET, entity, new ParameterizedTypeReference<List<Movie>>(){});
            movieList = responseEntity.getBody();
//            ResponseEntity<Object[]> responseEntity =
//                    restTemplate.getForEntity(GET_ALL_MOVIES_V1, Object[].class);
//            Object[] objects = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
//            movieList = Arrays.stream(objects)
//                    .map(object -> mapper.convertValue(object, Movie.class))
//                    .collect(Collectors.toList());
            log.info("after the call");
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {} ", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} and exception is ", ex.getMessage() + ex);
            throw new MovieErrorResponse(ex.getMessage(), ex);
        }
        return movieList;
    }

    public List<Employee> retrieveAllEmployeees() {
        List<Employee> employeeList;
        try {
            log.info("Inside retrieve all employees");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(GET_ALL_EMPLOYEES_V1,HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>(){});
            employeeList = responseEntity.getBody();
            log.info("after the call");
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {} ", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} and exception is ", ex.getMessage() + ex);
            throw new MovieErrorResponse(ex.getMessage(), ex);
        }
        return employeeList;
    }

    public Movie retrieveMovieById(Integer movieId) {
        Movie movie;
        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_ID_PATH_PARAM_V1+movieId)
                    .buildAndExpand()
                    .toUriString();
            movie = restTemplate.getForObject(retrieveByNameUri, Movie.class);
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Exception is {} and the Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return movie;
    }

    public Employee retrieveEmployeeById(Integer employee_Id) {
        Employee employee;
        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(EMPLOYEE_BY_ID_PATH_PARAM_V1).path(String.valueOf(employee_Id))
                    //.buildAndExpand()
                    .toUriString();
            employee = restTemplate.getForObject(retrieveByNameUri, Employee.class);
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Exception is {} and the Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return employee;
    }


    public List<Movie> retrieveMovieByName(String movieName) {

        List<Movie> movieList = null;
        String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_NAME_QUERY_PARAM_V1)
                .queryParam("movie_name", movieName)
                .buildAndExpand()
                .toUriString();

        try {
            ResponseEntity<Object[]> responseEntity =
                    restTemplate.getForEntity(retrieveByNameUri, Object[].class);
            Object[] objects = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            movieList = Arrays.stream(objects)
                    .map(object -> mapper.convertValue(object, Movie.class))
                    .collect(Collectors.toList());
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Exception is {} and the Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return movieList;
    }

    public List<Employee> retrieveEmployeeBylastname(String lastname) {

        List<Employee> employeeList = null;
        String retrieveByNameUri = UriComponentsBuilder.fromUriString(EMPLOYEE_BY_LASTNAME_QUERY_PARAM_V1)
                .queryParam("lastname", lastname)
                .buildAndExpand()
                .toUriString();

        try {
            ResponseEntity<Object[]> responseEntity =
                    restTemplate.getForEntity(retrieveByNameUri, Object[].class);
            Object[] objects = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            employeeList = Arrays.stream(objects)
                    .map(object -> mapper.convertValue(object, Employee.class))
                    .collect(Collectors.toList());
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Exception is {} and the Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return employeeList;
    }


    /**
     * This method makes a REST call to the Movies RESTFUL Service and retrieves a list of Movies as a response based on the year.
     *
     * @param year - Integer (Example : 2012,2013 etc.,)
     * @return - List<Movie>
     */
    public List<Movie> retreieveMovieByYear(Integer year) {
        String retrieveByYearUri = UriComponentsBuilder.fromUriString(MOVIE_BY_YEAR_QUERY_PARAM_V1)
                .queryParam("year", year)
                .buildAndExpand()
                .toUriString();
        List<Movie> movieList;

        try {
            ResponseEntity<Object[]> responseEntity =
                    restTemplate.getForEntity(retrieveByYearUri, Object[].class);
            Object[] objects = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            movieList = Arrays.stream(objects)
                    .map(object -> mapper.convertValue(object, Movie.class))
                    .collect(Collectors.toList());
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException in retreieveMovieByYear {} and the Error Message is : {} ", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return movieList;
    }

    /**
     * This method makes the REST call to add a new Movie to the Movies RESTFUL Service.
     *
     * @param newMovie
     * @return
     */
    public Movie addNewMovie(Movie newMovie) {
        Movie movie;
        try {
            log.info("New Movie SuccessFully added rodrigue {} ", newMovie);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = new ObjectMapper().writeValueAsString(newMovie);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            log.info("New Movie SuccessFully added entity {} ", entity);

//            String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_ID_PATH_PARAM_V1+movieId)
//                    .buildAndExpand()
//                    .toUriString();
//            updatedMovie = restTemplate.exchange(retrieveByNameUri, HttpMethod.PUT, entity, Movie.class).getBody();
            movie = restTemplate.exchange(ADD_MOVIE_V1,HttpMethod.POST, entity, Movie.class).getBody();
            log.info("New Movie SuccessFully added {} ", movie);
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {} , and the Error Response Body is {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return movie;
    }

    public Employee addNewEmployee(Employee newEmployee) {
        Employee employee = null;
        try {
            log.info("New Employee SuccessFully added {} ", newEmployee);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String json = new ObjectMapper().writeValueAsString(newEmployee);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            log.info("New Employee SuccessFully added entity {} ", entity);
            if(retrieveEmployeeById(newEmployee.getMatriculeId()) == null){
                employee = restTemplate.exchange(ADD_EMPLOYEE_V1,HttpMethod.POST, entity, Employee.class).getBody();
                log.info("New Employee SuccessFully added {} ", employee);
            }else {
                employee = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employee).getBody();
                log.info("employee already exists");
            }
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {} , and the Error Response Body is {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return employee;
    }

    public Movie updateMovie(Integer movieId, Movie movie) {
        Movie updatedMovie;

        try {
            HttpHeaders headers = new HttpHeaders();
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Movie> entity = new HttpEntity<>(movie, headers);

            String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_ID_PATH_PARAM_V1+movieId)
                    .buildAndExpand()
                    .toUriString();
            updatedMovie = restTemplate.exchange(retrieveByNameUri, HttpMethod.PUT, entity, Movie.class).getBody();
            log.info(" Movie SuccessFully updated {} ", updatedMovie);
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }

        return updatedMovie;
    }

    public Employee updateEmployee(Integer employee_id, Employee employee) {
        Employee updatedEmployee;

        try {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);

            String retrieveByNameUri = UriComponentsBuilder.fromUriString(EMPLOYEE_BY_ID_PATH_PARAM_V1+employee_id)
                    .buildAndExpand()
                    .toUriString();
            updatedEmployee = restTemplate.exchange(retrieveByNameUri, HttpMethod.PUT, entity, Employee.class).getBody();
            log.info(" Movie SuccessFully updated {} ", updatedEmployee);
        } catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }

        return updatedEmployee;
    }

    public String deleteMovieById(Integer movieId) {

        String response;
        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_ID_PATH_PARAM_V1+movieId)
                    .buildAndExpand()
                    .toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Movie> entity = new HttpEntity<Movie>(headers);
            response = restTemplate.exchange(retrieveByNameUri, HttpMethod.DELETE, entity, String.class).getBody();
            log.info(" Movie SuccessFully deleted {} ", response);
        }catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }

        return response;

    }

    public String deleteEmployeeById(Integer movieId) {

        String response;
        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(EMPLOYEE_BY_ID_PATH_PARAM_V1+movieId)
                    .buildAndExpand()
                    .toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Employee> entity = new HttpEntity<>(headers);
            response = restTemplate.exchange(retrieveByNameUri, HttpMethod.DELETE, entity, String.class).getBody();
            log.info("Employee SuccessFully deleted {} ", response);
        }catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - Error Message is : {}", ex, ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }

        return response;
    }
    public String deleteMovieByName(String movieName) {

        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(MOVIE_BY_NAME_PATH_PARAM_V1+movieName)
                    .buildAndExpand()
                    .toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Movie> entity = new HttpEntity<Movie>(headers);
         restTemplate.exchange(retrieveByNameUri, HttpMethod.DELETE, entity, String.class).getBody();
        }catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - The Status code is {} and the Error Message is : {}", ex.getRawStatusCode(), ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return "Movie Deleted SuccessFully";
    }

    public String deleteEmployeeByLastname(String lastname) {

        try {
            String retrieveByNameUri = UriComponentsBuilder.fromUriString(EMPLOYEE_BY_LASTNAME_PATH_PARAM_V1+lastname)
                    .buildAndExpand()
                    .toUriString();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Employee> entity = new HttpEntity<>(headers);
            restTemplate.exchange(retrieveByNameUri, HttpMethod.DELETE, entity, String.class).getBody();
        }catch (WebClientResponseException ex) {
            log.error("WebClientResponseException - The Status code is {} and the Error Message is : {}", ex.getRawStatusCode(), ex.getResponseBodyAsString());
            throw new MovieErrorResponse(ex.getStatusText(), ex);
        } catch (Exception ex) {
            log.error("Exception - The Error Message is {} ", ex.getMessage());
            throw new MovieErrorResponse(ex);
        }
        return "Employee Deleted SuccessFully";
    }
}
