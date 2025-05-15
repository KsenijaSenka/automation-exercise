package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

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

