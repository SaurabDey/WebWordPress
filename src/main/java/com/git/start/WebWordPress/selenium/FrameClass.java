package com.git.start.WebWordPress.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameClass {

	WebDriver driver;

	@Test
	public void f() {
		
		WebElement fr1= driver.findElement(By.xpath("//frame[@name='packageListFrame']"));
		driver.switchTo().frame(fr1);

		WebElement link1=	driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/condition/package-frame.html']"));
		link1.click();
		
		driver.switchTo().defaultContent();
		
		WebElement fr2= driver.findElement(By.xpath("//frame[@name='packageFrame']"));
		driver.switchTo().frame(fr2);
		
		WebElement link2=	driver.findElement(By.xpath("//a[@href='DefaultConditionRunner.Monitor.html']"));
		link2.click();
		
		driver.switchTo().defaultContent();
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
