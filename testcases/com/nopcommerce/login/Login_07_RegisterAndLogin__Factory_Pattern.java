package com.nopcommerce.login;

import org.testng.annotations.Test;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_07_RegisterAndLogin__Factory_Pattern extends AbstractTest {
	private WebDriver driver;
	private String email, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private Object registerSuccessMsg;
	private DriverManager driverManager;
	
	public int randowmNumber() {
		Random Rand = new Random();
		return Rand.nextInt(5000);
	}

	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browserName) {
		
		//driver = getBrowserDriver(browserName);
		
		
		driverManager = DriverManagerFactory.getManager(browserName);
		driver = driverManager.getBrowserDriver();
		
		
		driver.get(GlobalConstants.DEV_URL);
		homePage = PageGeneratorManager.getHomePage(driver);
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	}


	@Test
	public void TC_01_RegisterToSystem() {		
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
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginlink();		
		loginPage.inputToEmailTextbox(email);		
		loginPage.inputToPasswordTextBox(password);	
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {

	}	
}
