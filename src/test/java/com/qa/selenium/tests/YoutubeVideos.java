package com.qa.selenium.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YoutubeVideos {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		   WebDriver driver=new ChromeDriver();
		   driver.get("https://www.youtube.com/");
			
			/*
			 * driver.findElement(By.name("//div[@id='meta']")).sendKeys("Mobile");
			 * Thread.sleep(5000);
			 */
		 List<WebElement> suggessionList=driver.findElements(By.xpath("//div[@id='scroll-container']//yt-chip-cloud-chip-renderer"));
		   System.out.println(suggessionList.size());
		for (WebElement e : suggessionList) {
			String text = e.getText();
			System.out.println(text+":-->");
			if (text.equals("mobilegoo")) {
				e.click();
				break;
			}
		}
				
				
			}

	
	
	
}
