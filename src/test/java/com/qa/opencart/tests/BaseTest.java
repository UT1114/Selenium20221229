package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.AddressBookPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.NewAddressPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {

	DriverFactory df;
	LoginPage loginPage;
	Properties prop;
	WebDriver driver;
	AccountsPage accountPage;
	SearchResultPage searchResultPage;
	ProductInfoPage productInfoPage;
	SoftAssert softAssert;
	RegistrationPage registrationPage;
	AddressBookPage addressBookPage;
	NewAddressPage newAddressPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop=df.intializeProp();
		driver=df.intializeDriver(prop);
		loginPage=new LoginPage(driver);
        softAssert=new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
	
}
