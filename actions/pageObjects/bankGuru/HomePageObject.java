package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.bankGuru.HomePageUI;

public class HomePageObject extends AbstractPages {
	WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public NewCustomerPageObject openNewCustomerPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitToElementInvisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.WELCOME_MESSAGE);
	}

}