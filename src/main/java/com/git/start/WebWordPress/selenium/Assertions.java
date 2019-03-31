package com.git.start.WebWordPress.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	
	WebDriver driver;
	@Test
	public void hardassert() {

		Assert.assertEquals(driver.getTitle(), "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress");
		WebElement username = driver.findElement(By.id("user_login"));
		username.clear();
		
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys("demo123");

		WebElement loginButn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButn.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://demosite.center/wordpress/wp-admin/");
	}
	@Test
	public void softassert() {

		SoftAssert soft= new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress");
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("demo");

		WebElement loginButn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButn.click();
		
		soft.assertEquals(driver.getCurrentUrl(), "http://demosite.center/wordpress/wp-admin/");
		System.out.println("My dashboard");
		
		soft.assertAll();
	}

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
