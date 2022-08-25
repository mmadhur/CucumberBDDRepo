package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Features/Customer.feature", glue = "StepDefinition", dryRun = false, plugin = { "pretty",
				"html:test-output" }, monochrome = true

)
public class TestRun {

}

