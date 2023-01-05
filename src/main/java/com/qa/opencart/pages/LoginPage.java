package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends DriverFactory {


	private WebDriver driver;

	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);

		
		
	
	}

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@value='Login']");
	private By registerLink = By.linkText("Register");
	private By forgotPassword = By.linkText("Forgotten Password");
	private By errorMESG = By.cssSelector("div.alert.alert-danger.alert-dismissible ");
	

	/**
	 * This method is used to get title of the page
	 * 
	 * @return this method will return title of the page
	 */
	public String getPageTitle() {
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		// return eleUtil.waitForTitle(Constants.LOGIN_PAGE_TITLE,
		// Constants.DEFAULT_WAIT_TIME);
	}

	/**
	 * this method used to get login page URL
	 * 
	 * @return this method return login page URL
	 */
	@Step("Getting Login page url")
	public boolean getLoginPageURL() {
		return eleUtil.waitForURL(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);

	}

	/**
	 * this method used to identify forgot password link
	 * 
	 * @return method return forgot password link exist or not?
	 */
	@Step("Checking forgot password link exist or not")
	public boolean isForgotPasswordLinkExist() {
		// return driver.findElement(forgotPassword).isDisplayed();
		return eleUtil.doIsDisplayed(forgotPassword);
	}

	/**
	 * this method used to identify register link
	 * 
	 * @return method return register link exist or not?
	 */
	@Step("Checking register link exist or not")
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
	}

	@Step("Trying to login with username: {0} and password : {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("Login with : " + un + " : " + pwd);
		eleUtil.doSendKeys(emailId, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(login);
		System.out.println("Login success full");
		return new AccountsPage(driver);

	}

	/**
	 * 
	 * this method used to login with invalid credentials 
	 * @return This method return boolean value
	 */
	@Step("Trying to login with invalid username: {0} and invalid password : {1}")
	public boolean doLoginWrongCredentials(String un, String pwd) {
		System.out.println("Trying to login with :" + un + " : " + pwd);
		eleUtil.doSendKeys(emailId, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(login);
		String errMSGText = eleUtil.doGetText(errorMESG);
		System.out.println(errMSGText);
		if (errMSGText.contains(Constants.LOGIN_ERROR_MESG)) {
			System.out.println("Login not successful");
			return false;
		}
		return true;
	}
	
	
	/**
	 *  This method used to click on registration link
	 * @return It returns boolean value
	 */
	@Step("Cliking on registration Page link...")
	public RegistrationPage goToRegistrationPage() {
		eleUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	

}
