package tests.smoke;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import tests.base.BaseTest;
import utils.TestListener;

import static driver.DriverFactory.getDriver;

@Listeners(TestListener.class)
public class ProductDetailPageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ProductDetailPageTest.class);

    @Test
    public void verifyAllProductsAndProductDetailPage() {
        logger.info("Starting test: verifyAllProductsAndProductDetailPage");
        HomePage homePage = new HomePage(getDriver());

        Assert.assertTrue(homePage.verifyHomePageVisibility(), "Home page is not visible");
        logger.info("Clicking on 'Products' button");
        homePage.clickProductsButton();

        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.isProductsPageVisible(), "ALL PRODUCTS page is not visible");

        Assert.assertTrue(productsPage.isProductListVisible(), "Product list is not visible");

        productsPage.clickFirstViewProduct();

        ProductDetailPage detailPage = new ProductDetailPage(getDriver());
        Assert.assertTrue(detailPage.isProductNameVisible(), "Product name is not visible");
//        Assert.assertTrue(detailPage.isCategoryVisible(), "Product category is not visible");
//        Assert.assertTrue(detailPage.isPriceVisible(), "Product price is not visible");
//        Assert.assertTrue(detailPage.isAvailabilityVisible(), "Availability is not visible");
//        Assert.assertTrue(detailPage.isConditionVisible(), "Product condition is not visible");
//        Assert.assertTrue(detailPage.isBrandVisible(), "Product brand is not visible");
    }
}
