import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.*;

public class FSW03Definition {
    WebDriver driver = BrowserDriver.GetDriver();

    @When("User click on SignIn button")
    public void userClickOnSignInButton() {
        driver.findElement(By.cssSelector(".headerBtns .signin")).click();
    }
}
