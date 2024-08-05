package StepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import Pages.*;
import utilities.WebDriverUtil;

public class SignOutSteps {
    private WebDriver driver = WebDriverUtil.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("User already logged in to DSAlgo Home Page with {string} and {string}")
    public void user_already_logged_in_to_ds_algo_home_page_with_and(String loginname, String password) {
        loginPage.login(loginname, password);
    }

    @When("User hit SignOut")
    public void user_hit_sign_out() {
        loginPage.logout();
    }

    @Then("User should SignOut Successfully")
    public void user_should_sign_out_successfully() {
        if (!loginPage.isLoggedIn()) {
            System.out.println("Signout successful");
        } else {
            System.out.println("Signout failed");
        }
    }
}
