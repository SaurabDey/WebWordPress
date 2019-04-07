package com.git.start.WebWordPress;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.git.start.WebWordPress.selenium.CommonUtil;


public class LoginClass {
	WebDriver driver;
	ExtentTest test;

	@FindBy(id = "user_login")
	WebElement locatorUsername;

	@FindBy(name = "pwd")
	WebElement locatorPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement locatorLoginBut;

	public LoginClass(WebDriver driver2, ExtentTest test) {
		driver = driver2;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void loginMethod() throws IOException {
		try {
			locatorUsername.sendKeys("admin");

			locatorPassword.sendKeys("demo");

			locatorLoginBut.click();

			Assert.assertEquals("Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress", driver.getTitle());;
			test.pass("Login was successfully");
		} catch (AssertionError |Exception e) {
			CommonUtil common=new CommonUtil(driver);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshots("LoginError")).build();		
			test.fail("Login was not performed due to some reason: " ,mediaModel);
		}
	}

}
