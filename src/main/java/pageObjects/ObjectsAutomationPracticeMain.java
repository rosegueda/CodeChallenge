package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectsAutomationPracticeMain {
    private WebDriver driver;
    private By searchBar = By.id("search_query_top");
    private By searchBtn = By.name("submit_search");
    private By womenCategory = By.xpath("//a[@title='Women']");
    private By addToCart1 = By.className(".button.ajax_add_to_cart_button.btn.btn-default");


    public By getSearchBar(){
        return searchBar;
    }
    public By getSearchBtn() {
        return searchBtn;
    }
    public By getWomenCategory(){
        return womenCategory;
    }
    //private By addToCart1 = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span");

    public By getAddToCart1() {
        return addToCart1;
    }
    private By itemsContainer = By.id("homefeatured");
    public By getItemsContainer() {
        return itemsContainer;
    }
    private By itemsContainerAfterSearch = By.xpath("//*[@class='product_list grid row']");

    public By getItemsContainerAfterSearch() {
        return itemsContainerAfterSearch;
    }

    private By itemsElements = By.xpath("//*[@id='homefeatured']//a[@class='product_img_link']");
    public By getItemsElements() {
        return itemsElements;
    }

    private By itemsElementsAfterSearch = By.xpath("//*[@class='product_list grid row']//img['replace-2x img-responsive']");
    public By getItemsElementsAfterSearch(){
        return itemsElementsAfterSearch;
    }

    private By product = By.className("product-image-container");
    public By getProduct() {
        return product;
    }
    private By fadedSSTSImage = By.xpath("//*[@id='homefeatured']//a[@title='Faded Short Sleeve T-shirts'][@class='product_img_link']");
    //private By fadedSSTSImage = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img");
    public By getFadedSSTSImage() {
        return fadedSSTSImage;
    }

    private By addToCartfadedSSTSImage = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span");
    public By getAddToCartfadedSSTSImage() {
        return addToCartfadedSSTSImage;
    }
    private By closeLayerCart = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span");
    public By getCloseLayerCart() {
        return closeLayerCart;
    }
    private By shoppingCart = By.xpath("//*[@class='shopping_cart']//*[text()='Cart']");
    public By getShoppingCart() {
        return shoppingCart;
    }
    private By textCart = By.xpath("//*[@class='shopping_cart']//*[@title='View my shopping cart']");
    public By getTextCart() {
        return textCart;
    }

    private By removeItemCart = By.className("ajax_cart_block_remove_link");
    public By getRemoveItemCart() {
        return removeItemCart;
    }


    private By footerContainer = By.xpath("//*[@class='footer-container']");
    public By getFooterContainer() {
        return footerContainer;
    }

    private By socialBlock = By.xpath("//*[@class='footer-container']//*[@id='social_block']//li");

    public By getSocialBlock() {
        return socialBlock;
    }

    private By storeInformation = By.xpath("//*[@class='footer-container']//*[@id='block_contact_infos']//li");

    public By getStoreInformation() {
        return storeInformation;
    }

    private By footerSections = By.xpath("//*[@class='footer-container']//h4");

    public By getFooterSections() {
        return footerSections;
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void SearchItem (){

    }
}
