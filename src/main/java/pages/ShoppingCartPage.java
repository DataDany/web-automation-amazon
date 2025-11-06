package pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.selectors.ShoppingCartPageSelectors;

public class ShoppingCartPage extends ShoppingCartPageSelectors {

    @Step("Check first title contains second in shopping cart")
    public void checkFirstContainSecondTitle(String firstTitle) {
        checkVisibilityOfElement(productTitle);
        String secondTitle = getTextFromWebElement(productTitle);
        Assert.assertTrue(containsAfterTrimDots(firstTitle, secondTitle));
    }

    private boolean containsAfterTrimDots(String firstTitle, String secondTitle) {
        if (firstTitle == null || secondTitle == null) return false;
        String cleaned = secondTitle.replaceAll("[.]+$", "").trim();
        if (cleaned.isEmpty()) return false;
        return firstTitle.toLowerCase().contains(cleaned.toLowerCase());
    }


}
