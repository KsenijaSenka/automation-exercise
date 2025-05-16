package utils;

import driver.DriverFactory;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
    private final AllureScreenshotLogger allureLogger = new AllureScreenshotLogger();
    private final LocalScreenshotSaver saver = new LocalScreenshotSaver();

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null && driver instanceof TakesScreenshot) {
            String testName = result.getMethod().getMethodName();
            allureLogger.attachScreenshot(driver);
            saver.saveScreenshot(driver, testName);
        }
    }
}

