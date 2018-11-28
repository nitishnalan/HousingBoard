package com.housingboard.test.junit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class RegisterTest {
	WebDriver driver;
	@Before
	public void openRegisterPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HousingBoard/register.jsp");
		Assert.assertEquals("HousingBoard Registration", driver.getTitle());
	}
	@Test
	public void checkRegister() throws InterruptedException{
		WebElement radio = driver.findElement(By.id("type-member"));
		radio.click();
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.name("email_id"));
		email.sendKeys("qw1@gmail.com");
		Thread.sleep(1000);
		WebElement name = driver.findElement(By.name("full_name"));
		name.sendKeys("Quan Ting");
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123");
		Thread.sleep(1000);
		WebElement confirmpassword = driver.findElement(By.name("confirm_password"));
		confirmpassword.sendKeys("123");
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.name("phone_no"));
		phone.sendKeys("1231231221");
		Thread.sleep(1000);
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("421 Huge Block");
		Thread.sleep(1000);
		WebElement zipcode = driver.findElement(By.name("zipcode"));
		zipcode.sendKeys("75535");
		Thread.sleep(1000);
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Miami");
		Thread.sleep(1000);
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("FL");
		Thread.sleep(1000);
		WebElement country = driver.findElement(By.name("country"));
		country.sendKeys("USA");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		Assert.assertEquals("Success", driver.getTitle());
	}

	@After
	public void closePage(){
		driver.quit();
	}
}