package start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriverv91.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
