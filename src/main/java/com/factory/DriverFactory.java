package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<>();
	//This method is used to initialize the threadLocal driver on the basis of given browser
	public WebDriver init_driver(String browser) {
		System.out.println("browser "+browser);
		if(browser.equals("chrome")) {
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
			
		}
		else if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
			
		}
		else {
			System.out.println("Please enter correct browser name: "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	//This is used to get the driver with threadLocal 
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
