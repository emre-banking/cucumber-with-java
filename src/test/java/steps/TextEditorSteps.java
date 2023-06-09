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

public class TextEditorSteps {

    private WebDriver driver;
    private final By textArea = By.id("tinymce");

    // Clears the content of the text area in the editor
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        switchToMainArea();
    }

    // Sets the content of the text area in the editor
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    // Retrieves the text from the text area in the editor
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    // Switches the driver's focus to the editor's iframe
    private void switchToEditArea(){
        String editorIframeId = "mce_0_ifr";
        driver.switchTo().frame(editorIframeId);
    }

    // Switches the driver's focus back to the main area from the editor's iframe
    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    @Given("I am on the WYSIWYG Editor page")
    public void ı_am_on_the_wysıwyg_editor_page() {
        // Click on the WYSIWYG Editor link in the home page and navigate to the WYSIWYG Editor page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("WYSIWYG Editor")).click();
    }
    @When("I clear the text area in the editor")
    public void ı_clear_the_text_area_in_the_editor() {
        // Clear the text area in the editor
        clearTextArea();
    }
    @When("I set the text area to {string}")
    public void ı_set_the_text_area_to(String string) {
        // Set new text
        setTextArea("TAU rocks!");
    }
    @Then("I should see {string} as the text in the editor")
    public void ı_should_see_as_the_text_in_the_editor(String string) {
        // Get the text from the editor and verify that it matches the expected text
        assertEquals(getTextFromEditor(), "TAU rocks!");
    }
}
