package utils;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverFactory.getDriver();
        File screenshot = ScreenShotUtil.takeScreenshot(result.getName(), driver);
        LoggerUtil.error("Test failed. Screenshot saved: " + screenshot.getAbsolutePath());
    }
}

