package com.nopcommerce.common;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Common_01_RegisterToSystem extends AbstractTest  {
	private WebDriver driver;
	public static String email, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	
	@Parameters ({"browser"})
	@BeforeSuite
	  public void createNewUser(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);	
		email = "corona" + randomNumber() + "@hotmail.com";
		password = "coronavirus";
		
		registerPage = homePage.clickToRegisterLink();
		  registerPage = new RegisterPageObject(driver);
		  registerPage.clickToMaleRadio();
		  registerPage.inputToFirstNameTextbox("shen");
		  registerPage.inputToLastNameTextbox("long");
		  registerPage.selectDayDropdown("8");	  	
		  registerPage.selectMonthDropdown("August");	  	
		  registerPage.selectYearDropdown("1988");  
		  registerPage.inputToEmailTextbox(email);  
		  registerPage.inputToCompanyextbox("Auto channel");
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  registerPage.clickToRegisterButton();
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage() , "Your registration completed");		  
		  driver.quit();
		  
	  } 
  
}