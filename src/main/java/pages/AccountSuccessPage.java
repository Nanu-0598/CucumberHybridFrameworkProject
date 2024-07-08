package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class AccountSuccessPage {
	
WebDriver driver;
private ElementsUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}

	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement successMsg;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	
	
	
	public String getPageHeading() {
		return elementUtils.getTextFromElement(successMsg, commonUtils.EXPLICIT_WAIT_TIME);
		//return successMsg.getText();
	}
	
}
