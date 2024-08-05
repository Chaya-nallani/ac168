package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import utilities.WebDriverUtil;

public class Login extends BaseSteps {
    WebDriver driver = WebDriverUtil.getDriver();

    @Given("User is on DSAlgo Home Page")
    public void user_is_on_ds_algo_home_page() {
        // The navigation to the home page is handled in the @Before hook
    }

    @When("User enter {string} and {string} and hit Signin")
    public void user_enter_and_and_hit_signin(String loginname, String password) {
    	UserLogin(loginname, password);
        }

     
    @Then("User should login to the application")
    public void user_should_login_to_the_application() {
        boolean isLoggedIn = driver.findElements(By.xpath("//*[contains(text(),'Sign out')]")).size() > 0;
        if (isLoggedIn) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
    
    
}
