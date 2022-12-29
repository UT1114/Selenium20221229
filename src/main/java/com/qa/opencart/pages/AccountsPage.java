package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage extends DriverFactory {

	private ElementUtil eleUtil;

	public AccountsPage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
	}

	private By header = By.cssSelector("div#logo a");
	private By accontSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink = By.linkText("Logout");

	@Step("Getting account page title....")
	public String getAccPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	@Step("Getting account page header....")
	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}

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

}
