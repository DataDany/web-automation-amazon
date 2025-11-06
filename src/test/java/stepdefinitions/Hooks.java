package stepdefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void afterScenario() {
        DriverFactory.quitDriver();
    }
}
