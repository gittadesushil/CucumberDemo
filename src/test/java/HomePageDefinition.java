import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import Utility.*;


public class HomePageDefinition {
    //Create a web driver
      WebDriver driver = null;

    public HomePageDefinition(){
        driver = BrowserDriver.GetDriver();
    }

    @Given("Website is up and running")
    public void websiteIsUpAndRunning() {

        driver.get("https://foodstore-1.web.app/");
        String actual = driver.findElement(By.className("coverTitle")).getText();
        Assert.assertEquals("Reading the text from homepage", "You order we deliver",actual);

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File("ScreenShots/src/test/java/newimage.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
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

        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(2));//frequency
        wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("res_title")));

        String hotelName = driver.findElement(By.className("res_title")).getText();
        Assert.assertEquals("Prithvi Cafe",hotelName);
    }

    @When("User press keyboard ENTER key")
    public void userPressKeyboardENTERKey() {
        Actions actionProvider = new Actions(driver);
        Action enter = actionProvider.sendKeys(Keys.ENTER).build();
        enter.perform();
    }
}
