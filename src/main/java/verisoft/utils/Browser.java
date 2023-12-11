package verisoft.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * A utility class for managing the web browser instance.
 */
public class Browser {

    private static Browser instance;
    private WebDriver driver;

    /**
     * Private constructor to initialize the browser instance.
     *
     * @param browserType The type of browser to be used (e.g., "chrome").
     * @throws RuntimeException if an unknown browser type is provided.
     */
    private Browser(String browserType) {
        if (browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
           EdgeOptions options = new EdgeOptions();

            this.driver = new EdgeDriver(options);
        }
        else
            throw new RuntimeException("Unknown browserType {" + browserType + "}");
    }

    /**
     * Get the instance of the browser using the singleton design pattern.
     *
     * @param browserType The type of browser to be used (e.g., "chrome").
     * @return The browser instance.
     */
    public static synchronized Browser getInstance(String browserType) {
        if (instance == null) {
            instance = new Browser(browserType);
        }
        return instance;
    }

    /**
     * Quit the WebDriver and close the browser.
     */
    public void quitDriver(){
        driver.quit();
    }

    /**
     * Navigate to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * Find a web element using the provided By locator.
     *
     * @param by The By locator to find the element.
     * @return The WebElement found using the locator.
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
