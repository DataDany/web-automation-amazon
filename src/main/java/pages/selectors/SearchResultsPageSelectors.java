package pages.selectors;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPageSelectors extends BasePage {

    @FindBy(css = "div[role='listitem']")
    protected List<WebElement> productCards;

    @FindBy(css = "div[role='listitem'] h2 span")
    protected List<WebElement> productCardsTitles;

    @FindBy(css = "div[role='listitem'] a > span.a-price ")
    protected List<WebElement> prices;

    @FindBy(css = "div[role='listitem'] a > span.a-price span.a-price-symbol")
    protected List<WebElement> priceSymbol;

    @FindBy(css = "div[role='listitem'] a > span.a-price span.a-price-whole")
    protected List<WebElement> priceMainNumber;

    @FindBy(css = "div[role='listitem'] a > span.a-price span.a-price-fraction")
    protected List<WebElement> priceFraction;

}
