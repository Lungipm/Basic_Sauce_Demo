package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

    // Elements and actions for Cart page

    WebDriver driver;

    public void CartPage() {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(.,'Your Cart')]")
    WebElement xpath_cartLabel;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Bike Light')]")
    WebElement cart_bikeLight;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Fleece Jacket')]")
    WebElement cart_fleeceJacket;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement cart_backpack;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement cart_checkoutButton;

    @FindBy(xpath = "//button[contains(@id,'continue-shopping')]")
    WebElement cart_continueShopping;

    public void verify_Cart_page_displayed() {
        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOf(xpath_cartLabel));
        Assert.assertTrue(xpath_cartLabel.isDisplayed());
        System.out.println("'YOUR CART' page is displayed");
    }

    public void verify_items_in_cart(){
        if((cart_bikeLight.isDisplayed()) && (cart_backpack.isDisplayed()) && (cart_fleeceJacket.isDisplayed())) {
            System.out.println("Selected Items are added to Cart");
            cart_checkoutButton.click();

        } else {
            System.out.println("Selected Items are not in the Cart");
            cart_continueShopping.click();
        }

    //toDo: Research to refactor my code to not hardcode selected items, so that code is re-usable for another list of items.

    }

}







