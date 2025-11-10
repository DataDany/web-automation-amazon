package pages.selectors;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageSelectors extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    protected WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    protected WebElement submitSearch;

    @FindBy(id = "nav-logo-sprites")
    protected WebElement logo;

    @FindBy(id = "nav-cart")
    protected WebElement navCart;

    @FindBy(css= "input[data-action-type='DISMISS']")
    protected WebElement dismissButton;
}
