package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signupLoginBtn;

//    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
//    WebElement loggedInAs;

//    @FindBy(xpath = "//a[text()=' Delete Account']")
//    WebElement deleteAccountBtn;

    @FindBy(xpath = "//a[text()=' Products']")
    WebElement productsBtn;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public boolean isOnPage() {
        return signupLoginBtn.isDisplayed();
    }

    public void clickSignupLogin() {
        signupLoginBtn.click();
    }

//    public boolean isLoggedInAsVisible() {
//        return loggedInAs.isDisplayed();
//    }

    //public void clickDeleteAccount() {
      //  deleteAccountBtn.click();
    //}



    public boolean verifyHomePageVisibility() {
        return signupLoginBtn.isDisplayed();
    }

    public void clickProductsButton() {
        productsBtn.click();
    }


}
