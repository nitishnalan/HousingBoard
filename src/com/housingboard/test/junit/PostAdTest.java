package com.housingboard.test.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PostAdTest {
	WebDriver driver;
	@Before
	public void login() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
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
	public void checkPostAd() throws InterruptedException{
		WebElement createAdLink = driver.findElement(By.id("create-ad"));
		createAdLink.click();
		Thread.sleep(500);
		Assert.assertEquals("Ads Application", driver.getTitle());
		WebElement title = driver.findElement(By.name("title"));
		title.sendKeys("Test Title");
		WebElement image = driver.findElement(By.name("imageUrl"));
		image.sendKeys("https://user-images.githubusercontent.com/13860646/38606020-8e3f5766-3da7-11e8-813f-ba7b6170b526.jpg");
		WebElement desc = driver.findElement(By.name("description"));
		desc.sendKeys("This is test description");
		WebElement community = driver.findElement(By.name("community"));
		community.sendKeys("Test community");
		WebElement parking = driver.findElement(By.id("parking-Space"));
		parking.click();
		WebElement pet = driver.findElement(By.id("pets"));
		pet.click();
		WebElement newLease = driver.findElement(By.id("new-lease"));
		newLease.click();
		WebElement shared = driver.findElement(By.id("shared"));
		shared.click();
		WebElement br = driver.findElement(By.id("2br"));
		br.click();
		WebElement submit = driver.findElement(By.id("submit-button"));
		submit.click();
		Thread.sleep(2000);		
		Assert.assertEquals("Success", driver.getTitle());
	}

	@After
	public void closePage(){
		driver.quit();
	}
}
