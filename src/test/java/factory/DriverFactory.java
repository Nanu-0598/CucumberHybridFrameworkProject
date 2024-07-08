package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.commonUtils;


public class DriverFactory {
	
	static WebDriver driver = null;

	public static WebDriver browserIntialize(String browserName) {
		

		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		
		
		  driver.manage().deleteAllCookies(); 
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtils.PAGE_LOAD_TIME));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtils.IMPLICIT_WAIT_TIME)); 
		  return driver;
		 
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}
}
