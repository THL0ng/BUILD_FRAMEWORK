package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.FooterNewProductPageUI;
import pageUIs.nopCommerce.FooterSearchPageUI;

public class FooterNewProductPageObject extends AbstractPages {
private WebDriver driver;
	
	public FooterNewProductPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public HomePageObject openHomePage() {
		waitToElementClickable(driver,FooterNewProductPageUI.HOME_PAGE_IMAGE);
		clickToElement(driver,FooterNewProductPageUI.HOME_PAGE_IMAGE);	
		return PageGeneratorManager.getHomePage(driver);
	}
	
	
}
