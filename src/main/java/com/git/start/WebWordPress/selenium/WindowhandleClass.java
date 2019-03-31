package com.git.start.WebWordPress.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowhandleClass {

	WebDriver driver;

	@Test
	public void f() {

		String parentWin = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for (String winner : windows) {

			driver.switchTo().window(winner);

			String title = driver.getTitle();

			System.out.println(title);

			if (!winner.equals(parentWin)) {

				driver.close();
			}

		}
		
		driver.switchTo().window(parentWin);
		
		
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
