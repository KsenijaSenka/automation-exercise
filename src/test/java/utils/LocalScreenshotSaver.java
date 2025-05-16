package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalScreenshotSaver {
    public void saveScreenshot(WebDriver driver, String testName) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Path path = Paths.get("target", "screenshots", testName + "_" + timestamp + ".png");

        try {
            Files.createDirectories(path.getParent());
            Files.write(path, screenshotBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

