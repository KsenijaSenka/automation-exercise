package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".product-information h2")
    WebElement productName;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public boolean isOnPage() {
        return driver.getCurrentUrl().contains("product_details");
    }

    public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }
}