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

public class AbstractPage {
	public WebDriver driver;
	public Actions action;
	public WebElement element;
	public By byXpath;
	public WebDriverWait waitExplicit;
	public long longTimeout = 30;
	public Select select;
	
	public AbstractPage(WebDriver localDriver) {
		driver = localDriver;
	}

	public void openURL(String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}
	
	
	public void back() {
		driver.navigate().back();
	}
	
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		driver.switchTo().alert().dismiss(); 
	}
	
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
		
	}
	
	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
		
	}
	
	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	
	public List <WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	
	public By byXpathLocator (String locator) {
		return By.xpath(locator);
	}
	
	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
		
	}
	
	
	public String getTextElement(String locator) {
		return findElementByXpath(locator).getText();	
	}
	
	public void sendKeyToElement (String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
		
	}
	
	
	public void selectItemInDropdown(String locator, String valueItem ) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		
	}
	
	
	
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();			
	}
	
	public String getAttributeElement (String locator, String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}
	
	
	public boolean isElementIsDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}
	
	public void hoverMouseToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	
	
	public void doubleClickToElement (String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
	
	}
	
	public void waitToElementDisplayed(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait (driver,longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	
	public void waitToElementClickable(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait (driver,longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
	
	
}
