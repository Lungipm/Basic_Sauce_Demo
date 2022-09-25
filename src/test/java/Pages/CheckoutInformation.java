package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutInformation {

    // elements and actions for Checkout: Your information
    WebDriver driver;

    public void CheckoutInformation() {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkout_Information;

    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement checkout_firstname;

    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement checkout_lastname;

    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement checkout_postalcode;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement checkout_continueButton;

            public void verify_checkoutInformation() {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(checkout_Information));
            Assert.assertTrue(checkout_Information.isDisplayed());
    }

    public void enter_firstName(String Firstname) {
        checkout_firstname.sendKeys(Firstname);
    }

    public void enter_lastName(String Lastname) {
        checkout_lastname.sendKeys(Lastname);
    }

    public void enter_postalCode(String postalCode) {
        checkout_postalcode.sendKeys(postalCode);
    }

    public void click_ContinueButton() {
        checkout_continueButton.click();
    }

}
