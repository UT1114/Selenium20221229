package com.qa.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://172.24.11.206:8082/Kycweb/#!/login");
		Thread.sleep(10000);
		By userName = By.name("userName");
		By password = By.name("password");
		By loginButton = By.cssSelector("[value='Login']");
		
		doSendKey(userName,"de11");
		doSendKey(password,"KYC@123");
		doClick(loginButton);


	}

	private static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	private static void doClick(By locator) {
		getElement(locator).click();
		
	}
	
	private static void doSendKey(By locator, String value) {
		getElement(locator).sendKeys(value);
		
	}
	
	
	
}
