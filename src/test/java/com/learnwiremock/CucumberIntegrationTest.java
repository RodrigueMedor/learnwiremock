package com.learnwiremock;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//
//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("com/planetpope/cucumber")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/cucumber.json")

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:out/htmlReport.html", "json:target/cucumber.json", "junit:target/cucumber.xml"},
        glue = {"com.learnwiremock.steps"},
        features = {"src/test/resources/features"})
public class CucumberIntegrationTest extends SpringIntegrationTest{

}
