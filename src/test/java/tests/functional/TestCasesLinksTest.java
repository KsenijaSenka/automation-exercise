package tests.functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.LoggerUtil;

public class TestCasesLinksTest extends BaseTest {

    @Test
    public void testClickTestCasesLink() {
        LoggerUtil.info("Starting test: testClickTestCasesLink");

        LoggerUtil.info("Clicking on 'Test Cases' link");
        testCasesLinksPage.clickTestCasesLink();

        LoggerUtil.info("Verifying navigation to the 'Test Cases' page");
        Assert.assertTrue(
                testCasesLinksPage.isOnPage(),
                "Not navigated to the Test Cases page."
        );
        LoggerUtil.info("Test passed: testClickTestCasesLink");
    }
}
