package pageObjects.nopCommerce;
import org.openqa.selenium.WebDriver;
import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.HomePageUI; 

public class HomePageObject extends AbstractPages {
	private WebDriver driver;
	
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
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementIsDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}
	
	// HÀM KHỞI TẠO
	public HomePageObject (WebDriver _driver ) {
		driver = _driver;
	}

	;

}
