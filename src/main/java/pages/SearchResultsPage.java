package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementsUtils;
import utils.commonUtils;

public class SearchResultsPage {
	
WebDriver driver;
private ElementsUtils elementUtils;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementsUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductWarning;
	
	
	
	
	
	public boolean isValidProductDisplayed() {
		//return validProduct.isDisplayed();
		return elementUtils.displayStatusOfElement(validProduct, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String getNoProductWarningMsg() {
		return elementUtils.getTextFromElement(noProductWarning, commonUtils.EXPLICIT_WAIT_TIME);
		//return noProductWarning.getText();
	}

}
