package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver get() {
        if (TL.get() == null) {
            ChromeOptions options = new ChromeOptions();
            TL.set(new ChromeDriver(options));
            TL.get().manage().window().maximize();
        }
        return TL.get();
    }

    public static void quit() {
        WebDriver drv = TL.get();
        if (drv != null) {
            drv.quit();
            TL.remove();
        }
    }
}
