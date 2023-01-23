package pageObjects.nopCommerce;
import org.openqa.selenium.WebDriver;
import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.HomePageUI; 

public class HomePageObject extends AbstractPages {
	private WebDriver driver;
	
	// HÀM KHỞI TẠO
		public HomePageObject (WebDriver _driver ) {
			driver = _driver;
		}
	
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginlink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementClickable(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.HEADER_MY_ACCOUNT_LINK);
		
	}
	
	

	public FooterMyAccountPageObject openFooterMyAccountPage() {
		waitToElementClickable(driver, HomePageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, HomePageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);	
		}

	public FooterSearchPageObject openFooterSearchPage() {
		waitToElementClickable(driver, HomePageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, HomePageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getFooterSearchPage(driver);
	}

	;

}
