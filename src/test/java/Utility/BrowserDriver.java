package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    static WebDriver driver = new ChromeDriver();

    public static WebDriver GetDriver(){
        return driver;
    }
}
