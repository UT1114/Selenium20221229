package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;
import com.qa.opencart.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners(TestAllureListener.class)
public class AccountsPageTest extends BaseTest {

	@DataProvider
	public Object[][] searchData() {

		return new Object[][] { { "Macbook" }, { "Apple" }, { "Samsung" },

		};

	}

	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Description("Account Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void accountPageTitleTest() {
		String actualTitle = accountPage.getAccPageTitle();
		System.out.println("acount page title : " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Description("Account Page Header Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, enabled = true)
	public void accPageHeaderTest() {
		String header = accountPage.getAccountsPageHeader();
		System.out.println("account page header is: " + header);
		Assert.assertEquals(header, Constants.ACCOUNT_PAGE_HEADER,Errors.HEADER_ERROR_MESSG);
	}

	

	@Description("Logout Link Exist Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

	@Description("Account Page Section Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void accPageSectionTest() {
		List<String> actualAccSecList = accountPage.getAccountSecList();
		Assert.assertEquals(actualAccSecList, Constants.getExpAccSecList());
	}
	@Description("Product Search Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5, dataProvider = "searchData")
	public void searchTest(String productName) {
		searchResultPage = accountPage.doSearch(productName);
		Assert.assertTrue(searchResultPage.getProductSearchCount() > 0);

	}

	@DataProvider
	public Object[][] productSelectData() {
		return ExcelUtil.readExcelData(Constants.EXCEL_PRODUCTSEARCH_SHEET_NAME);

	}
	
	@Description("Select Product Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 6, dataProvider = "productSelectData")
	public void selectProductTest(String productName, String mainProduct) {
		searchResultPage = accountPage.doSearch(productName);
		productInfoPage = searchResultPage.selectProduct(mainProduct);
		Assert.assertEquals(productInfoPage.getProductHeader(), mainProduct);

	}

}
