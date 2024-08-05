package StepDefinitions;

import io.cucumber.java.en.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Pages.*;
import StepDefinitions.*;
import utilities.WebDriverUtil;

public class DataStructuresSteps {
    private WebDriver driver = WebDriverUtil.getDriver();
    private DataStructuresPage dataStructuresPage = new DataStructuresPage(driver);

    @Given("Login to DsAlgo Application with {string} and {string}")
    public void login_to_ds_algo_application_with_and(String loginname, String password) {
       BaseSteps.login(loginname,password);
    }

    @When("User click DataStructures Page")
    public void user_click_data_structures_Page() {
        dataStructuresPage.clickDataStructures();
    }

    @Then("User see the following text:")
    public void user_see_text(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedTexts = dataTable.asList(String.class);
        for (String expectedText : expectedTexts) {
            if (dataStructuresPage.verifyTextPresent(expectedText)) {
                System.out.println("Text is present: " + expectedText);
            } else {
                System.out.println("Text is not present: " + expectedText);
            }
        }
    }

    @When("User hit time-complexity")
    public void user_hit_time_complexity() {
        dataStructuresPage.clickTimeComplexity();
    }

    @When("User hit Try here")
    public void user_hit_try_here() {
        dataStructuresPage.clickTryHere();
    }

    @Then("User should see the Run button")
    public void user_should_see_the_run_button() {
        if (dataStructuresPage.isRunButtonPresent()) {
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
        BaseSteps.logout();
    }
}
