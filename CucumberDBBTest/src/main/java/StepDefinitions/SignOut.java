package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import utilities.WebDriverUtil;


public class SignOut extends BaseSteps {
	
    WebDriver driver = WebDriverUtil.getDriver();
    
	@Given("User already logged in to DSAlgo Home Pagew with {string} and {string}")
	public void user_already_logged_in_to_ds_algo_home_pagew_with_and(String loginname, String password) {
		UserLogin(loginname, password);
	}

	
	@When("User hit SignOut")
	public void user_hit_sign_out() {
		driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();

	}

	@Then("User should SignOut Successfully")
	public void user_should_sign_out_successfully() {
		boolean isLoggedIn = driver.findElements(By.xpath("//*[contains(text(),'Sign in')]")).size() > 0;
        if (isLoggedIn) {
            System.out.println("Signout successful");
        } else {
            System.out.println("Signout failed");
        }
	}



}
