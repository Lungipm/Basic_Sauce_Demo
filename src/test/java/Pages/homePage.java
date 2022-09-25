package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage {

    //Elements and actions for home page
    WebDriver driver;

    //Constructor
    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement title_products;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cart_icon;

    //elements to add to cart
    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement add_Backpack;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement add_bikeLight;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-fleece-jacket')]")
    WebElement add_fleeceJacket;


    // Inspect elements to remove from cart
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")
    WebElement backpack_removal;

    @FindBy(xpath = "//button[contains(@id,'remove-sauce-labs-bike-light')]")
    WebElement bikeLight_removal;

    @FindBy(xpath = "//button[contains(@id,'remove-sauce-labs-fleece-jacket')]")
    WebElement fleeceJacket_removal;


    public void verify_products_page_launched() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(title_products));
        Assert.assertTrue(title_products.isDisplayed());
    }

    public void backpack_AddtoCart() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(add_Backpack));
        add_Backpack.click();
    }
    public void bikeLight_AddtoCart() {
        add_bikeLight.click();
    }
    public void fleece_AddtoCart() {
        add_fleeceJacket.click();
    }

    //Methods to remove items from Cart
    public void remove_backpack() {
        new WebDriverWait(driver, 15).until((ExpectedConditions.visibilityOf(backpack_removal)));
        backpack_removal.click();
    }
    public void remove_bikeLight() {
        new WebDriverWait(driver, 15).until((ExpectedConditions.visibilityOf(bikeLight_removal)));
        bikeLight_removal.click();
    }
    public void remove_fleeceJacket() {
        new WebDriverWait(driver, 15).until((ExpectedConditions.visibilityOf(fleeceJacket_removal)));
        fleeceJacket_removal.click();
    }

    public void click_cart_icon() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(cart_icon));
        cart_icon.click();
    }

}

