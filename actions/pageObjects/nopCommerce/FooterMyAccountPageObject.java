package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.FooterMyAccountPageUI;
import pageUIs.nopCommerce.HomePageUI;

public class FooterMyAccountPageObject extends AbstractPages {
	WebDriver driver;
	
	public FooterMyAccountPageObject (WebDriver _driver) {
		driver = _driver;
		
	}
	
	public FooterSearchPageObject openFooterSearchPage() {
		waitToElementClickable(driver,FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, FooterMyAccountPageUI.FOOTER_SEARCH_LINK);	
		return PageGeneratorManager.getFooterSearchPage(driver);	
	}

	

}
