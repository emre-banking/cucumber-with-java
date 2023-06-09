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

public class HorizontalSliderSteps {

    private WebDriver driver;
    private final By slider = By.xpath("//input[@value='0']");
    private final By range = By.id("range");

    // Moves the slider to the right by pressing the right arrow key
    public void moveSliderRight(int value){
        for (int i=0;i<value;i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    // Returns the text value of the range element
    public String getRange(){
        return driver.findElement(range).getText();
    }

    @Given("I am on the Horizontal Slider page")
    public void ı_am_on_the_horizontal_slider_page() {
        // Click on the Horizontal Slider link in the home page and navigate to the Horizontal Slider page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Horizontal Slider")).click();
    }
    @When("I move the slider to the right by {int} units")
    public void ı_move_the_slider_to_the_right_by_units(Integer int1) {
        // Move the slider to the right by a specified value
        moveSliderRight(6);
    }
    @Then("I should see the range value as {string}")
    public void ı_should_see_the_range_value_as(String string) {
        // Get the range value from the slider and verify that it matches the expected value
        assertEquals(getRange(), "3");
    }
}
