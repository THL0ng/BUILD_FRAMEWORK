package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class PageGeneratorManager {
	
	
	// CẤP PHÁT VIỆC KHỞI TẠO ĐỐI TƯỢNG CHO HOME PAGE
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject (driver);
	}
	
	// CẤP PHÁT VIỆC KHỞI TẠO ĐỐI TƯỢNG CHO REGISTER PAGE
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject (driver);
	}

	// CẤP PHÁT VIỆC KHỞI TẠO ĐỐI TƯỢNG CHO LOGIN PAGE	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject (driver);
	}
}
  