package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
@Listeners(TestAllureListener.class)
public class LoginPageNegativeTest extends BaseTest
{
	@DataProvider
	public Object[][] loginNegativeTestData() {
		return	new Object [][] {
			{"pankaj@gmail.com","MacBook Pro"},
			{"Hel@lloo.com","iMac"},

			{"Hellottt@India.com","Samsung SyncMaster 941BW"},

			{"Panak@1263@gmail.com","Apple Cinema 30\""}

		};
		}
	
    @Description("Login Page Negative Test with invalid credentials")
	@Test(priority = 1,dataProvider ="loginNegativeTestData" )
	public void loginNegativeTest(String un,String pwd) {
		Assert.assertFalse(loginPage.doLoginWrongCredentials(un, pwd));
	}
	
	
}
