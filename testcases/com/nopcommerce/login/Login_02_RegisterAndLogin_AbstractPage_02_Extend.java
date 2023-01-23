package com.nopcommerce.login;
import org.testng.annotations.Test;
import commons.AbstractPages;
import org.testng.annotations.BeforeTest;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin_AbstractPage_02_Extend extends AbstractPages {
	private WebDriver driver;
	private String email, password;
	
	

	@BeforeTest
	public void beforeTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\libraries\\chromedriver.exe");

		
		driver = new ChromeDriver();
		openUrl(driver, "https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		clickToElement(driver,"//a[@class='ico-register']");

		// click male radio button
		clickToElement(driver,"//input[@id='gender-male']");
			
		sendkeyToElement(driver,"//input[@id='FirstName']","corona");
		
		sendkeyToElement(driver,"//input[@id='LastName']","virus");

		
		selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']", "1");
	
		selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']", "February");
		
		selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']", "1986");

		

		sendkeyToElement(driver,"//input[@id='Email']", email);
		
		sendkeyToElement(driver,"//input[@id='Company']", "corona virus");

		sendkeyToElement(driver,"//input[@id='Password']", password);
		sendkeyToElement(driver,"//input[@id='ConfirmPassword']", password);

		
		clickToElement(driver,"//button[@id='register-button']");

		String resultText = getTextlement(driver,"//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		
		clickToElement(driver,"//a[@class='ico-logout']");
		
		
		
	}

	@Test
	public void TC_02_LoginToSystem() {
		clickToElement(driver,"//a[@class='ico-login']");
		

		sendkeyToElement(driver,"//input[@id='Email']", email);

		sendkeyToElement(driver,"//input[@id='Password']", password);

		clickToElement(driver,"//button[@class='button-1 login-button']");
		Assert.assertTrue(isElementDisplayed(driver,"//a[@class='ico-account']"));

	}

	@AfterTest
	public void afterTest() {
	}

	public int randowmNumber() {
		Random Rand = new Random();
		return Rand.nextInt(5000);
	}

}
