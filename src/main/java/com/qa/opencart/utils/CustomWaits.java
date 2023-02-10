package com.qa.opencart.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freemarker.core.ReturnInstruction.Return;

public class CustomWaits {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public CustomWaits(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void waitForPageLoaded() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String loadingStatus = js.executeScript("return document.readyState;").toString();
		if (loadingStatus.equals("complete")) {
			System.out.println("Page is fully loaded...");
		}

		else {
			for (int i = 1; i <= 20; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				loadingStatus = js.executeScript("return document.readyState;").toString();
				System.out.println("Current Page Loading Status...." + loadingStatus);
				if (loadingStatus.equals("complete")) {
					break;
				}
			}
		}
	}

	public WebElement retringForWebElement(By locator, int timeOut) {
		WebElement ele = null;
		int attempts = 0;
		while (attempts < timeOut) {

			try {

				ele = eleUtil.getElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found in attempts: " + attempts + " : " + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
			attempts++;

		}
		if (ele == null) {
			try {
				throw new Exception("ElementNotFoundException");
			} catch (Exception e) {
				System.out.println("Element not found exception..tried for : " + timeOut + " : with the interval of : "
						+ 500 + " ms");

			}
		}
		return ele;
	}

}
