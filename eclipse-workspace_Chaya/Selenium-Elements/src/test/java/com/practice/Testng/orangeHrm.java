package com.practice.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class orangeHrm {
	
	 WebDriver driver;
	//Launch app orange HRM
	@Test
	public void launchApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	//Login to the application
	@Test
	public void login() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class =\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
	}
	
	@Test
	//Verify Login method
	public void verifyLogin() throws Exception {
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//p[@class =\"oxd-userdropdown-name\"]")));
		
	}
	@Test
	//Navigating to My Info tab
	public void navigateToMyInfo() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();	
		
	}
	
	@Test
	// Validating my info tab
	public void verifyMyInfo() throws Exception {
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class = \"orangehrm-edit-employee-navigation\"]")).isDisplayed());
		
	}
	
	@Test	
	// Logout 
	public void logout() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		driver.quit();
	}	
		
 
	
}
