package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementsUtils elementUtils;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyoptions;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsLetter;

	@FindBy(xpath = "//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement warningMsg;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyWarningMsg;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement EmailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordeWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}

	public void enterFirstNameText(String firstName) {
		elementUtils.typeTextIntoElement(firstNameField, firstName, commonUtils.EXPLICIT_WAIT_TIME);
		//firstNameField.sendKeys(firstName);
	}

	public void enterLastNameText(String lastName) {
		elementUtils.typeTextIntoElement(lastNameField, lastName, commonUtils.EXPLICIT_WAIT_TIME);
		//lastNameField.sendKeys(lastName);
	}

	public void enterEmailAddress(String email) {
		elementUtils.typeTextIntoElement(emailField, email, commonUtils.EXPLICIT_WAIT_TIME);
		//emailField.sendKeys(email);
	}

	public void entertelephoneNumber(String tele) {
		elementUtils.typeTextIntoElement(telephoneField, tele, commonUtils.EXPLICIT_WAIT_TIME);
		//telephoneField.sendKeys(tele);
	}

	public void enterPassword(String password) {
		elementUtils.typeTextIntoElement(passwordField, password, commonUtils.EXPLICIT_WAIT_TIME);
		//passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPass) {
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPass, commonUtils.EXPLICIT_WAIT_TIME);
		//confirmPasswordField.sendKeys(confirmPass);
	}

	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyoptions, commonUtils.EXPLICIT_WAIT_TIME);
		//privacyPolicyoptions.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, commonUtils.EXPLICIT_WAIT_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void selectNewsLetter() {
		elementUtils.clickOnElement(newsLetter, commonUtils.EXPLICIT_WAIT_TIME);
		//newsLetter.click();

	}

	public String getWarningMsg() {
		return elementUtils.getTextFromElement(warningMsg, commonUtils.EXPLICIT_WAIT_TIME);
		//return warningMsg.getText();

	}

	public String getFirstNameWarningMsg() {
		return elementUtils.getTextFromElement(firstNameWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return firstNameWarning.getText();

	}

	public String getLastNameWarningMsg() {
		return elementUtils.getTextFromElement(lastNameWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return lastNameWarning.getText();

	}

	public String getEmailWarningMsg() {
		return elementUtils.getTextFromElement(EmailWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return EmailWarning.getText();

	}

	public String gettelephoneWarningMsg() {
		return elementUtils.getTextFromElement(telephoneWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return telephoneWarning.getText();

	}

	public String getPasswordWarningMsg() {
		return elementUtils.getTextFromElement(passwordeWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return passwordeWarning.getText();

	}

	public String getPrivacyWarningMsg() {
		return elementUtils.getTextFromElement(privacyWarningMsg, commonUtils.EXPLICIT_WAIT_TIME);
		//return privacyWarningMsg.getText();

	}
}
