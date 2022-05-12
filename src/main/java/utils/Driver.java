package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public static WebDriver getDriver() {
        return getDriver(Browser.CHROME);
    }


    public static WebDriver getDriver(Browser browser) {

        if (driver == null) {

            switch (browser) {

                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

        }
        return driver;
    }

    public static void quitDriver() {
        if ((driver != null)) {
            driver.quit();
            driver= null;
        }
    }
}
