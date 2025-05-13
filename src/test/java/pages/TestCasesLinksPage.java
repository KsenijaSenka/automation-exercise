package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesLinksPage extends BasePage{
    public TestCasesLinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(linkText = "Test Cases")
    WebElement testCasesLink;

    public void clickTestCasesLink() {
        testCasesLink.click();
    }
}
