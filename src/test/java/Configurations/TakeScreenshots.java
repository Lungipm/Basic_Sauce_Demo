package Configurations;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {

    public void takeSnapshot(WebDriver driver, String screenshotname) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotname + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            System.out.println("Screenshot Caputure Failed" + e.getMessage());
        }

    }

}
