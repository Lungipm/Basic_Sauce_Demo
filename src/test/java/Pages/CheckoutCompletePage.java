package Pages;

import jdk.jshell.MethodSnippet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutCompletePage {

    WebDriver driver;

    public CheckoutCompletePage () {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(.,'Checkout: Complete!')]")
    WebElement checkoutcomplete_title;

    @FindBy(xpath = "//h2[contains(.,'THANK YOU FOR YOUR ORDER')]")
    WebElement order_success;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement checkoutcomplete_backHome;

    public void verify_title_checkoutComplete() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(checkoutcomplete_title));
        Assert.assertTrue(checkoutcomplete_title.isDisplayed());

    }


}
