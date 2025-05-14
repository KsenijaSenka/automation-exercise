package utils;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver != null && driver instanceof TakesScreenshot) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            io.qameta.allure.Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshotBytes));

            String testName = result.getMethod().getMethodName();
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            Path screenshotDir = Paths.get("target", "screenshots"); // Known location for Jenkins
            Path screenshotPath = screenshotDir.resolve(testName + "_" + timestamp + ".png");

            try {
                Files.createDirectories(screenshotDir);
                Files.write(screenshotPath, screenshotBytes);
                System.out.println("Saved screenshot to: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

