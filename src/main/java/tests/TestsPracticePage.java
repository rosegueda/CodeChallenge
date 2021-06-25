package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base;
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
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = BrowserManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void afterMethod(){
        driver.quit();
    }

    @Test(priority = 0)
    public void Add_item_to_shopping_cart() {
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.selectItemfadedSSTS();
        pmp.closeAndValidateItemAdded();
        Assert.assertEquals(pmp.cartItemsAddedText(),"Cart 1 Product","Failed Test");
        System.out.println(pmp.cartItemsAddedText());
    }
    @Test (priority = 1)
    public void Remove_item_inside_shopping_cart() throws InterruptedException {
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.selectItemfadedSSTS();
        pmp.closeAndValidateItemAdded();
        pmp.removeItemFromCart();
        Thread.sleep(5000);
        Assert.assertEquals(pmp.cartItemsAddedText(),"Cart (empty)","Failed Test");
        System.out.println(pmp.cartItemsAddedText());
    }
    @Test (priority = 2)
    public void Add_random_item_to_shopping_cart(){
    PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.selectRandomItem();
        pmp.closeAndValidateItemAdded();
        Assert.assertEquals(pmp.cartItemsAddedText(),"Cart 1 Product","Failed Test");
        System.out.println(pmp.cartItemsAddedText());

    }
    @Test (priority = 3)
    public void Search_item_Positive_Scenario(){
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.searchRandomItemName();
        //pmp.listItemsFound();
        Assert.assertTrue(pmp.listItemsFound()>0,"Failed Test");
    }
    @Test (priority = 4)
    public void Search_item_Negative_Scenario(){
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.searchItemWithNoResult();
        Assert.assertEquals(pmp.listItemsFound(),0,"Failed Test");
    }

    @Test (priority = 5)
    public void Validate_store_information(){
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.scrollDownAndValidateStoreInformation();
    }
}



