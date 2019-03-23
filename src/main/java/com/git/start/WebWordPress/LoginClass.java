package com.git.start.WebWordPress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginClass {
	WebDriver driver;
	public LoginClass(WebDriver driver2) {
		driver= driver2;
	}
	public void loginMethod()
	{
		WebElement username= driver.findElement(By.id("user_login"));
	      username.sendKeys("admin");
	      
	      WebElement password=  driver.findElement(By.name("pwd"));
	      password.sendKeys("demo123");
	      
	      WebElement loginButn=  driver.findElement(By.xpath("//input[@type='submit']"));
	      
	           
	
	      loginButn.click();
	      
	      WebElement Dashboard= driver.findElement(By.xpath("//div[text()='Post']"));
	}
	
}
