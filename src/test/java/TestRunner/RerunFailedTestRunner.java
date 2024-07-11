package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/rerun.txt", // Path to the rerun file
    glue = {"stepDefinitions","Hooks"},
    plugin = {
        "pretty",
        "json:target/cucumber-reports/Cucumber-rerun.json"
    },
    monochrome = true
)

public class RerunFailedTestRunner {

}
