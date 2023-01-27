package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class NewAddressPageTest extends BaseTest {
	@BeforeClass
	public void NewAddressPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		addressBookPage = accountPage.clickAddressLink();
		newAddressPage = addressBookPage.goNewAddressPage();

	}

	

	@Test(priority = 15)
	public void newAddressPageTitleTest() {

		System.out.println("New Address PAge title is " + newAddressPage.getNewAddressPageTitle());
		Assert.assertEquals(newAddressPage.getNewAddressPageTitle(), Constants.NEW_ADDRESS_PAGE_TITLE);
	}

	@Test(priority = 16)
	public void newAddressPageHeaderTest() {

		Assert.assertEquals(newAddressPage.getNewAddressPageHeader(), Constants.NEW_ADDRESS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] addressFieldsData() {

		return ExcelUtil.readExcelData(Constants.EXCEL_ADDRESS_SHEET_NAME);

	}
	
	
	@Test(priority = 17, dataProvider = "addressFieldsData")
	public void addNewAddressPageTest(String firstName, String lastName, String company, String addressOne,
			String addressTwo, String city, String postalCode, String country, String state, String def) {

		String msg = newAddressPage.AddNewAddress(firstName, lastName, company, addressOne, addressTwo, city, postalCode, country,
				state, def);
		Assert.assertEquals(msg, Constants.NEW_ADDRESS_ADDED_SUCCESS_MSG);
		addressBookPage.goNewAddressPage();

	}

}
