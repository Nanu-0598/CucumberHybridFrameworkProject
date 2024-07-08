package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	private SearchResultsPage search;
	
	@Given("user Opens the Applicaitons")
	public void user_opens_the_applicaitons() {
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid products {string} into Search box field")
	public void user_enters_valid_products_into_search_box_field(String validProduct) {
		HomePage home = new HomePage(driver);
		home.enterSearchProductInSearchField(validProduct);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		HomePage home = new HomePage(driver);
		search = home.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(search.isValidProductDisplayed());
	}

	@When("User enters invalid products {string} into Search box field")
	public void user_enters_invalid_products_into_search_box_field(String invalidProduct) {
		HomePage home = new HomePage(driver);
		home.enterSearchProductInSearchField(invalidProduct);
	}

	@Then("User should get a message as no product matching")
	public void user_should_get_a_message_as_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.", search.getNoProductWarningMsg());
	}

	@When("User does not enter any products into Search box field")
	public void user_does_not_enter_any_products_into_Search_box_field() {
		// intentionally kept blank
	}

}
