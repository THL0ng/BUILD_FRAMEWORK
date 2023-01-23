package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterToSystem;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;

import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Login_12_Register_ShareClassState extends AbstractTest  {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);		
		homePage = PageGeneratorManager.getHomePage(driver);	
		
		
		loginPage = homePage.clickToLoginlink();
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.email);
		loginPage.inputToPasswordTextBox(Common_01_RegisterToSystem.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  } 
	  
  @Test
  public void TC_01_ViewProduct() { 
	
  }
  
  
  @Test
  public void TC_02_Order() {
	  	 
  }
  
  @Test
  public void TC_03_Payment() {
	  
  }
  
  
  @AfterTest(alwaysRun = true)
  public void afterTest() {
	  closeBrowserAndDriver(driver);
	  
  }
  
  

}