package tests.regression;

import config.EnvLoader;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;


public class AuthTest extends BaseTest {

    @Test
    public void testLoginWithInvalidCredentials() {
        String invalidEmail = EnvLoader.getProperty("user.email");
        String invalidPassword = "Wrong" + EnvLoader.getProperty("user.password");

        User invalidUser = new User(invalidEmail, invalidPassword);

        Assert.assertTrue(homePage.verifyHomePageVisibility());

        homePage.clickSignupLogin();

        Assert.assertTrue(loginPage.isLoginToAccountTextVisible(), "'Login to your account' should be visible");

        loginPage
                .setEmail(invalidUser.getEmail())
                .setPassword(invalidUser.getPassword())
                .clickLoginButton();

        Assert.assertTrue(loginPage.isLoginErrorVisible(), "Error message not shown for invalid login");
    }
}
