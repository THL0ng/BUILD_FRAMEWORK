package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.FooterMyAccountPageUI;
import pageUIs.nopCommerce.FooterNewProductPageUI;
import pageUIs.nopCommerce.FooterSearchPageUI;


public class FooterSearchPageObject extends AbstractPages {
	WebDriver driver;
	
	public FooterSearchPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
	
	public FooterNewProductPageObject openFooterNewProductPage () {
		waitToElementClickable(driver,FooterSearchPageUI.FOOTER_NEW_PRODUCT_LINK);
		clickToElement(driver,FooterSearchPageUI.FOOTER_NEW_PRODUCT_LINK);	
		return PageGeneratorManager.getFooterNewProductPage(driver);	

	}

}	
