package SeleniumElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumElements {

	public static void main(String[] args) throws InterruptedException {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setImplicitWaitTimeout(Duration.ofMillis(5000));
		//firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//firefoxOptions.addArguments("start-maximized");
		
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("http://tutorialsninja.com/demo/index.php");
		
		WebElement currency =  driver.findElement(By.xpath("//span[contains( text (), \"Currency\")]"));
		if(currency.isDisplayed()) {
			
			if(currency.isEnabled()) {
				currency.click();
			}
			else 
				System.err.print("Currency Option is not enabled");
		}
		else
			System.err.print("Curreny Option is not displayed");
		
		//Selecting and setting currency to Euro
		WebElement currency_euro = driver.findElement(By.xpath("//*[contains(text(), \"€Euro\")]"));
		currency_euro.click(); 
		
		// selecting and adding to cart - canon EOS 5 D camera
		WebElement camera = driver.findElement(By.linkText("Cameras"));
		camera.click(); 
		WebElement camera_model = driver.findElement(By.linkText("Canon EOS 5D"));
		camera_model.click();
		WebElement cart = driver.findElement(By.id("button-cart"));
		cart.click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Capturing the error message
		WebElement error_msg = driver.findElement(By.xpath("//*[@id=\"input-option226\"] //following-sibling::div"));
		String msg = error_msg.getText();		
		System.out.println(msg);
		
		//Going to Home screen by clicking on Home icon
		WebElement home_icon = driver.findElement(By.xpath("//*[@class = \"breadcrumb\"]//li[01]"));
		home_icon.click();
		
		//selecting iphone
		WebElement iphone = driver.findElement(By.xpath("//a[contains(text(), \"iPhone\")]"));
		iphone.click();
		//setting quantity to 2 and adding to cart.
		WebElement Qty = driver.findElement(By.xpath("//*[@id=\"input-quantity\"]"));
		Qty.clear();
		Qty.sendKeys("2");
		
		//WebElement cart1 = driver.findElement(By.id("button-cart"));
		WebElement cart1 = driver.findElement(By.xpath("//button[@id=\"button-cart\"]"));
		cart1.click(); //adding to cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//capturing the success message
		WebElement success_msg = driver.findElement(By.xpath("//div[@class = \"alert alert-success alert-dismissible\"]"));
		String err_msg = success_msg.getText();
		System.out.println(err_msg);
		
		//clicking on cart, view cart
		WebElement cart_icon = driver.findElement(By.xpath("//div[@id = \"cart\"]"));
		cart_icon.click();
		WebElement view_cart = driver.findElement(By.xpath("//*[contains(text(), \"View Cart\")]"));
		view_cart.click();
		
		//Updating the quantity
		WebElement Q = driver.findElement(By.xpath("//div[@class=\"input-group btn-block\"]//following-sibling :: input[@class =\"form-control\"]"));
		Q.clear();
		Q.sendKeys("3");		
		WebElement update = driver.findElement(By.xpath("//button[@class = \"btn btn-primary\"  and @type =\"submit\"]"));
		update.click();
		
		//Reading the ECO TAX for the product and printing on console		
		WebElement eco= driver.findElement(By.xpath("//div[@class=\"col-sm-4 col-sm-offset-8\"]//table[@class =\"table table-bordered\"]/tbody/tr[2]/td[2]"));
		String eco_tax = eco.getText();
		System.out.println("The ECO TAX is:" +eco_tax);	
		
		//Reading the VAT for the product and printing on console
		WebElement vat= driver.findElement(By.xpath("//div[@class=\"col-sm-4 col-sm-offset-8\"]//table[@class =\"table table-bordered\"]/tbody/tr[3]/td[2]"));
		String vat_value = vat.getText();
		System.out.println("The VAT is:" +vat_value);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//capturing error message and printing on console
		WebElement NA = driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]"));
		String NA_msg = NA.getText();
		System.out.println(NA_msg);
		//Removing product from cart
		WebElement remove = driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle\"]"));
		remove.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//selecting laptops and notebooks
		driver.findElement(By.partialLinkText("Laptops & Notebooks")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@class = \"see-all\" and contains(text(), \"Show AllLaptops & Notebooks\")]")).click();
		driver.findElement(By.partialLinkText("HP LP3065")).click();
		WebElement Qty1= driver.findElement(By.xpath("//input[@id=\"input-quantity\"]"));
		String Qt = Qty1.getAttribute("value");
		//checking if default selecting quantity is 1 and adding to cart
		if(Integer.parseInt(Qt) == 1) {
			WebElement cart2 = driver.findElement(By.xpath("//button[@id=\"button-cart\"]"));
			cart2.click(); //adding to cart
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//capturing the success message
			WebElement success_msg1 = driver.findElement(By.xpath("//div[@class = \"alert alert-success alert-dismissible\"]"));
			String err_msg11 = success_msg1.getText();
			System.out.println(err_msg11);			
		}
		else {
			System.out.println("Quantity is more than default value 1");
		}
		
		//Adding coupoun code
		WebElement cart_icon1 = driver.findElement(By.xpath("//div[@id = \"cart\"]"));
		cart_icon1.click();
		WebElement view_cart1 = driver.findElement(By.xpath("//*[contains(text(), \"View Cart\")]"));
		view_cart1.click();
		WebElement coupon = driver.findElement(By.xpath("//a[@class =\"accordion-toggle\" and contains(text(), \"Use Coupon Code \")]"));
		coupon.click();
		WebElement couponBx = driver.findElement(By.xpath("//input[@id = \"input-coupon\" and @name =\"coupon\"]"));
		couponBx.sendKeys("ABCD123 ");
		//clicking on apply coupon
		driver.findElement(By.xpath("//input[@id = \"button-coupon\" and @value=\"Apply Coupon\"]")).click();
		//Reading and printing error message
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		WebElement msg_er = driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]"));
		String msg_error = msg_er.getText();
		System.out.println(msg_error);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		//gift certificate
		driver.findElement(By.xpath("//a[@class=\"accordion-toggle collapsed\" and contains(text(), \"Use Gift Certificate \")]")).click();
		WebElement cert = driver.findElement(By.id("input-voucher"));
		cert.sendKeys("AXDFGH123");
		driver.findElement(By.id("button-voucher")).click();
		
		//Reading and printing error message of gift certificate
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		String invalidGiftVoucher=driver.findElement(By.xpath("//*[contains(text(),' Warning: Gift Certificate is either invalid or the balance has been used up!')]")).getText();
		System.out.println(invalidGiftVoucher);
		
		//Clearing the text boxes
		driver.findElement(By.linkText("Use Coupon Code")).click();
        driver.findElement(By.id("input-coupon")).clear();
        driver.findElement(By.linkText("Use Gift Certificate")).click();
        driver.findElement(By.id("input-voucher")).clear();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//check out
		driver.findElement(By.linkText("Checkout")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//registration
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@id = \"button-account\" and @value=\"Continue\"]")).click();
		driver.findElement(By.id("button-account")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Chaya");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Nallani");
		driver.findElement(By.id("input-payment-email")).sendKeys("marni@gmail.com");
		driver.findElement(By.id("input-payment-telephone")).sendKeys("475089756");
		driver.findElement(By.id("input-payment-password")).sendKeys("chya23");
		driver.findElement(By.id("input-payment-confirm")).sendKeys("chya23");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("sanremo");
		driver.findElement(By.id("input-payment-city")).sendKeys("weston");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("33327");
		Thread.sleep(3000);
		Select country = new Select(driver.findElement(By.id("input-payment-country")));
		country.selectByValue("223");
		Thread.sleep(3000);
		Select region = new Select(driver.findElement(By.id("input-payment-zone")));		
		region.selectByValue("3630");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		driver.findElement(By.id("button-register")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		
		        
        //15. Add comments, click continue and check the error message related to payment method
  		driver.findElement(By.id("button-shipping-address")).click();
  		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Comment cool");
  		//driver.findElement(By.id("button-shipping-method")).click();
  		//driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
  		driver.findElement(By.xpath("//input[@id=\"button-payment-method\"]")).click();
  		//driver.findElement(By.id("button-shipping-method")).click();
  		  		//driver.findElement(By.id("button-payment-method")).click();
  		Thread.sleep(3000);
  		String PaymentError = driver.findElement(By.xpath("//*[contains(text(),'Warning: You must agree to the Terms & Conditions!')]")).getText();
  		System.out.println("Payment error message is " + PaymentError);
  		Thread.sleep(3000);
  		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
  		//driver.findElement(By.xpath("//input[@name='agree']")).click();
  		//driver.findElement(By.id("button-payment-method")).click();
  		driver.findElement(By.xpath("//input[@id=\"button-payment-method\"]")).click();
//             
  		// 16. Click on contact us hyperlink and submit a contact request and click continue
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.id("input-enquiry")).sendKeys("Sucessful Transaction Done, Happy to visit again");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();    
          
       }
          	
        
}
		
		
	
	

	


		
		
		
		
		
		
		
		



	
	
	
	
		
		
