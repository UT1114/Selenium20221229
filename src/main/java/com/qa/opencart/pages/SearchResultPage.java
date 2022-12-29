package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class SearchResultPage {
	 WebDriver driver;
     ElementUtil eleUtil; 
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}
	
	private By searchResults=By.cssSelector("div.caption a");
	
	@Step ("Getting number of result of product")
	public int getProductSearchCount() {
	int searchCount=	eleUtil.waitForPresenceOfElementsWithFluentWait(searchResults, 10, 1500).size();
	System.out.println("Search count : "+searchCount);
	return searchCount;
	}
	
	@Step("Selecting product and getting details....")
	public ProductInfoPage selectProduct(String mainProdName) {
		System.out.println("main product name is: "+mainProdName);
		List<WebElement> products = eleUtil.waitForPresenceOfElementsWithFluentWait(searchResults, 10, 1500);
		for (WebElement e : products) {
			System.out.println("product is:"+e.getText());
			if (e.getText().equalsIgnoreCase(mainProdName)) {
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}
	
	
	
}
