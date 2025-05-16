package tests.base;

import config.EnvLoader;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.TestCasesLinksPage;
import pages.decorators.RetryTestCasesLinksPageDecorator;
import utils.LoggerUtil;
import utils.TestListener;

import java.io.IOException;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected TestCasesLinksPage testCasesLinksPage;

    public BaseTest() {
    }

    @Parameters({"env"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("test") String env) throws IOException {
        LoggerUtil.info("Starting test setup for environment: " + env);
        EnvLoader.load(env);

        driver = DriverFactory.getDriver();
        LoggerUtil.info("Browser launched successfully.");
        driver.get("https://www.automationexercise.com/");

        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        testCasesLinksPage = new RetryTestCasesLinksPageDecorator(driver, 3);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        LoggerUtil.info("Quitting driver after test execution.");
        DriverFactory.quitDriver();
    }

}
