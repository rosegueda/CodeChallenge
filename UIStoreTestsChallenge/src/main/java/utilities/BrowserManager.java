package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserManager {
    protected WebDriver driver;

    private WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriverv91.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeTest
     public void beforeTest(){
        driver = getDriver();
        driver.get("http://automationpractice.com/index.php");

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
