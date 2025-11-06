package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public class BaseSteps {
    protected String LAPTOP= "cards";
    protected HomePage homePage = new HomePage();
    protected SearchResultsPage searchResultsPage = new SearchResultsPage();
    protected ProductPage productPage = new ProductPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
}
