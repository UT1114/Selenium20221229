package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	OptionsManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * this method used to initialize the driver
	 * 
	 * @param browserName
	 * @return this will return the driver
	 */
	public WebDriver intializeDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is : " + browserName);
		optionManager = new OptionsManager(prop);

		highlight = prop.getProperty("highlight");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(optionManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver(optionManager.getFirefoxOptions());
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(optionManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver());

		} else {
			System.out.println("Please pass the right browser : " + browserName);
		}
		// driver.manage().window().fullscreen();
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	/**
	 * this will return thread a local copy of WebDriver
	 * 
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method used to initialize the properties.
	 * 
	 * @return this method returns properties.
	 */
	public Properties intializeProp() {

		FileInputStream fis = null;
		prop = new Properties();
		String envName = System.getProperty("env");
        //  String envName = "qa";

		if (envName == null) {
			System.out.println("Running on prod environment");

			try {
				fis = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		else {
			try {
				System.out.println("Enviornment name is " + envName);
				switch (envName.toLowerCase()) {
				case "qa":
					fis = new FileInputStream(".\\src\\test\\resources\\config\\qa.config.properties");

					break;
				case "stage":
					fis = new FileInputStream(".\\src\\test\\resources\\config\\stage.config.properties");

					break;
				case "uat":
					fis = new FileInputStream(".\\src\\test\\resources\\config\\uat.config.properties");

					break;
				case "dev":
					fis = new FileInputStream(".\\src\\test\\resources\\config\\dev.config.properties");

					break;

				case "prod":
					fis = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");

					break;

				default:
					System.out.println("Please pass currect env name.....");
					break;
				}
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
	
	/*
	 * Take Screenshot
	 */
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
	
	
}
