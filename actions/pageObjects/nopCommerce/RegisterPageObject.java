package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	private WebDriver driver;

	public void clickToMaleRadio() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);

	}

	public void selectDayDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.DATE_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DATE_DROPDOWN, expectedItem);
	}

	public void selectMonthDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, expectedItem);		
	}

	public void selectYearDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, expectedItem);				
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);		
	}

	public void inputToCompanyextbox(String companyValue) {
		waitToElementDisplayed(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyValue);		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);				
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);	
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);		
	}

	public Object getRegisterSuccessMessage() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	// H??M KH???I T???O
	public RegisterPageObject (WebDriver _driver ) {
			driver = _driver;
		}

}
