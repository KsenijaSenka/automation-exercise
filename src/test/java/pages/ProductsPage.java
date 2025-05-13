package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    WebElement allProductsHeader;

    @FindBy(css = ".product-image-wrapper")
    By productImageWrappers;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    WebElement firstProductViewLink;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartFirstButton;

    @FindBy(css = "a[data-product-id='2']")
    WebElement addToCartSecondButton;

    @FindBy(css = "[data-qa='continue-shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "(//a[text()='View Product'])[2]")
    WebElement secondProduct;

    @FindBy(css = "[data-qa='view-cart']")
    WebElement viewCartButton;
    @FindBy(css = "div.product:nth-child(1)")
    private WebElement firstProductCard;

    public void clickProduct(String productName) {
        WebElement productLink = driver.findElement(By.linkText(productName));
        waitForClickable(productLink);
        productLink.click();
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("[data-qa='add-to-cart']"));
        waitForClickable(addToCartButton);
        addToCartButton.click();
    }

    public boolean isProductsPageVisible() {
        return allProductsHeader.isDisplayed();
    }

    public boolean isProductListVisible() {
        try {
            List<WebElement> productNames = driver.findElements(By.cssSelector(".productinfo.text-center p"));
            return productNames.size() > 0 && !productNames.get(0).getText().trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstViewProduct() {
        firstProductViewLink.click();
    }

    public void clickAddToCartOnFirstProduct() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartFirstButton);
        waitForClickable(addToCartFirstButton);
        addToCartFirstButton.click();
    }

    public void clickContinueShoppingButton() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueShoppingButton);
        waitForVisibility(continueShoppingButton);
        waitForClickable(continueShoppingButton);
        continueShoppingButton.click();
    }

    public void getSecondProductView() {;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondProduct);
        waitForClickable(secondProduct);
        secondProduct.click();
    }

    public void clickAddToCartOnSecondProduct() {
        waitForClickable(addToCartSecondButton);
        addToCartSecondButton.click();
    }

    public void clickViewCartButton() {
        waitForClickable(viewCartButton);
        viewCartButton.click();
    }

    public WebElement getFirstProduct() {
        return addToCartFirstButton;
    }
    public void hoverAndAddToCartFirstProduct() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartFirstButton).perform();
        actions.click();
    }
    public WebElement getSecondProduct(){
        return addToCartSecondButton;
    }
}
