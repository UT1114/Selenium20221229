package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	ElementUtil eleUtil;
	Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
	}

	private By productHeaderName = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
//	private By productQty = By.id("input-quantity");
//	private By addToCartBtn = By.id("button-cart");

	public String getProductHeader() {
		String text = eleUtil.doGetText(productHeaderName);
		System.out.println("Product header is : " + text);
		return text;
	}

	public int getImageCount() {
		int imageCount = eleUtil.waitForVisibilityOfElements(productImages, 10).size();
		return imageCount;
	}

	public Map<String, String> getProductInfo() {
		productInfoMap = new LinkedHashMap<String, String>();
		productInfoMap.put("Product Header ", getProductHeader());
		getProductMetaData();
		getProductPriceData();
		return productInfoMap;
	}

	private Map<String, String> getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaDataList) {
//			System.out.println("metadata hai ----"+e.getText());
			String[] meta = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
		return productInfoMap;
	}

	public Map<String, String> getProductPriceData() {
		List<WebElement> priceData = eleUtil.getElements(productPriceData);
		productInfoMap.put("Product Main Proce ", priceData.get(0).getText());
		String[] extPrice = priceData.get(1).getText().split(":");
		productInfoMap.put("Product Ext Price ", extPrice[1]);
		return productInfoMap;

	}
}
