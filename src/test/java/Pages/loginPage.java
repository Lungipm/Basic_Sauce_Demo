package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPage {

    //Elements and actions for Login page
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[contains(@id,'user-name')]")
    WebElement xpath_username;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    WebElement xpath_password;

    @FindBy(id = "login-button")
    WebElement xpath_login;

    @FindBy(xpath = "//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement xpath_FailedLogin_Message;

    public void enterUsername(String Username) {

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(xpath_username));
        xpath_username.clear();
        xpath_username.sendKeys(Username);
    }

    public void enterPassword(String Password) {
        xpath_password.clear();
        xpath_password.sendKeys(Password);
    }

    public void clickLogin() {
        xpath_login.click();
    }

    public void verify_incorrect_Logins() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(xpath_FailedLogin_Message));
        Assert.assertEquals(xpath_FailedLogin_Message, "Username and password do not match any user in this service");

    }

}
