package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	private WebDriver driver;
	private By h1_text=By.xpath("//h1[text()='Preparing for the Interviews']");
	private By p_text=By.xpath("//p[text()='You are at the right place']");
	private By get_button=By.xpath("//button[text()='Get Started']");
	private By Register_lnk=By.linkText("Register");
	private By password1=By.id("id_password1");
	private By password2=By.id("id_password2");
	private By reg_btn=By.xpath("//input[@value='Register']");
	private By Sign_in_link=By.linkText("Sign in");
	private By username=By.id("id_username");
	private By password=By.id("id_password");
	private By Login_btn=By.xpath("//input[@value='Login']");
	private By stack_btn=By.xpath("//a[@href='stack' and text()='Get Started']");
	private By title_name=By.xpath("//title[text()='Numpy Ninja']");
	private By DataStructure_click=By.xpath("//a[@class='nav-link dropdown-toggle'and text()='Data Structures']");
    private By dropdown_ds=By.xpath("//a[@href='#' and text()='Data Structures']/../div[@class='dropdown-menu show']");
    private By dropdown_ds_element=By.xpath("//a[@class='dropdown-item']");
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		}
	//3.page actions:features (behavior) of the page of the methods:
	public boolean getTextOfH1P1() {
		WebElement H1_text = driver.findElement(h1_text);
		WebElement P_text= driver.findElement(p_text);
		return H1_text.isDisplayed() && P_text.isDisplayed();
	}
	public String get_title() {
		String expected_title=driver.getTitle();
		System.out.println(expected_title);
		return expected_title;
	}
	
	public boolean get_button() {
		WebElement get_btn=driver.findElement(get_button);
		return get_btn.isDisplayed();
	}

	public void click_get_btn() {
		driver.findElement(get_button).click();
	}
	public boolean register_signin() {
		WebElement reg_link=driver.findElement(Register_lnk);
		WebElement signin_link=driver.findElement(Sign_in_link);
		return reg_link.isDisplayed() && signin_link.isDisplayed();
	}
	public void click_register_link() {
		driver.findElement(Register_lnk).click();
	}
	public boolean verify_registration_page() {
		WebElement user_name=driver.findElement(username);
		WebElement pass1=driver.findElement(password1);
		WebElement pass2=driver.findElement(password2);
		WebElement regbtn=driver.findElement(reg_btn);
		return user_name.isDisplayed() && pass1.isDisplayed() && pass2.isDisplayed() && regbtn.isDisplayed();
	}
	public void signin_click() {
		driver.findElement(Sign_in_link).click();
		
	}
	public void enterUserName(String name) {
		driver.findElement(username).sendKeys(name); 
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void login_click() {
		driver.findElement(Login_btn).click();
	}public void pane_dispalyed() {
		ArrayList<String>strlist=new ArrayList<>();
		strlist.add("Data Structures-Introduction");
		strlist.add("Array");
		strlist.add("Linked List");
		strlist.add("Stack");
		strlist.add("Queue");
		strlist.add("Tree");
		strlist.add("Graph");
		for(String string:strlist) {
			By pane=By.xpath("//h5[text()='"+string+"']");
			try {
				WebElement element=driver.findElement(pane);
				if (element.isDisplayed()) {
					System.out.println(string+" is displayed");
									
				} else {
	              System.out.println(string+" is not displayed");
	              
				}
			} catch (Exception e) {
				System.out.println(string+" not displayed");
			}
	}}
	public List<String> DropDownDataStructure() {
		driver.findElement(DataStructure_click).click();
		List<String>dd_DS_elmts_list=new ArrayList<>();
		WebElement dd_menu_DS=driver.findElement(dropdown_ds);
		List<WebElement>dd_DS_List_element=dd_menu_DS.findElements(dropdown_ds_element);
		for(WebElement ele:dd_DS_List_element) {
			String elem=ele.getText();
			dd_DS_elmts_list.add(elem);
					}
	return dd_DS_elmts_list;

	}
	public boolean panesString_displayed(String string) {
		By pane=By.xpath("//h5[text()='"+string+"']");
		WebElement element=driver.findElement(pane);
		System.out.println(element.getText());
		return element.isDisplayed();
	}
}
