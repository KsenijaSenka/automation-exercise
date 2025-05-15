package pages.decorators;

import org.openqa.selenium.WebDriver;
import pages.TestCasesLinksPage;

public class RetryTestCasesLinksPageDecorator extends TestCasesLinksPage {
    private final int maxRetries;

    public RetryTestCasesLinksPageDecorator(WebDriver driver, int maxRetries) {
        super(driver);
        this.maxRetries = maxRetries;
    }

    private void retry(Runnable action) {
        int attempts = 0;
        while (true) {
            try {
                action.run();
                return; // success
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) {
                    throw e;
                }
                System.out.println("Retry attempt " + attempts + " due to: " + e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(ie);
                }
            }
        }
    }

    @Override
    public void clickTestCasesLink() {
        retry(() -> super.clickTestCasesLink());
    }
}

