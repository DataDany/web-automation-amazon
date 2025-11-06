package stepdefinitions;

import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class BaseSteps {
    protected String CARDS= "cards";
    protected HomePage homePage = new HomePage();
    protected SearchResultsPage searchResultsPage = new SearchResultsPage();
    protected ProductPage productPage = new ProductPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
}
