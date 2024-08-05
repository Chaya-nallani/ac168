package StepDefinitions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import utilities.WebDriverUtil;

public class DataStructures extends BaseSteps {

	WebDriver driver = WebDriverUtil.getDriver();

//	@Given("Login to DsAlgo Application with {string} and {string}")
//	public void login_to_ds_algo_application_with_and(String loginname, String password) {
//		UserLogin(loginname, password);
//		}

	@Given("Login to DsAlgo Application with {string} and {string}")
	public void login_to_ds_algo_application_with_and(String loginname, String password) {
		UserLogin(loginname, password);
	}

	@When("User click DataStructures Page")
	public void user_hit_data_structures_Page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dataStructuresLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@ href='data-structures-introduction']")));
		dataStructuresLink.click();
	}

	@Then("User see the following text:")
	public void user_should_see_text(io.cucumber.datatable.DataTable dataTable) {
		// Get the expected text from the DataTable
		List<String> expectedTexts = dataTable.asList(String.class);

		// Loop through each expected text and verify its presence on the page
		for (String expectedText : expectedTexts) {
			// Attempt to find the element containing the expected text
			List<WebElement> matchingElements = driver
					.findElements(By.xpath("//*[contains(text(),'" + expectedText + "')]"));

			// Check if the text is present and print appropriate message
			if (matchingElements.size() > 0) {
				System.out.println("Text is present: " + expectedText);
			} else {
				System.out.println("Text is not present: " + expectedText);
			}
		}
	}

	@When("User hit time-complexity")
	public void user_hit_time_complexity() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END); // scrolling to end of page
		WebElement timeComplexityLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Time Complexity")));
		timeComplexityLink.click();
	}

	@When("User hit Try here")
	public void user_hit_try_here() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END); // scrolling to end of page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement TryHereLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Try here>>>")));
		TryHereLink.click();
	}

	@Then("User should see the Run button")
	public void user_should_see_the_run_button() {
		// Define the XPath for the "Run" button
		String runButtonXPath = "//*[@type='button' and contains(text(),'Run')]";

		// Find the element using the defined XPath
		List<WebElement> runButtonElements = driver.findElements(By.xpath(runButtonXPath));

		// Check if the "Run" button is present
		if (runButtonElements.size() > 0) {
			System.out.println("Run button is present.");
		} else {
			System.out.println("Run button is not present.");
			throw new AssertionError("Run button not found on the page.");
		}
	}

	@When("User hit Back on Browser")
	public void user_hit_back_on_browser() {
		driver.navigate().back();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
	}

	@Then("User should see the SignOut option")
	public void user_should_see_the_sign_out_option() {
		driver.findElement(By.linkText("Sign out")).click();
	}

}
