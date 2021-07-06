package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FrequentCommands;

import java.util.List;
import java.util.Random;

public class PracticeMainPage extends FrequentCommands {
    public PracticeMainPage(WebDriver driver) {
        super(driver);
    }

        By searchBar = By.id("search_query_top");
        By searchBtn = By.name("submit_search");
        By womenCategory = By.xpath("//a[@title='Women']");
        By addToCart1 = By.className(".button.ajax_add_to_cart_button.btn.btn-default");
        By itemsContainer = By.id("homefeatured");
        By fadedSSTSImage = By.xpath("//*[@id='homefeatured']//a[@title='Faded Short Sleeve T-shirts'][@class='product_img_link']");
        By addToCartfadedSSTSImage = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span");
        By closeLayerCart = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span");
        By textCart = By.xpath("//*[@class='shopping_cart']//*[@title='View my shopping cart']");
        By shoppingCart = By.xpath("//*[@class='shopping_cart']//*[text()='Cart']");
        By removeItemCart = By.className("ajax_cart_block_remove_link");
        By itemsElements = By.xpath("//*[@id='homefeatured']//a[@class='product_img_link']");
        By itemsElementsAfterSearch = By.xpath("//*[@class='product_list grid row']//img['replace-2x img-responsive']");
        By alertTextNoResults = By.xpath("//*[@class='alert alert-warning']");
        By footerContainer = By.xpath("//*[@class='footer-container']");
        By storeInformation = By.xpath("//*[@class='footer-container']//*[@id='block_contact_infos']//li");

        public void selectItemfadedSSTS() {

            Actions action = new Actions(driver);
            action.moveToElement(findElement(fadedSSTSImage)).build().perform();
            click(addToCartfadedSSTSImage);
        }
        public void closeAndValidateItemAdded() {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(closeLayerCart));
            findElement(closeLayerCart);
            click(closeLayerCart);
        }
        public String cartItemsAddedText(){
            findElement(textCart);
            return getText(textCart);
        }
        public void removeItemFromCart(){
            Actions action = new Actions(driver);
            String itemText = cartItemsAddedText();
            action.moveToElement(findElement(shoppingCart)).build().perform();
            WebDriverWait wait = new WebDriverWait(driver,10);
            findElement(removeItemCart);
            click(removeItemCart);
            wait.until(ExpectedConditions.not(ExpectedConditions.
                    textToBe(textCart,itemText)));
        }
        public void selectRandomItem(){
            List<WebElement> el = findElements(itemsElements);
            Random r = new Random();
            int randomValue = r.nextInt(el.size());
            int randomItem = randomValue + 1;
            Actions action = new Actions(driver);
            WebElement randomEl = el.get(randomValue);
            action.moveToElement(randomEl).build().perform();
            driver.findElement(By.xpath("//*[@id='homefeatured']//a[@data-id-product='"+randomItem+"']")).click();
            System.out.println("random element: "+randomValue);
        }
        public void searchRandomItemName(){
            List<WebElement> el = findElements(itemsElements);
            Random r = new Random();
            int randomValue = r.nextInt(el.size());
            String randomElementName = el.get(randomValue).getAttribute("title");
            System.out.println("Search Item: "+randomElementName);
            type(randomElementName,searchBar);
            click(searchBtn);
        }

        public void searchItemWithNoResult(){
            String TypedWord = "Ricardo";
            System.out.println("Search Item: "+TypedWord);
            type(TypedWord,searchBar);
            click(searchBtn);
        }
        //public void listItemsFound(){
            public int listItemsFound(){
            List<WebElement> searchResult = findElements(itemsElementsAfterSearch);
            System.out.println("Number of Items search result: " + searchResult.size());
            System.out.println("Item(s) found after search: ");
            if (searchResult.size()>0){
                for(WebElement el:searchResult)
            {
                System.out.println("- "+el.getAttribute("title"));
            }} else {
                System.out.println("Message for 0 result: "+findElement(alertTextNoResults).getText());
            }
            return searchResult.size();
        }
        public void scrollDownAndValidateStoreInformation(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", findElement(footerContainer));
            System.out.println("Store Information: ");
            List<WebElement> storeInfo = findElements(storeInformation);
            for(WebElement el:storeInfo)
            {
                System.out.println("- "+el.getText());
            }
        }
    }