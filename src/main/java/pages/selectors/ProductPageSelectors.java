package pages.selectors;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageSelectors extends BasePage {

    @FindBy(css = "input#add-to-cart-button")
    protected WebElement addToCartButton;

    @FindBy(css = "span#nav-cart-count")
    protected WebElement cartCount;

    @FindBy(css = "#selectQuantity span.a-dropdown-prompt")
    protected WebElement quantityNumber;
}
