import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageDefinition {
    //Create a web driver
    WebDriver driver = new ChromeDriver();

    public HomePageDefinition(){

    }

    @Given("Website is up and running")
    public void websiteIsUpAndRunning() {

        driver.get("https://foodstore-1.web.app/");
        String actual = driver.findElement(By.className("coverTitle")).getText();
        Assert.assertEquals("Reading the text from homepage", "You order we deliver",actual);
    }

    @And("Search functionality is implemented")
    public void searchFunctionalityIsImplemented() {
        boolean isDisplayed = driver.findElement(By.id("citySearchbtn")).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @When("User enter a city name in search field")
    public void userEnterACityNameInSearchField() {
        driver.findElement(By.className("cityInput")).sendKeys("Mumbai");
    }

    @And("User click on Search button")
    public void userClickOnSearchButton() {
        driver.findElement(By.id("citySearchbtn")).click();
    }

    @Then("User should see list of hotels")
    public void userShouldSeeListOfHotels() {
        //Verification one that error is not available on the list of hotels page
        String errorText = null;
        try{
            errorText = driver.findElement(By.cssSelector(".error > span")).getText();
        }catch (NoSuchElementException nse){
            System.out.println("Exception occurred");
        }
        Assert.assertNull("Error message is not available on the page", errorText);

        //Verifying the actual hotel name

        //Explicit wait (wait for 2 sec but every 200 millSec of interval. If condition is satisfied before 2 sec then
        //return immediately
//        WebDriverWait wait = new WebDriverWait(driver, 2,200);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("res_title")));

        //fluent wait
        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(Duration.ofSeconds(2));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(java.util.NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("res_title")));

        String hotelName = driver.findElement(By.className("res_title")).getText();
        Assert.assertEquals("Prithvi Cafe",hotelName);
    }
}
