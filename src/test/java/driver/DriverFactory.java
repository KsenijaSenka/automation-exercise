package driver;

import config.EnvLoader;
import driver.strategy.BrowserStrategy;
import driver.strategy.ChromeStrategy;
import driver.strategy.EdgeStrategy;
import driver.strategy.FirefoxStrategy;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    private static final Map<String, BrowserStrategy> strategies = Map.of(
            "chrome", new ChromeStrategy(),
            "firefox", new FirefoxStrategy(),
            "edge", new EdgeStrategy()
    );

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");

            if (browser == null || browser.isEmpty()) {
                browser = EnvLoader.getProperty("browser");
            }

            browser = browser.toLowerCase();
            BrowserStrategy strategy = strategies.get(browser);

            if (strategy == null) {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver = strategy.createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

