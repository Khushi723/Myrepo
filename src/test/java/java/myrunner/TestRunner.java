package java.myrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/feature"},
				 glue = {"src/test/java/stepdefinition"}
				 )
public class TestRunner {

}
