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

import java.util.List;

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

        //Thread sleep is not recommended in automation script. DO NOT USE THIS!
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Verifying the actual hotel name
        String hotelName = driver.findElement(By.className("res_title")).getText();
        Assert.assertEquals("Prithvi Cafe",hotelName);
    }
}
