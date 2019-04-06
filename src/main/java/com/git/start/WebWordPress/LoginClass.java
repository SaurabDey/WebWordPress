package com.git.start.WebWordPress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	WebDriver driver;

	@FindBy(id = "user_login")
	WebElement locatorUsername;

	@FindBy(name = "pwd")
	WebElement locatorPassword;

	@FindBy(xpath = "//input[@type='submit']") 
	WebElement locatorLoginBut;

	public LoginClass(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public void loginMethod() {
		
		locatorUsername.sendKeys("admin");

		locatorPassword.sendKeys("demo123");

		locatorLoginBut.click();

		System.out.println("Hello");
	}

}
