package com.git.start.WebWordPress.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClassSelenium {

	WebDriver driver;

	@Test
	public void f() {
		WebElement frame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement drag= driver.findElement(By.id("draggable"));
		
		WebElement drop= driver.findElement(By.id("droppable"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(drag, drop).perform();

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
