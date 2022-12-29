package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Listeners(TestAllureListener.class)
public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void setupRegistartionPage() {
		registrationPage = loginPage.goToRegistrationPage();

	}

	@Description("Registration Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void getRegPageTitleTest() {
		String regTitle = registrationPage.getRegPageTitle();
		Assert.assertEquals(regTitle, Constants.REGISTRATION_PAGE_TITLE);
	}
	
	private String getRandomMailId() {
		Random random = new Random();
		String mailId="PankajAutomation"+random.nextInt(2000)+"@gmail.com";
		return mailId;
	}
	

	@DataProvider
	public Object[][] getExcelData() {
		return ExcelUtil.readExcelData(Constants.EXCEL_SHEET_NAME);

	}
	@Description("New User Registration Test")
	@Severity(SeverityLevel.MINOR)
	@Test(dataProvider = "getExcelData")
	public void userRegistrationTest(String firstname,String ln,String telephone,String pwd,String subcribe) {
		Assert.assertTrue(registrationPage.accountRegistration(firstname, ln, getRandomMailId(),telephone,
				pwd, subcribe));
		
		
	}

}
