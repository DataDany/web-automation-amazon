package pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.selectors.ProductPageSelectors;

public class ProductPage extends ProductPageSelectors {

    private final String ZERO_CART = "0";

    @Step("Click add to cart button")
    public void clickAddToCartButton() {
        checkVisibilityOfElement(addToCartButton);
        clickElement(addToCartButton);
    }

    @Step("Get quantity number")
    public String getQuantityNumber() {
        return getTextFromWebElement(quantityNumber);
    }

    @Step("Get number products in cart")
    public String getNumberProductsInCart() {
        return getTextFromWebElement(cartCount);
    }

    @Step("Number products should be zero")
    public void numberProductsShouldBeZero(String beforeAddToCart) {
        Assert.assertEquals(beforeAddToCart, ZERO_CART);
    }

    @Step("Number of products should be equal with products in cart")
    public void numberProductsShouldBeEqual(String afterAddToCart, String quantityNumber) {
        Assert.assertEquals(afterAddToCart, quantityNumber);
    }
}
