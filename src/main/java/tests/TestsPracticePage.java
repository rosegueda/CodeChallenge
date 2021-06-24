package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.PracticeMainPage;
import start.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.ObjectsAutomationPracticeMain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestsPracticePage {
    private WebDriver driver;
    PracticeMainPage practiceMainPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = BrowserManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //@AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test(priority= 0)
    public void Add_item_to_shopping_cart() {
    practiceMainPage.selectItemfadedSSTS();

    }
    }


