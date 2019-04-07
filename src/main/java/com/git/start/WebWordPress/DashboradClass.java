package com.git.start.WebWordPress;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.git.start.WebWordPress.selenium.CommonUtil;

public class DashboradClass {
	WebDriver driver;
	ExtentTest test;
	@FindBy(xpath = "//div[text()='Posts']")
	WebElement locatorClickPost;

	public DashboradClass(WebDriver driver2, ExtentTest test) {
		driver = driver2;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void dashboradmethod() throws IOException{
		try {
			test.info("I am inside dashboradmethod");
			locatorClickPost.click();

			WebElement clickAddnew = driver.findElement(By.xpath("//a[text()='Add New'][@href='post-new.php']"));
			System.out.println("Hello");
			clickAddnew.click();

			WebElement enter = driver.findElement(By.xpath("//input[@name='post_title']"));
			enter.sendKeys("SaurabPost");

			WebElement publish = driver.findElement(By.id("publish"));
			publish.click();

			WebElement allpost = driver.findElement(By.xpath("//a[text()='All Posts']"));
			allpost.click();

			List<WebElement> noOfrow = driver
					.findElements(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr"));

			for (int i = 1; i <= noOfrow.size(); i++) {

				WebElement title = driver.findElement(By.xpath(
						"//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[" + i + "]/td/strong/a"));

				System.out.println(title.getText());

				if ("SaurabPost".equals(title.getText())) {

					WebElement checkbox = driver.findElement(
							By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[" + i
									+ "]/th/input"));
					checkbox.click();
				}

			}

			test.pass("Adding post was successfully");
		} catch (Exception e) {
			CommonUtil common = new CommonUtil(driver);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder
					.createScreenCaptureFromPath(common.screenshots("DasboardError")).build();
			test.fail("Adding post was not performed due to some reason: ", mediaModel);
		}
	}
}
