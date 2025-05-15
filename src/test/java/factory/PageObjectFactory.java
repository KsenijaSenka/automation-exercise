package factory;

import org.openqa.selenium.WebDriver;
import pages.TestCasesLinksPage;
import pages.decorators.RetryTestCasesLinksPageDecorator;

public class PageObjectFactory {
    public static TestCasesLinksPage getTestCasesLinksPage(WebDriver driver) {
        return new RetryTestCasesLinksPageDecorator(driver, 3);
    }
}
