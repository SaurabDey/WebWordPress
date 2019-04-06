package com.git.start.WebWordPress;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
	ExtentReports extent;
	ExtentTest test;
	@Test
	public void f() {

		try {
			LoginClass log = new LoginClass(driver);
			log.loginMethod();
			test.pass("Login method worked successfully");
		} catch (Exception e) {
			test.fail("Login method had some error");
		}

		try {
			DashboradClass dash = new DashboradClass(driver);
			dash.dashboradmethod();
			test.pass("dashborad method worked successfully");
		} catch (Exception e) {
			test.fail("dashborad method had some error");
		}
		
		try {
			LogoutClass logout = new LogoutClass(driver);
			logout.logoutMethod();
			test.pass("logout Method worked successfully");
		} catch (Exception e) {
			test.fail("logout method had some error");
		}
		

	}

	@Parameters("bro")
	@BeforeTest
	public void beforeTest(String comingValue) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("WordPressReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(true);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		test = extent.createTest("Saurab Test");
		test.pass("Started my Automation");

		String browser = comingValue;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
			test.pass("Started Chrome browser");

		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
			test.pass("Started Firefox browser");
		}

		else if (browser.equals("internetExplorer")) {
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.pass("Started IE browser");
		}

		driver.get("http://demosite.center/wordpress/wp-login.php?");
		test.pass("Opened the intented site");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		extent.flush();
		driver.quit();
	}

}
