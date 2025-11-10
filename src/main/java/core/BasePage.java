package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
    }

    protected void type(WebElement el, String text) {
        wait.until(ExpectedConditions.visibilityOf(el)).clear();
        el.sendKeys(text);
    }

    protected void checkVisibilityOfElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void checkVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean existCheck(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    protected boolean exists(WebElement parent, By locator) {
        return !parent.findElements(locator).isEmpty();
    }

    protected WebElement getFirstElement(List<WebElement> elements) {
        checkVisibilityOfElements(elements);
        return elements.getFirst();
    }

    protected String getTextFromWebElement(WebElement element) {
        return element.getText().trim();
    }

    protected By getElementByCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }
}
