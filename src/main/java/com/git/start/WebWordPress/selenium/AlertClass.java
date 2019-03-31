package com.git.start.WebWordPress.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertClass {

	WebDriver driver;

	@Test
	public void f() {
		
		WebElement go= driver.findElement(By.xpath("//input[@value='Go!']"));
		go.click();
		
		Alert alt= driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://output.jsbin.com/usidix/1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
