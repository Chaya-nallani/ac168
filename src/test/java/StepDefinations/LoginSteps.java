package StepDefinations;
import pages.Loginpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

import org.testng.Assert;

import com.factory.DriverFactory;

public class LoginSteps {
	private Loginpage loginpage=new Loginpage(DriverFactory.getDriver());
	@Given("The user is in Landing Page")
	public void landing_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");
	}

	@When("Verify Title {string}.")
	public void ui_elements_load(String string) {
		String title=loginpage.get_title();
		Assert.assertTrue(title.contains(string));
	}

	@Then("page h1-tag is [Preparing for the Interviews] and paragraph-tag is [You are at the right place].")
	public void h1_tag() {
		Assert.assertTrue(loginpage.getTextOfH1P1());
	}
	
	@And("get-started button text is {string}.")
	public void get_started_button(String string) {
		Assert.assertTrue(loginpage.get_button());
	}

	@When("Click [Get Started] button. User navigated to Login page.")
	public void user_navigated_to_login_page() {
		loginpage.click_get_btn();
	}

	@Then("[Register] and [Sign in] links are displayed at the top right corner of Login page")
	public void register_sign_in_linksdisplayed() {
		Assert.assertTrue(loginpage.register_signin());
	}

	@When("User Clicks the [Register] link")
	public void clicks_the_register_link() {
		loginpage.click_register_link();
	}

	@Then("The Application displays Registration page")
	public void registration_page() {
		Assert.assertTrue(loginpage.verify_registration_page());
		System.out.println("username ,password1,password2,registration is displayed");
	}
	@When("User clicks [Sign in] link.")
	public void clicks_sign_in_link() {
		loginpage.signin_click();
	}
	@And("User enters {string} and {string} and clicks Login button")
	public void user_enters_username_and_password_and_clicks(String username,String password) {
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.login_click();
	}
	@When("User is in HomePage.Get the title of that page")
	public void get_the_title_of_homepage() {
		System.out.println(loginpage.get_title());
	}
	@Then("DataStructures Dropdown displayed.")
	public void data_structures_dropdown_displayed() {
//	   List<String>exceptedResults=list_Expected.asList();
//	   System.out.println(exceptedResults);
		List<String>ActualList=loginpage.DropDownDataStructure();
	   System.out.println("Actual Result: "+ActualList);
	  // Assert.assertTrue(exceptedResults.containsAll(ActualList));
	}

	@And("^The (.+) are displayed with Get Started button.$")
	public void pane_with_get_started_button(String pane) {
		Assert.assertTrue(loginpage.panesString_displayed(pane));
	}
	
}
