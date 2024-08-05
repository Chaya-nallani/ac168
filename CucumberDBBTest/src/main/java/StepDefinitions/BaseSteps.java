package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverUtil;

public class BaseSteps {
    protected WebDriver driver = WebDriverUtil.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Method to perform login
    public void UserLogin(String loginname, String password) {
        driver.get("https://dsportalapp.herokuapp.com/home");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Sign in')]"))).click();
        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys(loginname);
        driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click(); 
    }
}
