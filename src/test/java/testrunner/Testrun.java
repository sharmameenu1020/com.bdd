package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = ".//Features/customer.feature", 
glue = "StepDeffination", 
dryRun = false, monochrome = false,
plugin = {
		"pretty", "html:target/Cucumber-report/Customer.html" })

//the cucumber file will always be empty
public class Testrun {
	
}
