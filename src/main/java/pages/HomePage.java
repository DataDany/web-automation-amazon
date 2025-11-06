package pages;

import config.TestConfig;
import io.qameta.allure.Step;
import pages.selectors.HomePageSelectors;

public class HomePage extends HomePageSelectors {

    @Step("Open amazon home page")
    public void openAmazonHomePage() {
        driver.get(TestConfig.baseUrl());
    }

    @Step("Click search")
    public void clickSearch() {
        checkVisibilityOfElement(searchInput);
        clickElement(searchInput);
    }

    @Step("Click cart on navbar")
    public void clickNavCart() {
        checkVisibilityOfElement(navCart);
        clickElement(navCart);
    }

    @Step("Click logo")
    public void clickLogo() {
        checkVisibilityOfElement(logo);
        clickElement(logo);
    }

    @Step("Type product to searchbar")
    public void typeItemToSearchTab(String itemName) {
        type(searchInput, itemName);
    }

    @Step("Click submit button")
    public void clickSubmitSearchButton() {
        clickElement(submitSearch);
    }
}
