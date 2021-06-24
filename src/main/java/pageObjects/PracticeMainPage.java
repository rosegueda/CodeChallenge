package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PracticeMainPage extends Base{
    public PracticeMainPage(WebDriver driver) {
        super(driver);
    }
    WebDriver driver;

        By searchBar = By.id("search_query_top");
        By searchBtn = By.name("submit_search");
        By womenCategory = By.xpath("//a[@title='Women']");
        By addToCart1 = By.className(".button.ajax_add_to_cart_button.btn.btn-default");
        By itemsContainer = By.id("homefeatured");
        By fadedSSTSImage = By.xpath("//*[@id='homefeatured']//a[@title='Faded Short Sleeve T-shirts'][@class='product_img_link']");
        By addToCartfadedSSTSImage = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span");

        public void selectItemfadedSSTS() {
            ObjectsAutomationPracticeMain page = new ObjectsAutomationPracticeMain();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            findElement(fadedSSTSImage);
            js.executeScript("arguments[0].scrollIntoView();", fadedSSTSImage);
            findElement(addToCartfadedSSTSImage);
            Actions action = new Actions(driver);
            action.moveToElement((WebElement) fadedSSTSImage);
            click(fadedSSTSImage);
        }
    }


