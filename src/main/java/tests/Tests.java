package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import start.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.ObjectsAutomationPracticeMain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tests {
WebDriver driver;

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

    @Test (priority = 0)
    public void Add_item_to_shopping_cart(){
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fadedSSTSImage = driver.findElement(page.getFadedSSTSImage());
        //WebElement firstProduct = driver.findElement(page.getItemsContainer()).findElement(page.getProduct());
        js.executeScript("arguments[0].scrollIntoView();", fadedSSTSImage);

       WebElement addToCartfadedSSTSImage = driver.findElement(page.getAddToCartfadedSSTSImage());
        Actions action = new Actions(driver);
        //action.moveByOffset(78,75).perform();
        action.moveToElement(fadedSSTSImage).perform();
        addToCartfadedSSTSImage.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(page.getCloseLayerCart()));
        WebElement closeLayerCart = driver.findElement(page.getCloseLayerCart());
        closeLayerCart.click();
        //driver.findElement(By.xpath("//*[@class='shopping_cart']//*[text()='Cart']")).click();
//        WebElement shoppingCart = driver.findElement(page.getCloseLayerCart());
//        shoppingCart.click();
        WebElement textCart = driver.findElement(page.getTextCart());
        String actualElements =  textCart.getText();
//        if (actualElements.contentEquals("Cart 1 Product")) {
//            System.out.println("Item added correctly: " + textCart.getText());
//        } else {
//            Assert.fail("Failed Test");
//        }
        Assert.assertTrue(actualElements.contentEquals("Cart 1 Product"), "Failed Test");
        System.out.println("Item added correctly: " + textCart.getText());
//        WebElement textCart = driver.findElement(By.xpath("//*[@class='shopping_cart']//*[@title='View my shopping cart']"));
//        System.out.println(textCart.getText());
//        WebElement TxtBoxContent = driver.findElement(By.className("shopping_cart"));
//        System.out.println("Printing " + TxtBoxContent.getAttribute("value"));
//        System.out.println("Page title is : " + driver.getTitle());
//        List<WebElement> ele = driver.findElements(By.tagName("frame"));
//        System.out.println("Number of frames in a page :" + ele.size());
//        for(WebElement el : ele){
//            //Returns the Id of a frame.
//            System.out.println("Frame Id :" + el.getAttribute("id"));
//            //Returns the Name of a frame.
//            System.out.println("Frame name :" + el.getAttribute("name"));
//        }
    }
    @Test (priority = 1)
    public void Remove_item_inside_shopping_cart() throws InterruptedException{
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fadedSSTSImage = driver.findElement(page.getFadedSSTSImage());
        js.executeScript("arguments[0].scrollIntoView();", fadedSSTSImage);

        WebElement addToChartfadedSSTSImage = driver.findElement(page.getAddToCartfadedSSTSImage());
        Actions action = new Actions(driver);
        action.moveToElement(fadedSSTSImage).perform();
        addToChartfadedSSTSImage.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement closeLayerCart = driver.findElement(page.getCloseLayerCart());
        closeLayerCart.click();

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,-1000)");
        WebElement shoppingCart = driver.findElement(page.getShoppingCart());
        //shoppingCart.click();
        action.moveToElement(shoppingCart).perform();
        WebElement removeItemCart = driver.findElement(page.getRemoveItemCart());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        removeItemCart.click();
        Thread.sleep(5000);

        WebElement textCart = driver.findElement(page.getTextCart());
        String actualElements =  textCart.getText();
        //System.out.println("Item added correctly: " + textCart.getText());
        if (actualElements.contentEquals("Cart (empty)")) {
            System.out.println("Item remove correctly: " + textCart.getText());
        } else {
            Assert.fail("Failed Test");
        }
    }
    @Test (priority = 2)
    public void Add_random_item_to_shopping_cart(){
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> itemsElements = driver.findElements(page.getItemsElements());
        Random r = new Random();
        int randomValue = r.nextInt(itemsElements.size());
        //System.out.println(randomValue);
        int randomItem = randomValue + 1;
        System.out.println("Single random Item added: " + randomItem);
        Actions action = new Actions(driver);
        js.executeScript("arguments[0].scrollIntoView();", itemsElements.get(randomValue));
        action.moveToElement(itemsElements.get(randomValue)).perform();
        //driver.findElement(By.xpath("//*[@id='homefeatured']//a[@title='Add to cart']")).click();
        driver.findElement(By.xpath("//*[@id='homefeatured']//a[@data-id-product='"+randomItem+"']")).click();
        //itemsElements.get(randomValue).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(page.getCloseLayerCart()));
        WebElement closeLayerCart = driver.findElement(page.getCloseLayerCart());
        closeLayerCart.click();
        WebElement textCart = driver.findElement(page.getTextCart());
        String actualElements =  textCart.getText();
        Assert.assertTrue(actualElements.contentEquals("Cart 1 Product"), "Failed Test");
        System.out.println("Item randomly added correctly: " + textCart.getText());
    }
    @Test (priority = 3)
    public void Search_item_Positive_Scenario() throws InterruptedException {
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        WebElement searchBar = driver.findElement(page.getSearchBar());
        List<WebElement> itemsElements = driver.findElements(page.getItemsElements());
//        for(WebElement el:itemsElements)
//        {
//            System.out.println(el.getAttribute("title"));
//        }
        Random r = new Random();
        int randomValue = r.nextInt(itemsElements.size());
        //System.out.println(randomValue);
        String randomElementName = itemsElements.get(randomValue).getAttribute("title");
        System.out.println("Search Item: "+randomElementName);
        searchBar.sendKeys(randomElementName);
        WebElement searchBtn = driver.findElement(page.getSearchBtn());
        searchBtn.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        List<WebElement> searchResult = driver.findElements(page.getItemsElementsAfterSearch());
        System.out.println("Number of Items search result: " + searchResult.size());
        Assert.assertTrue(searchResult.size()>0, "Failed Test");
        System.out.println("Item(s) found after search: ");
        for(WebElement el:searchResult)
        {
            System.out.println("- "+el.getAttribute("title"));
        }

    }
    @Test (priority = 4)
    public void Search_item_Negative_Scenario() throws InterruptedException {
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        WebElement searchBar = driver.findElement(page.getSearchBar());
        searchBar.sendKeys("Ricardo");
        WebElement searchBtn = driver.findElement(page.getSearchBtn());
        searchBtn.click();
        Thread.sleep(5000);
        List<WebElement> searchResult = driver.findElements(page.getItemsElementsAfterSearch());
        System.out.println("Number of Items search result: " + searchResult.size());
        Assert.assertTrue(searchResult.size()<1, "Failed Test");
        WebElement alertText = driver.findElement(By.xpath("//*[@class='alert alert-warning']"));
        //alertText.getText();
        System.out.println("Message for 0 result: "+alertText.getText());
    }
    @Test (priority = 5)
    public void Validate_store_information(){
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footerContainer = driver.findElement(page.getFooterContainer());
        js.executeScript("arguments[0].scrollIntoView();", footerContainer);
        System.out.println("Store Information: ");
        List<WebElement> storeInformation = driver.findElements(page.getStoreInformation());
        for(WebElement el:storeInformation)
        {
            System.out.println("- "+el.getText());
        }
    }
    @Test (priority = 6)
    public void Footer_information(){
        ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footerContainer = driver.findElement(page.getFooterContainer());
        js.executeScript("arguments[0].scrollIntoView();", footerContainer);
        System.out.println("List of Social Media: ");
        List<WebElement> socialBlockList = driver.findElements(page.getSocialBlock());
        for(WebElement el:socialBlockList)
        {
            System.out.println("- "+el.getAttribute("class"));
            //System.out.println(el.getClass());
        }
        System.out.println("List of Sections: ");
        List<WebElement> footerSections = driver.findElements(page.getFooterSections());
        for(WebElement el:footerSections)
        {
            //System.out.println("- "+el.getAttribute("h4"));
            System.out.println("- "+el.getText());
        }
    }
}
