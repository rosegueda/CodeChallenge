package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PracticeMainPage;
import utilities.BrowserManager;

public class TestsPracticePage extends BrowserManager{

    @Test(priority = 0)
    public void Add_item_to_shopping_cart() {
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.selectItemfadedSSTS();
        pmp.closeAndValidateItemAdded();
        Assert.assertEquals(pmp.cartItemsAddedText(),"Cart 1 Product","Failed Test");
        System.out.println(pmp.cartItemsAddedText());
    }
    @Test (priority = 1)
    public void Remove_item_inside_shopping_cart(){
        PracticeMainPage pmp = new PracticeMainPage(driver);
        pmp.selectItemfadedSSTS();
        pmp.closeAndValidateItemAdded();
        pmp.removeItemFromCart();
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



