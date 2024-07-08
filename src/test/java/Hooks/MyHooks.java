package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.configReader;
import io.cucumber.java.Scenario;

public class MyHooks {

	WebDriver driver;

	@Before
	public void setup() {

		Properties prop = new configReader().intializeProperties();
		driver = DriverFactory.browserIntialize(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {

		String scenarioName = scenario.getName().replace(" ","_");
		if(scenario.isFailed()) {
			byte [] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		driver.quit();
	}

}
