package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for the elements on the login page
    private By signInButton = By.xpath("//*[contains(text(),'Sign in')]");
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By signOutButton = By.xpath("//*[contains(text(),'Sign out')]");

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to open the login page
    public void openLoginPage() {
        driver.get("https://dsportalapp.herokuapp.com/home");
    }

    // Method to perform login
    public void login(String loginname, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        driver.findElement(usernameField).sendKeys(loginname);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    // Method to check if the user is logged in
    public boolean isLoggedIn() {
        return driver.findElements(signOutButton).size() > 0;
    }

    // Method to log out
    public void logout() {
        if (isLoggedIn()) {
            driver.findElement(signOutButton).click();
        }
    }
}
