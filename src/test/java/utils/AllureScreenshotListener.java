package utils;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;

//import static utils.LoggerUtil.logger;

public class AllureScreenshotListener {
public static void attachScreenshot(WebDriver driver, String name) {
    if (driver != null && driver instanceof TakesScreenshot) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }
}

public static void attachText(String name, String content) {
    Allure.addAttachment(name, content);
}
}

