package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ClickSteps {

    private WebDriver driver;
    private final By frame = By.id("hot-spot");

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Code to navigate to the home page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @When("I click on the Context Menu link")
    public void i_click_on_the_context_menu_link() {
        // Code to click on the Context Menu link
        driver.findElement(By.linkText("Context Menu")).click();
    }

    @Then("I perform a context click action")
    public void i_perform_a_context_click_action() {
        // Code to perform the context click action
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(frame);
        actions.contextClick(target).perform();
    }

    @Then("I should see a context menu alert with the message {string}")
    public void i_should_see_a_context_menu_alert_with_the_message(String expectedMessage) {
        // Code to verify the context menu alert message
        // ...
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();
    }
}
