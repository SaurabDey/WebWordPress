package com.git.start.WebWordPress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class WordPressAutomation {
	WebDriver driver;

	@Test
	public void f() {

		LoginClass log = new LoginClass(driver);
		log.loginMethod();

		DashboradClass dash = new DashboradClass(driver);
		dash.dashboradmethod();

		LogoutClass logout= new LogoutClass(driver);
		logout.logoutMethod();
		
	}

	@Parameters("bro")
	@BeforeTest
	public void beforeTest(String comingValue) {
		
		String browser=comingValue;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("internetExplorer")) {
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		driver.quit();
	}

}
