package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPages {
	public WebDriver driver;
	public Actions action;
	public WebElement element;
	public By byXpath;
	public WebDriverWait waitExplicit;
	public long longTimeout = 30;
	public Select select;
	
	

	public void openURL(WebDriver driver, String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss(); 
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
		
	}
	
	public void sendKeyToAlert(WebDriver driver , String value) {
		driver.switchTo().alert().sendKeys(value);
		
	}
	
	public WebElement findElementByXpath(WebDriver driver , String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	
	public List <WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	
	public By byXpathLocator (String locator) {
		return By.xpath(locator);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).click();
		
	}
	
	
	public String getTextElement(WebDriver driver , String locator) {
		return findElementByXpath(driver, locator).getText();	
	}
	
	public void sendKeyToElement (WebDriver driver , String locator, String value) {
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
		
		
	}
	
	
	public void selectItemInDropdown(WebDriver driver,String locator, String valueItem ) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		
	}
	
	
	
	public int countElementNumber(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();			
	}
	
	public String getAttributeElement (WebDriver driver, String locator, String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}
	
	
	public boolean isElementIsDisplayed(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).perform();
	}
	
	
	public void doubleClickToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
	
	}
	
	public void waitToElementDisplayed(WebDriver driver, String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait (driver,longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementClickable(WebDriver driver, String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait (driver,longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	
}
