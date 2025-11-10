package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.selectors.SearchResultsPageSelectors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

public class SearchResultsPage extends SearchResultsPageSelectors {

    private final String ADD_TO_CART_SELECTOR = "button[name='submit.addToCart']";
    private final String CARD_TITLE_SELECTOR = "div[role='listitem'] h2 span";

    @Step("Should return non empty product names")
    public void shouldReturnNonEmptyProductNames(List<String> titles) {
        assertFalse(titles.isEmpty(), "Empty names list");
        assertTrue(titles.stream().allMatch(s -> s != null && !s.isBlank()), "Empty names");
    }

    @Step("Should return non empty product prices")
    public void shouldReturnNonEmptyProductPrices(List<String> prices) {
        assertFalse(prices.isEmpty(), "Empty prices list");
        assertTrue(prices.stream().allMatch(s -> s != null && !s.isBlank()), "Empty prices");
    }

    @Step("Names and prices counts should match")
    public void namesAndPricesCountsShouldMatch(List<String> titles, List<String> prices) {
        System.out.println(prices.size() + " " + titles.size());
        assertEquals(prices.size(), titles.size(), "Difference between prices and titles");
    }

    @Step("Get product names")
    public List<String> getProductNames() {
        checkVisibilityOfElements(productCardsTitles);
        List<String> names = new ArrayList<>(productCardsTitles.size());
        productCardsTitles.forEach(el -> {
            String txt = el.getText().trim();
            if (!txt.isEmpty()) names.add(txt);
        });
        return names;
    }

    @Step("Get product prices")
    public List<String> getProductPrices() {
        checkVisibilityOfElements(prices);
        List<String> proPrices = new ArrayList<>(prices.size());
        AtomicInteger idx = new AtomicInteger(0);
        prices.forEach(e -> {
            String price = createPrice(idx.getAndIncrement());
            proPrices.add(price);
        });
        return proPrices;
    }

    @Step("Click first title with add to cart button")
    public String clickFirstTitleWithAddToCartButton() {
        for (WebElement card : productCardContainers) {
            if (!exists(card, getElementByCSS(ADD_TO_CART_SELECTOR))) continue;

            WebElement title = card.findElement(getElementByCSS(CARD_TITLE_SELECTOR));
            checkVisibilityOfElement(title);
            String titleText = getTextFromWebElement(title);
            clickElement(title);
            return titleText;
        }
        throw new NoSuchElementException("Can't find card with add to cart button.");
    }

    @Step("Get first product title")
    public String getFirstProductTitle() {
        return getTextFromWebElement(getFirstElement(productCardsTitles));
    }

    @Step("Click on first product")
    public void clickOnFirstProduct() {
        checkVisibilityOfElement(getFirstElement(productCardsTitles));
        clickElement(getFirstElement(productCardsTitles));
    }

    private String createPrice(int number) {
        String symbol = getTextFromWebElement(priceSymbol.get(number));
        String whole = getTextFromWebElement(priceMainNumber.get(number));
        String frac = getTextFromWebElement(priceFraction.get(number));

        return frac.isEmpty()
                ? symbol + whole
                : symbol + whole + "." + frac;
    }

}
