package com.housingboard.Junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkInterestTest {
	WebDriver driver;
	@Before
	public void login() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tushar Chemburkar\\Desktop\\College\\Fall 2018\\OOAD\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HousingBoard/login.jsp");
		Assert.assertEquals("HousingBoard Login", driver.getTitle());
		WebElement radio = driver.findElement(By.id("type-member"));
		radio.click();
		WebElement email = driver.findElement(By.id("email_id"));
		email.sendKeys("pra@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12");
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}
	@Test
	public void checkInterest() throws InterruptedException{
		WebElement checkInterest = driver.findElement(By.id("check-interest"));
		checkInterest.click();
		Thread.sleep(500);
		Assert.assertEquals("Request On ADs", driver.getTitle());
	}

	@After
	public void closePage(){
		driver.quit();
	}
}
