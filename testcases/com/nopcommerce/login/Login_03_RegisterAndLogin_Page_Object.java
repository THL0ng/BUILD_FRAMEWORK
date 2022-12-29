package com.nopcommerce.login;

import org.testng.annotations.Test;
import commons.AbstractPages;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_03_RegisterAndLogin_Page_Object extends AbstractPages {
	private WebDriver driver;
	private String email, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private Object registerSuccessMsg;
	
	

	@BeforeTest
	public void beforeTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\libraries\\chromedriver.exe");

		driver = new ChromeDriver();
		openURL(driver, "https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
		
		homePage = new HomePageObject (driver);
		
	}

	@Test
	public void TC_01_RegisterToSystem() {
		// Home Page: Click to register link --> register page
		registerPage = homePage.clickToRegisterLink();

		// Click male radio button
		registerPage.clickToMaleRadio();

		// Input to Firstname textbox
		registerPage.inputToFirstNameTextbox("shen");

		// Input to Lastname textbox
		registerPage.inputToLastNameTextbox("long");

		// Select item in day
		registerPage.selectDayDropdown("8");

		// Select item in Month
		registerPage.selectMonthDropdown("August");

		// Select item in Year
		registerPage.selectYearDropdown("1988");

		// Input to Email textbox
		registerPage.inputToEmailTextbox(email);

		// Input to Company textbox
		registerPage.inputToCompanyextbox("Auto channel");

		// Input to Password textbox
		registerPage.inputToPasswordTextbox(password);

		// Input to Confirm Password textbox
		registerPage.inputToConfirmPasswordTextbox(password);

		// Click to Register button
		registerPage.clickToRegisterButton();

		// Verify registered success
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		

		// Logout to system --> Home Page
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_02_LoginToSystem() {
		// Click Login Link--> Login Page
		loginPage = homePage.clickToLoginlink();

		// input to Email textbox
		loginPage.inputToEmailTextbox(email);

		// input to password textbox
		loginPage.inputToPasswordTextBox(password);

		// Click to Login Button--> Home Page
		homePage = loginPage.clickToLoginButton();

		// Verify My account link displayed
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterTest
	public void afterTest() {
	}

	public int randowmNumber() {
		Random Rand = new Random();
		return Rand.nextInt(5000);
	}

}
