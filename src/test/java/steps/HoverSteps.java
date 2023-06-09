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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverSteps {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    // Performs a hover action on the specified figure element
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    @Given("I am on the Hovers page")
    public void ı_am_on_the_hovers_page() {
        // Click on the Hovers link in the home page and navigate to the Hovers page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Hovers")).click();
    }
    @When("I hover over the first user figure")
    public void ı_hover_over_the_first_user_figure() {
        // Hover over the first user figure and retrieve the caption
        hoverOverFigure(1);
    }
    @Then("I should see the caption displayed")
    public void ı_should_see_the_caption_displayed() {
        // Verify that the caption is displayed
        assertTrue(FigureCaption.isCaptionDisplayed());
    }
    @Then("the caption title should be {string}")
    public void the_caption_title_should_be(String string) {
        // Verify the title of the caption
        assertEquals(FigureCaption.getTitle(), "name: user1");
    }
    @Then("the caption link text should be {string}")
    public void the_caption_link_text_should_be(String string) {
        // Verify the link text of the caption
        assertEquals(FigureCaption.getLinkText(), "View profile");

    }
    @Then("the caption link URL should end with {string}")
    public void the_caption_link_url_should_end_with(String string) {
        // Verify the link URL of the caption
        assertTrue(FigureCaption.getLink().endsWith("/users/1"));
    }

    public static class FigureCaption {
        private static WebElement caption;
        private static final By header = By.tagName("h5");
        private static final By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            FigureCaption.caption = caption;
        }

        // Checks if the caption is displayed
        public static boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        // Returns the text of the header element within the caption
        public static String getTitle(){
            return caption.findElement(header).getText();
        }

        // Returns the href attribute value of the link element within the caption
        public static String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        // Returns the text of the link element within the caption
        public static String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
