package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ProductInfoPageTest extends BaseTest{

	@BeforeClass
	public void productPageSetup() {
		accountPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@Description("Product Header Test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void productHeaderTest() {
     searchResultPage = accountPage.doSearch("Macbook");	
     productInfoPage=searchResultPage.selectProduct("MacBook Pro");
     Assert.assertEquals(productInfoPage.getProductHeader(), Constants.PRODUCT_HEADER);
	}
	
	@Description("Product Image Count Test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void productImageCountTest() {
	     searchResultPage = accountPage.doSearch("iMac");	
	     productInfoPage=searchResultPage.selectProduct("iMac");
	     Assert.assertEquals(productInfoPage.getImageCount(), Constants.IMAC_IMAGE_COUNT);
	     
	}
	
	
	@Description("Product Information Details Test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void productInfoTest() {
		 searchResultPage = accountPage.doSearch("Macbook");	
	     productInfoPage=searchResultPage.selectProduct("MacBook Pro");
	     Map<String, String> productMap = productInfoPage.getProductInfo();
//	     productMap.forEach((k,v)->System.out.println(k+" : "+v));
		softAssert.assertEquals(productMap.get("Product Main Proce ").trim(), "$2,000.00");
		softAssert.assertEquals(productMap.get("Product Ext Price ").trim(), "$2,000.00");
		softAssert.assertEquals(productMap.get("Brand").trim(), "Apple");
        softAssert.assertAll();
		 
	}
	
	
	
	
	
	
}
