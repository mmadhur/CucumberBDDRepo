package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//Features/Customer.feature", glue = "StepDefinition", dryRun = false, plugin = { "pretty",
				"html:target/HtmlReports" }, monochrome = true

)
public class TestRun {

}

//plugin = { "pretty",
//"html:test-output" }