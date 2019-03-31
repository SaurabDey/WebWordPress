package com.git.start.WebWordPress;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutClass {
	WebDriver driver;
	public LogoutClass(WebDriver driver2) {
		driver= driver2;
	}
	public void logoutMethod()
	{
		WebElement admin =  driver.findElement(By.id("wp-admin-bar-my-account"));
		
		WebElement logout =  driver.findElement(By.id("wp-admin-bar-logout"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions act= new Actions(driver);
		act.moveToElement(admin).pause(Duration.ofSeconds(3)).moveToElement(logout).click().build().perform();
		
	}
	
}
