package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class RegistrationPage {

	WebDriver driver;
	ElementUtil eleUtil;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPwd = By.id("input-confirm");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline']/input)[1]");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline']/input)[2]");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By successMesg = By.cssSelector("div#content h1");
	private By loguotBtn = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	 
     @Step("Getting registration page title...  ")
	public String getRegPageTitle() {
		return eleUtil.doGetTitle(Constants.REGISTRATION_PAGE_TITLE, 10);
	}

     
     @Step("Doing user registration with : First name ={0}, Last Name ={1}, Email ={2}, Telephone= {3}, Password={4}, Consent ={5}")
	public boolean accountRegistration(String firstName, String lastName, String email, String telephone, String password,
			String consent) {
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPwd, password);
		if (consent.equals("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);
        String text = eleUtil.doVisibilityOfElement(successMesg, 5).getText();
        if (text.contains(Constants.REGISTRATION_SUCCESS_MESSG)) {
        	eleUtil.doClick(loguotBtn);
        	eleUtil.doClick(registerLink);
        	return true;
        }
        else {
		return false;
        }
	}

}
