package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutOverview {

    WebDriver driver;

    public void CheckoutOverview() {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement overview_checkoutTitle;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement overview_finishButton;

    @FindBy(xpath = "//button[contains(@id,'cancel')]")
    WebElement cancel_checkout;

    public void verify_checkoutOverview() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(overview_checkoutTitle));
        Assert.assertTrue(overview_checkoutTitle.isDisplayed());
    }


    public void click_finishButton() {
        overview_finishButton.click();
    }

}
