package pages.selectors;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageSelectors extends BasePage {

    @FindBy(css = "span.a-truncate-cut")
    protected WebElement productTitle;

}
