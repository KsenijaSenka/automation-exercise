package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//*[text()='Login to your account']")
    private WebElement loginToAccountText;

    @FindBy(css = "[data-qa='login-email']")
    WebElement loginEmailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(css = "[data-qa='login-button']")
    WebElement loginButton;

    @FindBy(name = "name")
    WebElement signupNameInput;

    @FindBy(css = "[data-qa='signup-email']")
    WebElement signupEmailInput;

    @FindBy(linkText = "Signup")
    WebElement signupButton;

    @FindBy(linkText = "Create Account")
    WebElement createAccountButton;

    public LoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(this.driver, this);
    }

    public boolean isLoginToAccountTextVisible() {
        try {
            return loginToAccountText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isLoginErrorVisible() {
        try {
            return loginErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


//    public void login(String email, String password) {
//
//        loginEmailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        waitForVisibility(loginButton);
//        loginButton.click();
//    }

    public void enterSignupDetails(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
    }

    public LoginPage setEmail(String email) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

}

