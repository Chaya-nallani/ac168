package Assignments;

import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class JuiceShop {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setImplicitWaitTimeout(java.time.Duration.ofMillis(5000));
		chromeOptions.addArguments("Start-maximized");	
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		Login(driver); 		
		 
	}		
		
	//App launch and Account Login
	public static void Login(WebDriver driver) throws InterruptedException {
		driver.get("https://juice-shop.herokuapp.com/#/c");			
		driver.findElement(By.xpath("//span[contains(text(),\"Dismiss\")]")).click();		
		driver.findElement(By.xpath("//*[contains(text(),\" account_circle \")]")).click();	
		driver.findElement(By.id("navbarLoginButton")).click();
		driver.findElement(By.id("email")).sendKeys("raj@owasp.com");
		driver.findElement(By.id("password")).sendKeys("test456");
		driver.findElement(By.id("loginButton")).click();	
		Thread.sleep(2000);
	
		//Adding 2 items to basket from first page to the list
		List<WebElement> list = driver.findElements(By.cssSelector("div.item-name"));
		String[] additems  = {"Apple Juice (1000ml)","Fruit Press"};			
		for(int i = 0; i< list.size(); i++) {
			list = driver.findElements(By.cssSelector("div.item-name"));
			String[] productname = list.get(i).getText().split("-");
			String frmtdname = productname[0].trim();
			//System.out.println(frmtdname);	
			List<String> itemsneeded = Arrays.asList(additems);
			if(itemsneeded.contains(frmtdname)) {
				List<WebElement> list2 = driver.findElements(By.xpath("//span[text() =\"Add to Basket\"]"));
				list2.get(i).click();
				System.out.println("Product added");					
			}	
		}
				
		// Navigating to second page and adding 2 items to the basket
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		//dismissing the pop up	
		driver.findElement(By.xpath("//a[contains(text(),\"Me want it!\")]")).click();
		 //WebElement e = driver.findElement(By.id("mat-select-value-3"));
		Thread.sleep(2000);
		WebElement nav = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-paginator-navigation-next mat-icon-button mat-button-base']"));
		//WebElement nav = driver.findElement(By.xpath("//*[@class = \"mat-app-background bluegrey-lightgreen-theme\"]"));
		
		if(nav.isEnabled()) {			
			nav.click();			
		}
		else {
			System.out.println("navigation is not avaibale");
		}
		
		WebElement element = driver.findElement(By.xpath("//div[contains(text(), \" OWASP Juice Shop CTF Girlie-Shirt \")]"));
		if(element.isDisplayed()) {			
			System.out.println("Navigated to next page");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text() =\"Add to Basket\"]")).click();			
			System.out.println("Tee-shirt added to the basket");			
		} 
		else {
			System.out.println("couldnt navigate");
		}

		//Checking basket
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class =\"mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted\"]")).click();
		
		WebElement e1 = driver.findElement(By.xpath("//mat-table/mat-row[1]/mat-cell[3]/button[2]/span[1]"));
		e1.click();		
		driver.findElement(By.xpath("//mat-table/mat-row[2]/mat-cell[3]/button[2]/span[1]")).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mat-table/mat-row[3]/mat-cell[3]/button[2]/span[1]")).click();
		//Checkout
		//driver.findElement(By.id("checkoutButton")).click()
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class =\"mat-focus-indicator checkout-button mat-raised-button mat-button-base mat-primary\"]")).click();
		WebElement pg = driver.findElement(By.xpath("//h1[contains(text(),\"Select an address\")]"));
		if (pg.isDisplayed()) {
			System.out.println("Navigated to cards page");			
		}
		else {
			System.out.println("did not naviagte to car page");
		}
		
		driver.findElement(By.xpath("//span[contains(text(), \"Add New Address\")]")).click();
		driver.findElement(By.id("mat-input-3")).sendKeys("US");
		driver.findElement(By.id("mat-input-4")).sendKeys("Chaya");
		driver.findElement(By.id("mat-input-5")).sendKeys("5486578456");
		driver.findElement(By.id("mat-input-6")).sendKeys("3326");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		driver.findElement(By.xpath("//*[@id =\"address\"]")).sendKeys("80 drive rd");		
		//driver.findElement(By.xpath("//div[@class = \"mat-form-field-infix ng-tns-c21-24\"]")).sendKeys("80 drive rd");
		driver.findElement(By.id("mat-input-8")).sendKeys("weston");
		driver.findElement(By.id("mat-input-9")).sendKeys("florida");
		WebElement submit = driver.findElement(By.id("submitButton"));
		if(submit.isEnabled()) {
			submit.click();
		}
		else {
			System.out.println("Submit button is not enabled");
		}
		
		//selecting the address
		//driver.findElement(By.xpath("//span[@class =\"mat-radio-outer-circle\"]")).click();
		driver.findElement(By.id("mat-radio-42")).click();
		driver.findElement(By.xpath("//span[contains(text(),\"Continue\")]")).click();
		
		
		//selecting the speed of delivery
		driver.findElement(By.xpath("//mat-table//mat-row[1]//mat-cell[1]")).click();
		WebElement s = driver.findElement(By.xpath("//span[contains(text(),\"Continue\")]"));
		if(s.isEnabled()) {
			s.click();
			System.out.println("Selected speed of delivery and clicking on continue");
			
		}
		else {
			System.out.println("Submit is not enabled");
		}
		
		//adding a new card
		driver.findElement(By.xpath("//span//mat-panel-title[contains(text(),\" Add new card \")]")).click();
		driver.findElement(By.id("mat-input-10")).sendKeys("chaya");
		driver.findElement(By.id("mat-input-11")).sendKeys("7889999999999999");
		WebElement s1 = driver.findElement(By.id("mat-input-12"));
		Select month = new Select(s1);
		month.selectByValue("3");
		WebElement s2 = driver.findElement(By.id("mat-input-13"));
		Select year = new Select(s2);
		year.selectByValue("2082");
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"mat-button-wrapper\"]//i[contains(text(),\" send \")]")).click();
		
		//Adding a fake coupoun and capturing error message
		driver.findElement(By.xpath("//span//mat-panel-title[contains(text(),\" Add a coupon \")]")).click();
		driver.findElement(By.xpath("//input[@id =\"coupon\"]")).sendKeys("7845692546");
		driver.findElement(By.xpath("//span[@class=\"mat-button-wrapper\"]//mat-icon[contains(text(),\" redeem \")]")).click();
		Thread.sleep(2000);
		String error = driver.findElement(By.xpath("//div[@class=\"error ng-star-inserted\"]")).getText();		
		System.out.println(error);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		Thread.sleep(3000);
		
		//Selecting a card for review
		//WebElement radiobtn = driver.findElement(By.xpath("//mat-row[1]//mat-cell[1]"));
		WebElement radiobtn = driver.findElement(By.xpath("//mat-radio-button[@class='mat-radio-button mat-accent']"));
		radiobtn.click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(1000);
		
		WebElement sub = driver.findElement(By.xpath("//span[contains(text(),\"Continue\")]"));
		if(sub.isEnabled()) {
			sub.click();
			System.out.println("clicked on submit");
			
		}
		else {
			System.out.println("Submit button is dabled");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),\"Place your order and pay\")]")).click();		
		
		//account--print
		driver.findElement(By.xpath("//span[contains(text(),\" Account \")]")).click();
		driver.findElement(By.xpath("//button//span[contains(text(),\" Orders & Payment \")]")).click();
		driver.findElement(By.xpath("//button//span[contains(text(),\" Order History \")]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Track Orders")).click();
		driver.findElement(By.xpath("//button[@aria-label='Track Your Order']")).click();
		Thread.sleep(2000);
		//driver.navigate().to("https://juice-shop.herokuapp.com/#/order-history");
		driver.navigate().back();
		Thread.sleep(2000);
		
		//print
		String winH= driver.getWindowHandle();
		System.out.println("Window hadnle is "+ winH);
		driver.findElement(By.xpath("//span//mat-icon[contains(text(),\"note\")]")).click();
		Thread.sleep(3000);
		driver.switchTo().window(winH);
		Thread.sleep(3000);
		//driver.navigate().to("https://juice-shop.herokuapp.com/#/order-history");
		
		//logout
		driver.findElement(By.xpath("//span[contains(text(),\" Account \")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[contains(text(),\" Logout \")]")).click();
		
		
		
		
	}
}

		
	
	
		
		
			
	
		



