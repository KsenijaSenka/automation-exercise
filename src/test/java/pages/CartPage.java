package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Cart')]")
    WebElement cartTitle;

    @FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "tr.cart_product img")
    private List<WebElement> productImages;

    public boolean isCartTitleVisible() {
        return cartTitle.isDisplayed();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public boolean hasTwoProductImages() {
        return productImages.size() == 2;
    }
}
