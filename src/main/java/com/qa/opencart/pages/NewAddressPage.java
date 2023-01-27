package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class NewAddressPage extends DriverFactory {

	ElementUtil eleUtil;

	public NewAddressPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	private By addressAddedMSG=By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By newAddressPageHeader = By.xpath("//div[@id='content']/h2");
	private By firstName = By.id("input-firstname");
	private By lastLame = By.id("input-lastname");
	private By company = By.id("input-company");
	private By addressOne = By.id("input-address-1");
	private By addressTwo = By.id("input-address-2");
	private By city = By.id("input-city");
	private By postCode = By.id("input-postcode");
	private By country = By.id("input-country");
	private By zone = By.id("input-zone");
	private By defaultYes = By.xpath("//input[@value=1]");
	private By defaultNo = By.xpath("//input[@value=0]");

	private By continueBtn = By.xpath("//input[@value='Continue']");

	/**
	 * This method is used to get New Address Page Title
	 * 
	 * @return this method returns New Address Page Title
	 */
	@Step("Getting New Address Page Title")
	public String getNewAddressPageTitle() {
//	return driver.getTitle();	
		return eleUtil.doGetTitle(Constants.NEW_ADDRESS_PAGE_TITLE_FRACTION, 10);
	}

	/**
	 * This method is used to get New Address Page Header
	 * 
	 * @return this method returns New Address Page Header
	 */
	@Step("Getting New Address Page Header")
	public String getNewAddressPageHeader() {
		return eleUtil.doGetText(newAddressPageHeader);

	}
	
	
	/**
	 * This method is used to get success address added message
	 * @return this method returns Object of New Address Page
	 */
	@Step("get Address Added Success MSG")
	public String getAddressAddedSuccessMSG() {
		

		return eleUtil.doGetText(addressAddedMSG);
	}

	/**
	 * This method is used to add data in new address page
	 * 
	 * @return this method returns Success msg of add address
	 */
	@Step("Adding new address details")
	public String AddNewAddress(String fName, String lName, String compny, String add1, String add2,
			String cty, String postCode, String count, String state, String def) {
		eleUtil.doSendKeys(firstName, fName);
		eleUtil.doSendKeys(lastLame, lName);
		eleUtil.doSendKeys(company, compny);
		eleUtil.doSendKeys(addressOne, add1);
		eleUtil.doSendKeys(addressTwo, add2);
		eleUtil.doSendKeys(city, cty);
		eleUtil.doSendKeys(this.postCode, postCode);
		eleUtil.doSelectDropDownByVisibleText(country, count);
		eleUtil.doSelectDropDownByVisibleText(zone, state);

		if (def.equals("Yes")) {
			eleUtil.doClick(defaultYes);

		} else {
			eleUtil.doClick(defaultNo);

		}
		eleUtil.doClick(continueBtn);
		return getAddressAddedSuccessMSG();

	}

}
