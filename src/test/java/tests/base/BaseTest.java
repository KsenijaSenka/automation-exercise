package tests.base;

import config.EnvLoader;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.LoggerUtil;
import utils.TestListener;

import java.io.IOException;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homePage;


    public BaseTest() {
    }

    @Parameters({"env", "browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("test") String env, @Optional("chrome") String browser) throws IOException {
        LoggerUtil.info("Starting test setup on browser: " + browser);
        EnvLoader.load(env);

        driver = DriverFactory.getDriver(browser);
        LoggerUtil.info("Browser launched successfully.");
        driver.get("https://www.automationexercise.com/");

        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        LoggerUtil.info("Quitting driver after test execution.");
        DriverFactory.quitDriver();
    }

}
