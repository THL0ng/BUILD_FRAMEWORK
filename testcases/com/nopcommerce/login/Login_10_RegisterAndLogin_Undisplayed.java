package com.nopcommerce.login;
import org.testng.annotations.Test;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_10_RegisterAndLogin_Undisplayed extends AbstractTest  {
	private WebDriver driver;
	private String email, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName ) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);	
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test(description = "Check element displayed")
  public void TC_01_CheckDisplayed() {
	  registerPage = homePage.clickToRegisterLink();
	  
	  // Firstname textbox displayed
	  Assert.assertTrue(registerPage.isFirstnameTextboxDisplayed());

  }
  
  @Test
  public void TC_02_CheckUndisplayed_In_DOM() { 
	  
	 
	  // Request verification token undisplayed ( Có trong DOM)
	  registerPage.isRequestVerifyTokenTextboxUndisplayed();
	  Assert.assertTrue(registerPage.isRequestVerifyTokenTextboxUndisplayed());
	  Assert.assertFalse(registerPage.isRequestVerifyTokenTextboxdisplayed());

	 
  }
  
  @Test
  public void TC_03_CheckUndisplayed_Not_In_DOM() {
	 
	  // Register button undisplayed ( Ko có trong DOM)
	  Assert.assertTrue(registerPage.isRegisterButtonUndisplayed());
  }
 
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}