package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.WebDriverUtil;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
    features = "src/main/java/Features", // Path to your feature files
    glue = "StepDefinitions",                 // Package containing step definitions
  //tags = "@Login or @SignOut",                          // Tags to include specific scenarios
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for reports
    monochrome = true                         // Clean console output
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void getDriver() {
        // Setup method if you need to initialize any resources
    	WebDriverUtil.getDriver();
    }

    @AfterClass
    public void quitDriver() {
        // Teardown method if you need to clean up resources
    }
}
