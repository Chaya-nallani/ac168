package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DataStructuresPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for elements on the Data Structures page
    private By dataStructuresLink = By.xpath("//a[@href='data-structures-introduction']");
    private By timeComplexityLink = By.linkText("Time Complexity");
    private By tryHereLink = By.linkText("Try here>>>");
    private By runButton = By.xpath("//*[@type='button' and contains(text(),'Run')]");

    // Constructor to initialize WebDriver and WebDriverWait
    public DataStructuresPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click on the Data Structures link
    public void clickDataStructures() {
        wait.until(ExpectedConditions.elementToBeClickable(dataStructuresLink)).click();
    }

    // Method to click on the Time Complexity link
    public void clickTimeComplexity() {
        driver.findElement(timeComplexityLink).click();
    }

    // Method to click on the Try Here link
    public void clickTryHere() {
        driver.findElement(tryHereLink).click();
    }

    // Method to check if the Run button is present
    public boolean isRunButtonPresent() {
        return driver.findElements(runButton).size() > 0;
    }

    // Method to verify text on the page
    public boolean verifyTextPresent(String text) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        return elements.size() > 0;
    }
}
