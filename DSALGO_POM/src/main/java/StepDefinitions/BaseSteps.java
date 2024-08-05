package StepDefinitions;

import org.openqa.selenium.WebDriver;
import Pages.*;
import utilities.WebDriverUtil;

public class BaseSteps {
    protected static WebDriver driver = WebDriverUtil.getDriver();
    protected static LoginPage loginPage = new LoginPage(driver);

    public static void login(String loginname, String password) {
        loginPage.openLoginPage();
        loginPage.login(loginname, password);
    }

    public static void logout() {
        loginPage.logout();
    }

    public boolean isUserLoggedIn() {
        return loginPage.isLoggedIn();
    }
}
