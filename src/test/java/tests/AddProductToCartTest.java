package tests;

import org.testng.annotations.Test;

import java.util.List;

public class AddProductToCartTest extends BaseTest {

    private final String USB_C_CABEL = "Cards";

    @Test
    public void addProductToCartTestMethod() {

        homePage.openAmazonHomePage();
        homePage.typeItemToSearchTab(USB_C_CABEL);
        homePage.clickSubmitSearchButton();

        List<String> productTitles = searchResultsPage.getProductsNames();
        List<String> productPrices = searchResultsPage.getProductPrices();
        searchResultsPage.shouldReturnNonEmptyProductNames(productTitles);
        searchResultsPage.shouldReturnNonEmptyProductPrices(productPrices);


        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickOnFirstProduct();
        String productsBefore = productPage.getNumberProductsInCart();
        productPage.numberProductsShouldBeZero(productsBefore);
        String quantityNumber = productPage.getQuantityNumber();
        productPage.clickAddToCartButton();
        String productsAfter = productPage.getNumberProductsInCart();
        productPage.numberProductsShouldBeEqual(quantityNumber, productsAfter);
        homePage.clickNavCart();
    }
}
