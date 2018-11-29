package com.housingboard.test.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
	WebDriver driver;
	@Before
	public void login() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HousingBoard/login.jsp");
		Assert.assertEquals("HousingBoard Login", driver.getTitle());
		WebElement radio = driver.findElement(By.id("type-member"));
		radio.click();
		Thread.sleep(500);
		WebElement email = driver.findElement(By.id("email_id"));
		email.sendKeys("pra@gmail.com");
		Thread.sleep(500);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12");
		Thread.sleep(500);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}
	@Test
	public void checkSearch() throws InterruptedException{
		WebElement searchLink = driver.findElement(By.id("search-ads"));
		searchLink.click();
		Thread.sleep(500);
		WebElement searchbox = driver.findElement(By.name("searchfield"));
		searchbox.sendKeys("402");	
		WebElement searchButton = driver.findElement(By.id("submit-button"));
		searchButton.click();
		Thread.sleep(2000);
		String searchText = driver.findElement(By.xpath("//*[@id=\"search\"]/table/tbody/tr[1]/td[1]")).getText();
		Assert.assertTrue(searchText.contains("402"));
	}

	@After
	public void closePage(){
		driver.quit();
	}
}
