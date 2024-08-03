package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StackPage {
	private WebDriver driver;
	private By stack_getstart=By.xpath("//a[@href='stack' and text()='Get Started']");
	private By List_stack_Topics=By.xpath("//h4[text()='Stack']/..//ul/a");
	private By operations_in_stack=By.linkText("Operations in Stack");
	private By implementation_stack=By.linkText("Implementation");
	private By application_stack=By.linkText("Applications");
	private By paragraph_operationpage=By.xpath("//p[text()='Operations in Stack']");
	private By try_her_btn=By.linkText("Try here>>>");
	private By print_editorpg=By.cssSelector(".CodeMirror-code .CodeMirror-line");
	private By Runbtn=By.xpath("//button[text()='Run']");
	private By practice_page=By.linkText("Practice Questions");
	private By output_displayed=By.cssSelector("pre#output");
	
	public StackPage(WebDriver driver) {
		this.driver=driver;
	}
	public void click_Stack_pane() {
		driver.findElement(stack_getstart).click();
	}
	public List<String> ListTopicsInStack() {
		List<String>stack_Topics=new ArrayList<>();
		List<WebElement>List_stack=driver.findElements(List_stack_Topics);
		for(WebElement stack_elem:List_stack) {
			String text=stack_elem.getText();
			stack_Topics.add(text);
		}
		return stack_Topics;
	}
	public void OperationsInStack() {
		driver.findElement(operations_in_stack).click();
	}
	public boolean para_tryhere_display() {
		WebElement para_title=driver.findElement(paragraph_operationpage);
		WebElement try_here=driver.findElement(try_her_btn);
		System.out.println(para_title+" and "+try_here);
		return para_title.isDisplayed() && try_here.isDisplayed();
	}
	public void click_tryHereBtn() {
		driver.findElement(try_her_btn).click();
	}
	public void Editorpage_Run() {
		driver.findElement(Runbtn).click();
	}
	public void enter_valideditor() {
		WebElement editor_page=driver.findElement(print_editorpg);
	    new Actions(driver).sendKeys(editor_page,"print('Hello Selenium')").perform();
			
		}
	public void enter_Invalideditor() {
		WebElement editor_page=driver.findElement(print_editorpg);
	    new Actions(driver).sendKeys(editor_page,"prin('Hello Selenium')").perform();
		
		}
	
	public void Implementation() {
		driver.findElement(implementation_stack).click();
	}
	public void AplicationInStack() {
		driver.findElement(application_stack).click();
	}
	public String Output() {
		driver.findElement(Runbtn).click();
		String outputActualResult=null;
		try {
			WebElement output_result=driver.findElement(output_displayed);
			outputActualResult=output_result.getText();
		} catch (Exception e) {
			outputActualResult=e.getMessage();
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e2) {
				System.out.println(e2.getStackTrace());
			}
			
		}
		
		return outputActualResult;
	}
	
	public void practiceQ() {
		driver.findElement(practice_page).click();
	}

}
