package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class SearchSteps extends BaseSteps {

    protected String firstProductTitle;

    @Given("I open the amazon home page")
    public void i_open_the_amazon_home_page() {
        homePage.openAmazonHomePage();
        homePage.clickLogo();
    }

    @When("I search for cards")
    public void i_search_for() {
        homePage.typeItemToSearchTab(CARDS);
        homePage.clickSubmitSearchButton();
    }

    @Then("I should see non-empty product names and prices and counts match")
    public void i_should_see_non_empty_product_names_prices_and_counts_match() {
        List<String> names = searchResultsPage.getProductNames();
        List<String> prices = searchResultsPage.getProductPrices();
        searchResultsPage.shouldReturnNonEmptyProductNames(names);
        searchResultsPage.shouldReturnNonEmptyProductPrices(prices);
    }

    @When("I open the first product from results")
    public void i_open_the_first_product_from_results() {
        firstProductTitle = searchResultsPage.getFirstProductTitle();
        searchResultsPage.clickOnFirstProduct();
    }

    @Then("The cart should contain that product")
    public void the_cart_should_contain_that_product() {
        String productsBefore = productPage.getNumberProductsInCart();
        productPage.numberProductsShouldBeZero(productsBefore);
        String quantityNumber = productPage.getQuantityNumber();
        productPage.clickAddToCartButton();
        String productsAfter = productPage.getNumberProductsInCart();
        productPage.numberProductsShouldBeEqual(quantityNumber, productsAfter);
        homePage.clickNavCart();
        shoppingCartPage.checkFirstContainSecondTitle(firstProductTitle);
    }
}
