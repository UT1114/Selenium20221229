package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

	@Description("login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE);
		;
	}

	@Description("login Page Url Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, dependsOnMethods = "loginPageTitleTest")
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageURL());
	}

	@Description("forgot Password Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@Description("Register Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Description("Login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void loginTest() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountPage.getAccPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}

}
