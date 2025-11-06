package tests;

import org.testng.annotations.Test;

import java.util.List;

public class ExampleTest extends BaseTest {

    private final String LAPTOP = "ball";

    @Test
    public void exampleMethodTest() {

        homePage.openAmazonHomePage();
        homePage.clickLogo();
        homePage.typeItemToSearchTab(LAPTOP);
        homePage.clickSubmitSearchButton();
        List<String> productTitles = searchResultsPage.getProductsNames();
        List<String> productPrices = searchResultsPage.getProductPrices();
        searchResultsPage.shouldReturnNonEmptyProductNames(productTitles);
        searchResultsPage.shouldReturnNonEmptyProductPrices(productPrices);
        searchResultsPage.namesAndPricesCountsShouldMatch(productTitles, productPrices);

    }
}

