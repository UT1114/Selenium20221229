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
			{"panka@gmail.com","MacBook Pro"},
			{"Hel@llo.com","iMac"},

			{"Hellott@India.com","Samsung SyncMaster 941BW"},

			{"Panak@123@gmail.com","Apple Cinema 30\""}

		};
		}
	
    @Description("Login Page Negative Test with invalid credentials")
	@Test(priority = 1,dataProvider ="loginNegativeTestData" )
	public void loginNegativeTest(String un,String pwd) {
		Assert.assertTrue(loginPage.doLoginWrongCredentials(un, pwd));
	}
	
	
}
