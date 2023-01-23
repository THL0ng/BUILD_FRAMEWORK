package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.DesktopsPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_14_Sort_Asc_And_Desc extends AbstractTest  {
	private WebDriver driver;
	private HomePageObject homePage;
	private DesktopsPageObject desktopPage;
	
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getHomePage(driver);	
		
		
	  } 
	
  @Test
  public void TC_01_Sort_Ascending() {
	  homePage.openHeaderSubMenuPageByName(driver, "Computers", "Desktops");
	  desktopPage = PageGeneratorManager.getDesktopsPage(driver);
	  
	  // A-Z: ASCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: A to Z");
	  desktopPage.sleepInSecond(2);
	  // VERIFY
	  verifyTrue(desktopPage.isNameDataSortedAscending(driver));
	  
	  // Z-A : DESCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: Z to A");
	  desktopPage.sleepInSecond(2);

	  // VERIFY
	  verifyTrue(desktopPage.isNameDataSortedDescending(driver));
	  
  }
  
  @Test
  public void TC_02_Sort_Price() { 
	  desktopPage.openHeaderSubMenuPageByName(driver, "Computers", "Desktops");
	  
	  // Price: Ascending
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: Low to High");
	  desktopPage.sleepInSecond(2);
	  
	  // VERIFY
	  verifyTrue(desktopPage.isPriceSortedAscending(driver));
	  
	  // Price: DESCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: High to Low");
	  desktopPage.sleepInSecond(2);
	  
	  // VERIFY
	  verifyTrue(desktopPage.isPriceSortedDescending(driver));
  }
  

  
  @AfterTest
  public void afterTest() {
	  closeBrowserAndDriver(driver);
  }

 
}
