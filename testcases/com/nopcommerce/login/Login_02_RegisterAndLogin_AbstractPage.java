package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin_AbstractPage extends AbstractTest {
	private WebDriver driver;
	private Select select;
	private String email, password;
	private AbstractPage abstractPage;

	@BeforeTest
	public void beforeTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\libraries\\chromedriver.exe");

		
		driver = new ChromeDriver();
		
		abstractPage = new AbstractPage(driver);

		abstractPage.openURL("https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		abstractPage.clickToElement("//a[@class='ico-register']");

		// click male radio button
		abstractPage.clickToElement("//input[@id='gender-male']");
			
		abstractPage.sendKeyToElement("//input[@id='FirstName']","corona");
		
		abstractPage.sendKeyToElement("//input[@id='LastName']","virus");

		
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "1");
	
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");
		
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1986");

		

		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		
		abstractPage.sendKeyToElement("//input[@id='Company']", "corona virus");

		abstractPage.sendKeyToElement("//input[@id='Password']", password);
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password);

		
		abstractPage.clickToElement("//button[@id='register-button']");

		String resultText = abstractPage.getTextElement("//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		
		abstractPage.clickToElement("//a[@class='ico-logout']");
		
		
		
	}

	@Test
	public void TC_02_LoginToSystem() {
		abstractPage.clickToElement("//a[@class='ico-login']");
		

		abstractPage.sendKeyToElement("//input[@id='Email']", email);

		abstractPage.sendKeyToElement("//input[@id='Password']", password);

		abstractPage.clickToElement("//button[@class='button-1 login-button']");
		Assert.assertTrue(abstractPage.isElementIsDisplayed("//a[@class='ico-account']"));

	}

	@AfterTest
	public void afterTest() {
	}

	public int randowmNumber() {
		Random Rand = new Random();
		return Rand.nextInt(5000);
	}

}
