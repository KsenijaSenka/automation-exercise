package tests.regression;

import config.EnvLoader;
import factory.UserFactory;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import io.qameta.allure.*;
import utils.LoggerUtil;

@Epic("Login Tests")
@Feature("Invalid Login")
public class AuthTest extends BaseTest {



    @Test(description = "Login with invalid credentials should show error message")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User fails to login")
    public void testLoginWithInvalidCredentials() {
        LoggerUtil.info("Starting test: testLoginWithInvalidCredentials");

        User invalidUser = UserFactory.getInvalidUserFromEnv();
        LoggerUtil.info("Using invalid credentials: " + invalidUser.getEmail() + " / " + invalidUser.getPassword());

        LoggerUtil.info("Verifying home page visibility");
        Assert.assertTrue(homePage.verifyHomePageVisibility(), "Home page is not visible");

        LoggerUtil.info("Clicking on Signup/Login");
        homePage.clickSignupLogin();

        LoggerUtil.info("Checking if 'Login to your account' text is visible");
        Assert.assertTrue(loginPage.isLoginToAccountTextVisible(), "'Login to your account' should be visible");

        LoggerUtil.info("Filling in invalid email and password, then clicking login");
        loginPage
                .setEmail(invalidUser.getEmail())
                .setPassword(invalidUser.getPassword())
                .clickLoginButton();

        LoggerUtil.info("Verifying login error message is visible");
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Error message not shown for invalid login");

        LoggerUtil.info("Completed test: testLoginWithInvalidCredentials");
    }
}
