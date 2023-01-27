package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

import io.qameta.allure.Step;

public class AddressBookPage
{

	
	private WebDriver driver;
	ElementUtil eleUtil;
	JavaScriptUtil jsUtil;

	public AddressBookPage(WebDriver driver) {
		this.driver=driver;
		jsUtil = new JavaScriptUtil(driver);

		eleUtil = new ElementUtil(driver);

	}

	private By addressPageHeader=By.xpath("//div[@id='content']/h2");
	private By newAddress=By.linkText("New Address");
	private By deleteAddress=By.xpath("//td[@class='text-right']/a");
	private By addressDeleteMSG=By.xpath("//div[@class='alert alert-success alert-dismissible']");

	
	
	public String getAddressBookPageTitle() {
		return eleUtil.doGetTitle(Constants.ADDRESS_BOOK_PAGE_TITLE_FRACTION, 10);
	}

	
	/**
	 * This method is used to get Address Page Header
	 * @return this method returns Address Page Header
	 */
	@Step("Getting Address Page Header")
	public String getAddressPageHeader() {
		return eleUtil.doGetText(addressPageHeader);
	}
	
	/**
	 * This method is used to go New Address Page
	 * @return this method returns Object of New Address Page
	 */
	@Step("Go to New Address Page")
	public NewAddressPage goNewAddressPage() {
		jsUtil.scrollIntoView(eleUtil.getElement(newAddress));
		eleUtil.doClick(newAddress);

		return new NewAddressPage(driver);
	}
	
	/**
	 * This method is used to go New Address Page
	 * @return this method returns Object of New Address Page
	 */
	@Step("Delete all added adresses")
	public String deteteAddresses() {
	List<WebElement> addresses = eleUtil.getElements(deleteAddress);
	System.out.println(addresses.size());
		for (int i = 2; i < addresses.size(); i++) {
			i++;
			System.out.println(addresses.get(i).getText());
			addresses.get(i).click();
			System.out.println("Clicked on delete");

			driver.switchTo().alert();
			System.out.println("Switch to alert");

			eleUtil.acceptAlert(10);
			
			System.out.println("Alert Accept");

		}
		System.out.println("Return "+eleUtil.doGetText(addressDeleteMSG));

		return eleUtil.doGetText(addressDeleteMSG);
		
	}
	

	
	
	
	
	
	
	
}
