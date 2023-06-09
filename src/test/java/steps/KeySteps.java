package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class KeySteps {

    private WebDriver driver;
    private final By textField = By.id("target");
    private final By resultText = By.id("result");

    // Enters the given text in the text field
    public void enterText(String text){
        driver.findElement(textField).sendKeys(text);
    }

    // Enters the keystrokes for "Alt + p" followed by "= 3.14"
    public void enterPi(){
        enterText(Keys.chord(Keys.ALT,"p") + "= 3.14");
    }

    // Returns the text of the result element on the page
    public String getResult(){
        return driver.findElement(resultText).getText();
    }

    @Given("I am on the Key Presses page")
    public void ı_am_on_the_key_presses_page() {
        // Click on the Key Presses link in the home page and navigate to the Key Presses page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Key Presses")).click();
    }
    @When("I enter the text {string} followed by the BACK_SPACE key")
    public void ı_enter_the_text_followed_by_the_back_space_key(String string) {
        // Enter the text "A" followed by the BACK_SPACE key
        enterText("A" + Keys.BACK_SPACE);
    }
    @Then("I should see the result as {string}")
    public void ı_should_see_the_result_as(String string) {
        // Verify that the result text matches the expected value
        assertEquals(getResult(), "You entered: BACK_SPACE");
    }
}
