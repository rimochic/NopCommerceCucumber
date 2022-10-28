package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
			(
				features = "./Features/",
				glue = {"stepDefinitions"},
				tags= "@sanity or @regression",
				dryRun = false,
				monochrome = true,
				plugin = {"pretty", "html:target/Login"}
			)
public class TestRun {

}
