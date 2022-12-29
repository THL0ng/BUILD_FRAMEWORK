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
		openURL(driver, "https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		clickToElement(driver,"//a[@class='ico-register']");

		// click male radio button
		clickToElement(driver,"//input[@id='gender-male']");
			
		sendKeyToElement(driver,"//input[@id='FirstName']","corona");
		
		sendKeyToElement(driver,"//input[@id='LastName']","virus");

		
		selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']", "1");
	
		selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']", "February");
		
		selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']", "1986");

		

		sendKeyToElement(driver,"//input[@id='Email']", email);
		
		sendKeyToElement(driver,"//input[@id='Company']", "corona virus");

		sendKeyToElement(driver,"//input[@id='Password']", password);
		sendKeyToElement(driver,"//input[@id='ConfirmPassword']", password);

		
		clickToElement(driver,"//button[@id='register-button']");

		String resultText = getTextElement(driver,"//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		
		clickToElement(driver,"//a[@class='ico-logout']");
		
		
		
	}

	@Test
	public void TC_02_LoginToSystem() {
		clickToElement(driver,"//a[@class='ico-login']");
		

		sendKeyToElement(driver,"//input[@id='Email']", email);

		sendKeyToElement(driver,"//input[@id='Password']", password);

		clickToElement(driver,"//button[@class='button-1 login-button']");
		Assert.assertTrue(isElementIsDisplayed(driver,"//a[@class='ico-account']"));

	}

	@AfterTest
	public void afterTest() {
	}

	public int randowmNumber() {
		Random Rand = new Random();
		return Rand.nextInt(5000);
	}

}
