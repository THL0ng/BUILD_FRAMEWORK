package com.nopcommerce.login;

import org.testng.annotations.Test;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_09_RegisterAndLogin__Dynamic_Locator extends AbstractTest {
	private WebDriver driver;
	private String email, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private Object registerSuccessMsg;
	private DriverManager driverManager;
	
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage; 
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
	
	
	@Test(description = "Only use incase less page")
	public void TC_03_Dynamic_less() {
		// Home Page -> My Account (Footer)
		myAccountPage = (FooterMyAccountPageObject) homePage.openFooterPageByName(driver, "My account");
		myAccountPage.sleepInSecond(2);

		// My Account -> Search
		searchPage = (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);

		// Search -> New products
		newProductPage = (FooterNewProductPageObject) searchPage.openFooterPageByName(driver, "New products");
		newProductPage.sleepInSecond(2);

		// New products -> Home page
		homePage = newProductPage.openHomePage(driver);
		homePage.sleepInSecond(2);

		// Home page -> Search
		searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);

		// Search -> My Account
		myAccountPage = (FooterMyAccountPageObject) searchPage.openFooterPageByName(driver, "My account");
		myAccountPage.sleepInSecond(2);

		// My Account -> New Products
		newProductPage = (FooterNewProductPageObject) myAccountPage.openFooterPageByName(driver, "New products");
		newProductPage.sleepInSecond(2);

		// New Product -> Search
		searchPage = (FooterSearchPageObject) newProductPage.openFooterPageByName(driver, "Search");
		searchPage.sleepInSecond(2);
	}

	@Test(description = "Only use incase more page")
	public void TC_04_Dynamic_More() {
		// New Product -> My Account (Footer)
		newProductPage.openFooterPagesByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		myAccountPage.sleepInSecond(2);

		// My Account -> Search
		myAccountPage.openFooterPagesByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);
		searchPage.sleepInSecond(2);

		// Search -> New products
		searchPage.openFooterPagesByName(driver, "New products");
		newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
		newProductPage.sleepInSecond(2);

		// New products -> Home page
		homePage = newProductPage.openHomePage(driver);
		homePage.sleepInSecond(2);

		// Home page -> Search
		homePage.openFooterPagesByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);
		searchPage.sleepInSecond(2);

		// Search -> My Account
		searchPage.openFooterPagesByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		myAccountPage.sleepInSecond(2);

		// My Account -> New Products
		myAccountPage.openFooterPagesByName(driver, "New products");
		newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
		newProductPage.sleepInSecond(2);

		// New Product -> Search
		newProductPage.openFooterPagesByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPage(driver);
		searchPage.sleepInSecond(2);
	}
		 
	@AfterTest
	public void afterTest() {
		

	}	
}
