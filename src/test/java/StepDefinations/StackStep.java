package StepDefinations;

import java.util.List;
import java.util.Scanner;

import org.testng.Assert;

import com.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.Loginpage;
import pages.StackPage;

public class StackStep {
	Loginpage loginpage=new Loginpage(DriverFactory.getDriver());
	StackPage stackpage=new StackPage(DriverFactory.getDriver());
	String valid="print('Helo Everyone')";
	String Invalid="print(push(2))";
	@Given("User is in Home page.")
	public void user_in_home_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/home");
		System.out.println("Homepage title: "+loginpage.get_title());
		}
	@When("User clicks {string} pane with Get Started button which is Enabled.")
	public void Stack_getstarted_button(String string) {
	    stackpage.click_Stack_pane();
	}

	@Then("User navigated to Stack page and get the Title of that page")
	public void navigated_to_stack_page_get_the_title() {
		System.out.println("Stackpage title: "+loginpage.get_title());
	}

	@When("Stack information is displayed with related Links below.")
	public void stack_inform_with_related_links(DataTable sectionTable) {
		List<String>expectedResults=sectionTable.asList();
		System.out.println("expected results of stacktable: "+expectedResults);
		List<String>ActualResults=stackpage.ListTopicsInStack();
		System.out.println("Actual results of stacktable: "+ActualResults);
		Assert.assertEquals(expectedResults,ActualResults);
	   
	}

	@When("User clicks operations in stack Link.")
	public void user_clicks_link() {
		stackpage.OperationsInStack();
	}

	@Then("Application navigated to Operation in Stack Page Page, Get the title of that page.")
	public void application_navigated_to_page_get_the_title_of_that_page() {
		System.out.println("OppInSk "+loginpage.get_title());
	}

	@Then("Operation in Stack page is displayed with information and {string} button.")
	public void operation_in_stack_page_with_information_and_button(String string) {
	
	Assert.assertTrue(stackpage.para_tryhere_display());
	}

	@When("user clicks {string} button.")
	public void user_clicks_button(String string) {
		stackpage.click_tryHereBtn();
	}

	@Then("Application navigated to tryEditor page.")
	public void application_navigated_to_try_editor_page() {
		System.out.println("Editor page "+loginpage.get_title());
		
	}

//	@When("^User enters (.+) code in Editor page and clicks [Run] button.$")
//	public void user_enters_valid_code_in_editor_page_and_clicks_button(String valInval) {
//		
//		stackpage.enter_valideditor(valInval);
//		
//	}
	@When("User enters valid code in Editor page and clicks [Run] button.")
	public void valid_code_and_clicks_button() {
		
		stackpage.enter_valideditor();
		
	}
	@When("User enters Invalid code in Editor page and clicks [Run] button.")
	public void invalid_code_in_editorpage_clicks_button() {
		stackpage.enter_Invalideditor();;
	}

	@Then("Expected output is displayed.")
	public void expected_output_is_displayed() {
		
		System.out.println("Actual:"+stackpage.Output());
		//Assert.assertEquals(stackpage.Output(),inputString);
		}

	

	

	@Then("user clicks ok in Alert pop up window.")
	public void user_clicks_ok_in_alert_pop_up_window() {
		System.out.println("popup clicked");
	}

//	@When("User clicks {string} button in Stack which is Enabled.")
//	public void clicks_button_in_stack_is_enabled(String string) {
//		stackpage.click_Stack_pane();
//	}
	@Then("page h1-tag is {string} and paragraph-tag is {string}.")
	public void page_h1_tag_is_preparing_for_the_interviews_and_paragraph_tag_is(String string,String string2) {
	 Assert.assertTrue(loginpage.getTextOfH1P1());
	}
	@When("User clicks Implementation Link.")
	public void user_clicks_implementation_link() {
		stackpage.Implementation();
	}
	@Then("Application navigated to Implementation Page, Get the title of that page.")
	public void application_navigated_to_implementation_page_get_the_title_of_that_page() {
	          loginpage.get_title();
	}
	@Then("Implementation page is displayed with information and {string} button.")
	public void implementation_page_is_displayed_with_information_and_button(String string) {
         loginpage.get_title();
         stackpage.click_tryHereBtn();
	}
	
	@When("User clicks Practice Questions Link.")
	public void user_clicks_practice_questions_link() {
		stackpage.practiceQ();
	}
	@Then("Questions are Expected in Practice Questions page.")
	public void questions_are_expected_in_practice_questions_page() {
		System.out.println("Questions are not displayed");
	}
	
	@Then("Application navigated to Operation in Stack Page, Get the title of that page.")
	public void application_navigated_to_operation_in_stack_page_get_the_title_of_that_page() {
	    System.out.println("operation of stack"+loginpage.get_title());
	}
	
	
	@When("User clicks Applications Link.")
	public void user_clicks_applications_link() {
		stackpage.AplicationInStack();
	}
	@Then("Application navigated to Applications of Stack Page, Get the title of that page.")
	public void application_navigated_to_applications_of_stack_page_get_the_title_of_that_page() {
	loginpage.get_title();
	}
	@Then("Applications is displayed with information and {string} button.")
	public void applications_is_displayed_with_information_and_button(String string) {
	System.out.println("discuss");
	}
	
}
