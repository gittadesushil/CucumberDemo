import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageDefinition {
    //Create a web driver
    WebDriver driver = new ChromeDriver();

    @Given("Website is up and running")
    public void websiteIsUpAndRunning() {
        driver.get("https://foodstore-1.web.app/");
        String actual = driver.findElement(By.className("coverTitle")).getText();
        Assert.assertEquals("Reading the text from homepage", "You order we deliver",actual);
    }

    @And("Search functionality is implemented")
    public void searchFunctionalityIsImplemented() {
        boolean isDisplayed = driver.findElement(By.id("citySearchbtn")).isDisplayed();
        //Assert.assertTrue(isDisplayed);
    }
}
