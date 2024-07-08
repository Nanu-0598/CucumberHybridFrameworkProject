package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;

public class Login {

	WebDriver driver;
	private LoginPage login;
	private AccountPage account;
	
	
	
	@Given("User has navigate to login page")
	public void User_has_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		login = homepage.clickOnLoginButton();
	}

	@When("^User has entered valid email address (.+) into the email field$")
	public void user_has_entered_valid_email_address_into_the_email_field(String emailText) {
		login.enterEmailAddress(emailText);
	}

	@When("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String password) {
		login.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		account = login.clickOnLoginButton();
	}

	@Then("User should get login succesfully")
	public void user_should_get_login_succesfully() {
		Assert.assertTrue(account.editYourAccountInfo());
	}

	@When("User has entered invalid email address into the email field")
	public void user_has_entered_invalid_email_address_into_the_email_field() {
		commonUtils utils = new commonUtils();
		login.enterEmailAddress(utils.getEmailWithTimeStamp());
	}

	@When("User has entered invalid password = {string} into password field")
	public void user_has_entered_invalid_password_into_password_field(String pass) {
		login.enterPassword(pass);
	}

	@Then("User should error message about credentials mismatch")
	public void user_should_error_message_about_credentials_mismatch() {
		Assert.assertEquals(login.warningMsgtext(), ("Warning: No match for E-Mail Address and/or Password."));
	}

	@Then("User should get error message about password mismatch")
	public void user_get_should_error_message_about_password_mismatch() {
	}

	@Then("User should get error message about email id is wrong")
	public void user_should_error_message_about_email_id_is_wrong() {
	}

	@When("User does not entered valid email address into the email field")
	public void user_does_not_entered_valid_email_address_into_the_email_field() {
		login.enterEmailAddress("");
	}

	@When("User does not entered valid password into password field")
	public void user_does_not_entered_valid_password_into_password_field() {
		login.enterPassword("");
	}

	@Then("User should get Warning message")
	public void user_should_get_warning_message() {
	}

}
