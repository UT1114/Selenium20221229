package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AddressBookPageTest extends BaseTest

{

	
	@BeforeClass
	public void addressPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		addressBookPage=accountPage.clickAddressLink();	
	}
	
	@Test(priority = 10)
	public void getAddressPageTitleTest() {
		String addresPageTitle = addressBookPage.getAddressBookPageTitle();
		Assert.assertEquals(addresPageTitle, Constants.ADDRESS_BOOK_PAGE_TITLE);
	}
	
	@Test(priority = 11)
	public void AddressPageHeaderTest() {
		Assert.assertEquals(addressBookPage.getAddressPageHeader(), Constants.ADDRESS_BOOK_PAGE_HEADER);
	}
	

	@Test(priority = 12)
	public void deleteAddressTest() {
		addressBookPage.deteteAddresses();
		//Assert.assertEquals(addressBookPage.deteteAddresses(), Constants.DELETE_ADDRESS_MESSG);
	}
	
	
	
}
