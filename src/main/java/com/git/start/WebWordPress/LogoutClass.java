package com.git.start.WebWordPress;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutClass {
	WebDriver driver;
	
	@FindBy(id="wp-admin-bar-my-account")
	WebElement admin;
	
	@FindBy(id="wp-admin-bar-logout")
	WebElement logoutButton;
	
	public LogoutClass(WebDriver driver2) {
		driver= driver2;
		PageFactory.initElements(driver, this);
	}
	public void logoutMethod()
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions act= new Actions(driver);
		act.moveToElement(admin).pause(Duration.ofSeconds(3)).moveToElement(logoutButton).click().build().perform();
		
	}
	
}
