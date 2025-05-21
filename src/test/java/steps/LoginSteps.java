package steps;

import config.EnvLoader;
import driver.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp() throws IOException {
        String env = System.getProperty("env");
        if (env == null || env.isEmpty()) {
            env = "test";
        }
        EnvLoader.load(env);

        driver = DriverFactory.getDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginToAccountTextVisible());
    }

    @When("^User (?:enters|types) email \"([^\"]*)\" (?:and|with) password \"([^\"]*)\"$")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.setEmail(email).setPassword(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.isLoginErrorVisible());
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

