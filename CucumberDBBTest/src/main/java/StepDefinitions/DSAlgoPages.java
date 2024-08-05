package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import utilities.WebDriverUtil;

public class DSAlgoPages extends BaseSteps {

	WebDriver driver = WebDriverUtil.getDriver();
	//String originalWindowHandle;
	
	// Method to switch to a new window
	//private void switchToNewWindow() {
	//    List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
	//    for (String handle : windowHandles) {
	//       if (!handle.equals(originalWindowHandle)) {
	//            driver.switchTo().window(handle);
	//            break;
	//        }
	//    }
	//}



	@When("User hit DataStructures Page")
	public void user_hit_data_structures_Page() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dataStructuresLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ href='data-structures-introduction']")));
	    dataStructuresLink.click();
	}


	@Then("User should see the following text:")
	public void user_should_see_text(io.cucumber.datatable.DataTable dataTable) {
	    // Get the expected text from the DataTable
	    List<String> expectedTexts = dataTable.asList(String.class);

	    // Loop through each expected text and verify its presence on the page
	    for (String expectedText : expectedTexts) {
	        // Attempt to find the element containing the expected text
	        List<WebElement> matchingElements = driver.findElements(By.xpath("//*[contains(text(),'" + expectedText + "')]"));

	        // Check if the text is present and print appropriate message
	        if (matchingElements.size() > 0) {
	            System.out.println("Text is present: " + expectedText);
	        } else {
	            System.out.println("Text is not present: " + expectedText);
	        }
	    }
	}

	
	@When("User hit Array Page")
	public void user_hit_array_page() {
		driver.findElement(By.xpath("//a[@ href=\"array\" ]")).click();
		
	}

	@When("User hit Linked List Page")
	public void user_hit_linked_list_page() {
		driver.findElement(By.xpath("//a[@ href=\"linked-list\" ]")).click();
	}



}
