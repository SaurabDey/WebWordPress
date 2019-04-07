package com.git.start.WebWordPress;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.git.start.WebWordPress.selenium.CommonUtil;

public class LogoutClass {
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(id="wp-admin-bar-my-account")
	WebElement admin;
	
	@FindBy(id="wp-admin-bar-logou")
	WebElement logoutButton;
	
	public LogoutClass(WebDriver driver2, ExtentTest test) {
		this.driver= driver2;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	public void logoutMethod() throws IOException
	{
		try {
			test.info("I am inside logout method");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Actions act= new Actions(driver);
			act.moveToElement(admin).pause(Duration.ofSeconds(3)).moveToElement(logoutButton).click().build().perform();
			
			test.pass("Logout successfully");
		} catch (Exception e) {
			CommonUtil common=new CommonUtil(driver);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshots("LogoutError")).build();		
			test.fail("Logout was not performed due to some reason: ", mediaModel);
		}
		
	}
	
}
