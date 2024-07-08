package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class LoginPage {
	
WebDriver driver;
private ElementsUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement warningMsg;
	
	

	
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, commonUtils.EXPLICIT_WAIT_TIME);
		//emailField.sendKeys(emailText);
	}
	 
	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, password, commonUtils.EXPLICIT_WAIT_TIME);
		//passwordField.sendKeys(password);
	}
	
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, commonUtils.EXPLICIT_WAIT_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}
	
	public String warningMsgtext() {
		return elementUtils.getTextFromElement(warningMsg, commonUtils.EXPLICIT_WAIT_TIME);
		//return warningMsg.getText();
	}

}
