package StepDefinitions;

import io.cucumber.java.en.*;
import java.util.List;
import org.openqa.selenium.WebDriver;
import Pages.*;
import utilities.WebDriverUtil;

public class DSAlgoPagesSteps {
    private WebDriver driver = WebDriverUtil.getDriver();
    private DataStructuresPage dataStructuresPage = new DataStructuresPage(driver);

    @When("User hit DataStructures Page")
    public void user_hit_data_structures_Page() {
        dataStructuresPage.clickDataStructures();
    }

    @Then("User should see the following text:")
    public void user_should_see_text(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedTexts = dataTable.asList(String.class);
        for (String expectedText : expectedTexts) {
            if (dataStructuresPage.verifyTextPresent(expectedText)) {
                System.out.println("Text is present: " + expectedText);
            } else {
                System.out.println("Text is not present: " + expectedText);
            }
        }
    }

    @When("User hit Array Page")
    public void user_hit_array_page() {
        // Similar implementation as DataStructuresPage
    }

    @When("User hit Linked List Page")
    public void user_hit_linked_list_page() {
        // Similar implementation as DataStructuresPage
    }
}
