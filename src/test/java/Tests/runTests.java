package Tests;

import Configurations.TakeScreenshots;
import Configurations.browserSetup;
import Configurations.extentReport;
import Pages.loginPage;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class runTests extends extentReport {

    public static String dir = System.getProperty("user.dir");
    String dataSheet = dir + ("/TestData/data.xlsx");
    FileInputStream fis = new FileInputStream(dataSheet);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);


    //call browser setup to launch
    WebDriver driver = browserSetup.startBrowser("ChroMe", "https://www.saucedemo.com/");
    loginPage login = PageFactory.initElements(driver, loginPage.class);
    TakeScreenshots takingScreenshot = PageFactory.initElements(driver, TakeScreenshots.class);

    public runTests() throws IOException {}


    @Test (priority = 1)
    public void loginWithInvalidDetails() throws InterruptedException {

        //Read from excel

        XSSFSheet sheet = workbook.getSheetAt(0);
        String user_name=sheet.getRow(2).getCell(0).getStringCellValue();
        String user_password=sheet.getRow(2).getCell(1).getStringCellValue();


        test=extent.createTest("Login", "Login: invalid details");
        test.log(Status.INFO, "****Login: invalid details tests started*****");
        takingScreenshot.takeSnapshot(driver, "Login Page"); //use wherever a screenshot is needed

        login.enterUsername(user_name);
        login.enterPassword(user_password);
        login.clickLogin();
        Thread.sleep(2000);
        takingScreenshot.takeSnapshot(driver, "Login Error");

        test.log(Status.INFO, "*****Login: invalid details tests completed");
    }

    @Test(priority = 2)
    public void loginWithvalidDetails() {
        test=extent.createTest("Login", "Login: valid details");
        test.log(Status.INFO, "****Login: valid details tests started*****");
        takingScreenshot.takeSnapshot(driver, "Login Page"); //use wherever a screenshot is needed

        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        takingScreenshot.takeSnapshot(driver, "Login Success");

        test.log(Status.INFO, "*****Login: valid details tests completed");
    }

    /*
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    } */

}
