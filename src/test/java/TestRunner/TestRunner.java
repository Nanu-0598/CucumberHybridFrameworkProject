package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features/Login.feature",
				glue = { "stepDefinitions", "Hooks" },
				publish=true,
				plugin={"pretty","html:target/CucumberReports/CucumberReport.html","rerun:target/rerun.txt"},

				monochrome = true
		)


public class TestRunner {

}
 