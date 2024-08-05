package StepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import Pages.*;
import utilities.WebDriverUtil;

public class LoginSteps {
    private WebDriver driver = WebDriverUtil.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("User is on DSAlgo Home Page")
    public void user_is_on_ds_algo_home_page() {
        loginPage.openLoginPage();
    }

    @When("User enter {string} and {string} and hit Signin")
    public void user_enter_and_and_hit_signin(String loginname, String password) {
        loginPage.login(loginname, password);
    }

    @Then("User should login to the application")
    public void user_should_login_to_the_application() {
        if (loginPage.isLoggedIn()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}
