package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

public abstract class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected ProductPage productPage;
    protected ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.get();
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quit();
    }
}
