package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementsUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginbutton;
	
	@FindBy(linkText="Register")
	private WebElement registerButton;
	
	@FindBy(name="search")
	private WebElement searchField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	
	
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, commonUtils.EXPLICIT_WAIT_TIME);
		//myAccountDropMenu.click();
	}
	
	public LoginPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginbutton, commonUtils.EXPLICIT_WAIT_TIME);
		//loginbutton.click();
		return new LoginPage (driver);
	}
	
	public RegisterPage clickOnRegisterOption() {
		elementUtils.clickOnElement(registerButton, commonUtils.EXPLICIT_WAIT_TIME);
		//registerButton.click();
		return new RegisterPage(driver);
	}
	
	public void enterSearchProductInSearchField(String product) {
		elementUtils.typeTextIntoElement(searchField, product, commonUtils.EXPLICIT_WAIT_TIME);
		//searchField.sendKeys(product);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, commonUtils.EXPLICIT_WAIT_TIME);
		//searchButton.click();
		return new SearchResultsPage(driver);
	}
}
