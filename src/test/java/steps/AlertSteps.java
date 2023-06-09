package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class AlertSteps{

    private WebDriver driver;
    private final By alertButton = By.xpath("//button[.='Click for JS Alert']");
    private final By confirmButton = By.xpath("//button[.='Click for JS Confirm']");
    private final By promptButton = By.xpath("//button[.='Click for JS Prompt']");
    private final By result = By.id("result");


    @Given("I am on the JavaScript Alerts page")
    public void ı_am_on_the_java_script_alerts_page() {
        // Code to navigate to the alerts page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
    }

    @When("I click on the {string} button")
    public void ı_click_on_the_button(String buttonName) {
        driver.findElement(alertButton).click();
    }

    @When("I accept the alert")
    public void ı_accept_the_alert() {
        driver.switchTo().alert().accept();
    }

    @Then("I should see the result text as {string}")
    public void ı_should_see_the_result_text_as(String expectedText) {
        String actualResult = driver.findElement(result).getText();
        assertEquals(actualResult, expectedText);
    }
}
