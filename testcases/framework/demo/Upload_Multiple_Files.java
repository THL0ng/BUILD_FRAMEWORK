package framework.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Upload_Multiple_Files {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String seleniumFileName = "Selenium.jpg";
	String appiumFileName = "Appium.jpeg";
	String specflowFileName = "Specflow.jpg";
	String testComplete = "TestComplete.jpg";
	
	String[] fileName = {seleniumFileName,appiumFileName,specflowFileName,testComplete};

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Sendkeys() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Upload 1 file
		uploadMultipleFiles(seleniumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 2 file
		uploadMultipleFiles(specflowFileName, appiumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 3 file
		uploadMultipleFiles(seleniumFileName, specflowFileName, appiumFileName);
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());
		
		driver.navigate().refresh();

		// Uload 4 file
		uploadMultipleFiles(fileName);
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + testComplete + "')]")).isDisplayed());



	}

	public void uploadMultipleFiles(String... fileNames) {
		String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		// Remove khoảng trắng/kí tự xuống dòng/kí tự tab ở 2 đầu chuỗi
		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(fullFileName);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}