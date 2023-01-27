package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.internal.Utils;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage extends DriverFactory {

	private ElementUtil eleUtil;
	WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	private By header = By.cssSelector("div#logo a");
	private By accontSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink = By.linkText("Logout");
	private By addressLink = By.linkText("Address Book");

	@Step("Getting account page title....")
	public String getAccPageTitle() {
		// System.out.println("Title is
		// :"+eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE,
		// Constants.DEFAULT_TIME_OUT));
		return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	/**
	 * This method is used to get account page header
	 * 
	 * @return This method return string account page header
	 */
	@Step("Getting account page header....")
	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}

	/**
	 * 
	 * @return this method return boolean value
	 */
	@Step("checking logout link exist or not")
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}

	@Step("Cliking logout button link")
	public void logout() {
		if (isLogoutLinkExist()) {
			eleUtil.doClick(logoutLink);

		}
	}

	@Step("Getting account sections list")
	public List<String> getAccountSecList() {
		List<WebElement> accSecList = eleUtil.waitForVisibilityOfElements(accontSections, 10);
		List<String> accSecValues = new ArrayList<String>();
		for (WebElement e : accSecList) {
			String text = e.getText();
			accSecValues.add(text);
		}
		return accSecValues;
	}

	@Step("Checking product search field exist or not")
	public boolean isSearchExists() {
		return eleUtil.doIsDisplayed(searchField);
	}

	@Step("Searching product : {0}")
	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching the product : " + productName);
		eleUtil.doSendKeys(searchField, productName);
		eleUtil.doClick(searchButton);
		return new SearchResultPage(driver);

	}

	/**
	 * This method is used to redirect Account page to addressBook Page
	 * 
	 * @return this method returns Address Book Page Object
	 */
	@Step("Click on Address Book Link ")
	public AddressBookPage clickAddressLink() {

		eleUtil.doClick(addressLink);
		
		return new AddressBookPage(driver);

	}

}
