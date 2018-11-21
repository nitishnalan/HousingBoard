package com.housingboard.Junit;

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
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tushar Chemburkar\\Desktop\\College\\Fall 2018\\OOAD\\Jars\\chromedriver.exe");
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
		Assert.assertEquals("Search Results", driver.getTitle());
		WebElement searchbox = driver.findElement(By.name("searchfield"));
		searchbox.sendKeys("420");
		Thread.sleep(3000);
		String adTitle = driver.findElement(By.xpath("//table[@id='searchtable']/tbody/tr[1]/td[2]")).getText();
		Assert.assertTrue(adTitle.contains("420"));
	}

	@After
	public void closePage(){
		driver.quit();
	}
}
