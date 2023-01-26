package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.data.bankguru.payment;
import commons.AbstractTest;
import pageObjects.bankGuru.BalanceEnquiryPageObject;
import pageObjects.bankGuru.DeleteAccountPageObject;
import pageObjects.bankGuru.DeleteCustomerPageObject;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.EditAccountPageObject;
import pageObjects.bankGuru.EditCustomerPageObject;
import pageObjects.bankGuru.FundTransferPageObject;
import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.NewAccountPageObject;
import pageObjects.bankGuru.NewCustomerPageObject;
import pageObjects.bankGuru.RegisterPageObject;
import pageObjects.bankGuru.WithdrawalPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_16_Data_Java_Class extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	DepositPageObject depositPage;
	WithdrawalPageObject withdrawPage;
	FundTransferPageObject fundTranferPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	DeleteAccountPageObject deleteAccountPage;
	DeleteCustomerPageObject deleteCustomerPage;

	String email,password, customerID;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
	String accountTypeSaving, accountTypeCurrent,firstAccountID,secondAccountID;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		email = "shenlong" + randomNumber() + "@gmail.com";

		
		// Input data
		editAddress = "456 AAA";
		editCity = "NEWYORK";
		editState = "LONDON";
		editPin = "555666";
		editPhone = "0906888777";
		editEmail = "shenlong" + randomNumber() + "@gmail.com";
		
		accountTypeSaving = "Savings";
		accountTypeCurrent = "Current";

		loginPage = pageObjects.bankGuru.PageGeneratorManager.getLoginPage(driver);

		String loginPageUrl = loginPage.getLoginPageUrl();

		// pre-condition
		registerPage = loginPage.clickToHereLink();

		registerPage.inputToEmailTextbox(email);

		registerPage.clickToSubmitButton();

		String userID = registerPage.getUserIDValue();
		password = registerPage.getPasswordValue();

		loginPage = registerPage.openLoginPage(loginPageUrl);
	
		homePage = loginPage.loginAsUser(userID,password);
		verifyTrue(homePage.isWelcomeMessageDisplayed());

	}

	@Test(description = "Create new customer and get customer ID")
	public void Payment_01_CreateNewCustomer() {
		log.info("NewCustomer_01 - Step 01: Open 'New Customer' page");
		homePage.openBankGuruPage(driver, "New Customer");
		newCustomerPage = pageObjects.bankGuru.PageGeneratorManager.getNewCustomerPage(driver);

		log.info("NewCustomer_01 - Step 02: Input to 'Customer Name' fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", payment.NewCustomer.CUSTOMER_NAME);
		
		log.info("NewCustomer_01 - Step 03: Click to 'Male' radio button");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		
		log.info("NewCustomer_01 - Step 04: Input to 'dateOfBirth' fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", payment.NewCustomer.DATE_OF_BIRTH);
			
		log.info("NewCustomer_01 - Step 05: Input to 'Address' textarea");
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", payment.NewCustomer.ADDRESS);
		
		log.info("NewCustomer_01 - Step 06: Input to 'City' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", payment.NewCustomer.CITY);
		
		log.info("NewCustomer_01 - Step 06: Input to 'City' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", payment.NewCustomer.STATE);
		
		log.info("NewCustomer_01 - Step 07: Input to 'Pin' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", payment.NewCustomer.PIN);
		
		log.info("NewCustomer_01 - Step 08: Input to 'Phone' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", payment.NewCustomer.PHONE);
		
		log.info("NewCustomer_01 - Step 09: Input to 'Email' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		
		log.info("NewCustomer_01 - Step 10: Input to 'Password' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);
		
		log.info("NewCustomer_01 - Step 11: Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("NewCustomer_01 - Step 12: Verify 'Customer Registered Successfully!!!' text displayed");
		verifyEquals(newCustomerPage.getBankGuruHeaderText(driver), "Customer Registered Successfully!!!");

		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Customer Name"), payment.NewCustomer.CUSTOMER_NAME);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Gender"), payment.NewCustomer.GENDER);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Birthdate"), payment.NewCustomer.DATE_OF_BIRTH);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Address"), payment.NewCustomer.ADDRESS);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "City"), payment.NewCustomer.CITY);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "State"), payment.NewCustomer.STATE);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Pin"), payment.NewCustomer.PIN);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Mobile No."), payment.NewCustomer.PHONE);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Email"), email);

		// GET CUSTOMER ID
		customerID = newCustomerPage.getBankGuruRowValueByRowName(driver, "Customer ID");

	}


	@AfterTest
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}