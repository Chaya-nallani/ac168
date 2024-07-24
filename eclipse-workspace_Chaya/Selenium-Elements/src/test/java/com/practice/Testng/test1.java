package com.practice.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test1 {
	@Test
	public void testGoogle() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("hyr tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();		
		
	}	
	
	@Test
	public void testFacebook() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com/");
		driver.findElement(By.name("email")).sendKeys("ch.chaya", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();		
		
	}

}
