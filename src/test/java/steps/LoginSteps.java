package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;


    @Given("I am on the login page of the Para Bank Application")
    public void i_am_on_the_login_page_of_the_Para_Bank_Application() {
        // Code to navigate to the login page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter invalid credentials")
    public void ıEnterInvalidCredentials() {
        // Code to enter valid credentials
        driver.findElement(By.name("username")).sendKeys("tautester");
        driver.findElement(By.name("password")).sendKeys("password");
    }

    @When("click on the login button")
    public void click_on_the_login_button() {
        // Code to click on the login button
        driver.findElement(By.xpath("//input[@class='button']")).click();
    }

    @Then("I should not be logged in successfully")
    public void i_should_not_be_logged_in_successfully() {
        // Code to verify successful login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error']")));

        driver.quit();
    }
}
