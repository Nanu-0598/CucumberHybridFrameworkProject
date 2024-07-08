package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
				glue = { "stepDefinitions", "Hooks" },
				publish=true,
				plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})


public class TestRunner {

}