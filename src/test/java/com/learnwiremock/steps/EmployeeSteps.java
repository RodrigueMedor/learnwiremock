package com.learnwiremock.steps;

import com.atlassian.ta.wiremockpactgenerator.WireMockPactGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.learnwiremock.LearnwiremockApplication;
//import com.learnwiremock.SpringIntegrationTest;
import com.learnwiremock.dto.Address;
import com.learnwiremock.dto.Employee;
import com.learnwiremock.service.MoviesRestClient;
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
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.learnwiremock.constants.MoviesAppConstants.*;
import static org.junit.Assert.assertEquals;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@ContextConfiguration
@SpringBootTest(classes = LearnwiremockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties= {"movieapp.baseUrl=http://localhost:8888"})
public class EmployeeSteps /*extends SpringIntegrationTest*/ {

    protected WireMockPactGenerator wireMockPact;

    @Autowired
    protected MoviesRestClient moviesRestClient;
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8888));

    @Before
    public void setUp() {

        wireMockPact = WireMockPactGenerator
                .builder("employeeMs", "employeeBooksMs")
                .withRequestPathWhitelist(
                        GET_ALL_EMPLOYEES_V1+".*"
                )
                .build();
        wireMockRule.addMockServiceRequestListener(
                wireMockPact
        );

        wireMockRule.stubFor(get(urlMatching(GET_ALL_EMPLOYEES_V1+".*"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBodyFile("all-employes.json")));

    }

    private List<Employee> employees;

    @Given("^an employee with the following attributes$")
    public void an_employee_with_the_following_attributes(List<Employee> employeeList) throws JsonProcessingException {
        employees = employeeList;

        ObjectMapper objectMapper = new ObjectMapper();
        String json =  objectMapper.writeValueAsString(employeeList);
        wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody(json)));
        System.out.println("movieList1 : " + json);
        //whenx
        List<Employee> employeees = moviesRestClient.retrieveAllEmployeees();

        //then
        assertEquals(employeees.size(), employeeList.size());

    }

    private List<Address> addressList;
    @Given("^with the following address$")
    public void with_the_following_address(List<Address> addresses) throws Throwable {
//        Given
        ObjectMapper objectMapper = new ObjectMapper();
        String json =  objectMapper.writeValueAsString(addresses);
        wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody(json)));
        System.out.println("addresses  : " + json);
        //whenx
        List<Employee> employeees = moviesRestClient.retrieveAllEmployeees();
        addressList = employeees.stream().map(Employee::getAddress).collect(Collectors.toList());

        //then
        assertEquals(addresses.size(), addressList.size());
    }

    @When("^employee already exists$")
    public void employee_already_exists() throws Throwable {
        givenThat(post(urlPathEqualTo(ADD_EMPLOYEE_V1)).willReturn(
                aResponse().withStatus(400)
        ));
    }

    @When("^user wants to get employee by id (\\d+)$")
    public void user_wants_to_get_employee_by_id(int employee_id) throws Throwable {

       Employee employee1 = employees.stream().filter(employee-> employee.getMatriculeId() == employee_id).findAny().get();
//       Address address1 = addressList.stream().filter(address-> address.getAddress_id()!=0).findAny().get();
   //    employee1.setAddress(address1);

        ObjectMapper objectMapper = new ObjectMapper();
        String json =  objectMapper.writeValueAsString(employee1);
        wireMockRule.stubFor(get(WireMock.anyUrl())
                .willReturn(WireMock.aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody(json)));
        System.out.println("movieList10 : " + json);
        //whenx
        Employee employeeee = moviesRestClient.retrieveEmployeeById(employee1.getMatriculeId());

        //then
        assertEquals(employeeee.getMatriculeId(), employee1.getMatriculeId());
    }

    @Then("^the get 'IS SUCCESSFUL'$")
    public void the_get_IS_SUCCESSFUL() throws Throwable {

    }

    @Then("^following employee is returned$")
    public void following_employee_is_returned(List<Employee> employeeList) throws Throwable {

    }

    @Then("^following employee address are returned$")
    public void following_employee_address_are_returned(List<Address> addresses) throws Throwable {

    }
}
