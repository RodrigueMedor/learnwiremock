package com.learnwiremock;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:out/htmlReport.html"},
        glue = {"com.learnwiremock.steps"},
        features = {"src/test/resources/features"})
public class CucumberIntegrationTest extends SpringIntegrationTest{

}
