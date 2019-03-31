package com.git.start.WebWordPress;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboradClass {
	WebDriver driver;

	public DashboradClass(WebDriver driver2) {
		driver = driver2;
	}
	public void dashboradmethod() {
		WebElement clickPost = driver.findElement(By.xpath("//div[text()='Posts']"));
		clickPost.click();
		WebElement clickAddnew = driver.findElement(By.xpath("//a[text()='Add New'][@href='post-new.php']"));
		System.out.println("Hello");
		clickAddnew.click();

		WebElement enter = driver.findElement(By.xpath("//input[@name='post_title']"));
		enter.sendKeys("SaurabPost");

		WebElement publish = driver.findElement(By.id("publish"));
		publish.click();
		
		WebElement allpost = driver.findElement(By.xpath("//a[text()='All Posts']"));
		allpost.click();
		
		
		List<WebElement> noOfrow= driver.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr"));
		
		for (int i = 1; i <= noOfrow.size(); i++) {
			
			WebElement title=driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr["+i+"]/td/strong/a"));
			
			System.out.println(title.getText());
			
			if ("SaurabPost".equals(title.getText())) {
				
				WebElement checkbox=driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr["+i+"]/th/input"));
				checkbox.click();
			}
			
		}
		
	}


	public void test() {
		System.out.println("Testt");
		
	}
}
