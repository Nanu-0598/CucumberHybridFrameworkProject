package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {

	WebDriver driver;
	private RegisterPage register;
	private AccountSuccessPage account;
	
	
	@Given("User navigates to Register Page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		register = home.clickOnRegisterOption();
	}

	@When("User enteres the details into below fields")
	public void user_enteres_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
			register.enterFirstNameText(dataMap.get("firstName"));
			register.enterLastNameText(dataMap.get("LastName"));
			register.enterEmailAddress(getRandomEmail());
			register.entertelephoneNumber(dataMap.get("telephone"));
			register.enterPassword(dataMap.get("password"));
			register.enterConfirmPassword(dataMap.get("password"));
		}
	
	@When("User enteres the details into below fields with duplicate email")
	public void user_enteres_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		register.enterFirstNameText(dataMap.get("firstName"));
		register.enterLastNameText(dataMap.get("LastName"));
		register.enterEmailAddress(dataMap.get("email"));
		register.entertelephoneNumber(dataMap.get("telephone"));
		register.enterPassword(dataMap.get("password"));
		register.enterConfirmPassword(dataMap.get("password"));
	}
	
	
	private String getRandomEmail() {
        String randomString = getRandomString(10);
        long timeStamp = new Date().getTime();
        return randomString + timeStamp + "@gmail.com";
    }

    private String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		register.selectPrivacyPolicy();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		account = register.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!",account.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		register.selectNewsLetter();
	}

	@Then("User account should get warning about duplicate email")
	public void user_account_should_get_warning_about_duplicate_email() {
		Assert.assertEquals("Warning: E-Mail Address is already registered!", register.getWarningMsg());
	}

	@When("User does enteres any details into fields")
	public void user_does_enteres_any_details_into_fields() {
		register.enterFirstNameText("");
		register.enterLastNameText("");
		register.enterEmailAddress("");
		register.entertelephoneNumber("");
		register.enterPassword("");
		register.enterConfirmPassword("");
	}

	@Then("User account should get warning about mandatory fields")
	public void user_account_should_get_warning_about_mandatory_fields() {
		Assert.assertTrue(register.getPrivacyWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals(register.getFirstNameWarningMsg(),"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(register.getLastNameWarningMsg(),"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(register.getEmailWarningMsg(),"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(register.gettelephoneWarningMsg(),"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(register.getPasswordWarningMsg(),"Password must be between 4 and 20 characters!");
	}
}
