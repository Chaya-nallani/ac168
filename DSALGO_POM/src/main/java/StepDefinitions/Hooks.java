package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.WebDriverUtil;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = WebDriverUtil.getDriver();
        driver.get("https://dsportalapp.herokuapp.com/home");
    }

    @After
    public void tearDown() {
        WebDriverUtil.quitDriver(); // Uncomment this line if you want to quit after all tests
    }
}
