package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.liveGuru.MyDashBoardUI;

public class MyDashBoardPageObject  extends AbstractPages{
	private WebDriver driver;
	
	public MyDashBoardPageObject (WebDriver driver) {
		this.driver = driver ; 
		
	}
	public boolean isFullnameOrEmailTextDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(MyDashBoardUI.EMAIL_PASSWORD_TEXT,errorMessage ));
		return isElementIsDisplayed(driver, String.format(MyDashBoardUI.EMAIL_PASSWORD_TEXT,errorMessage ));
	}
	
	
}