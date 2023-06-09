package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownSteps {

    private WebDriver driver;
    private final By dropdownList = By.id("dropdown");

    // Selects the specified option from the dropdown list.
    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    // Returns a list of selected options from the dropdown list.
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    // Finds and returns the dropdown element as a Select object.
    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdownList));
    }

    @Given("I am on the Dropdown page")
    public void ı_am_on_the_dropdown_page() {
        // Click on the Dropdown link in the home page and navigate to the Dropdown page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @When("I select {string} from the dropdown")
    public void ı_select_from_the_dropdown(String string) {
        // Select an option from the dropdown
        findDropdownElement().selectByVisibleText("Option 1");
    }
    @Then("I should see {string} as the selected option")
    public void ı_should_see_as_the_selected_option(String string) {
        // Get selected options and verify that only one option is selected and it is the expected option
        var selectedOptions = getSelectedOptions();
        assertEquals(selectedOptions.size(), 1);
        assertTrue(selectedOptions.contains("option 1"));
    }
}

