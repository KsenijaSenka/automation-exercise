package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {
    private static final String SCREENSHOTS_DIR = "screenshots/";

    public static File takeScreenshot(String testName, WebDriver driver) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = testName + "_" + timestamp + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(SCREENSHOTS_DIR + filename);

        try {
            Files.createDirectories(Paths.get(SCREENSHOTS_DIR));
            Files.copy(screenshotFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destFile;
    }
}
