package QC.utilities.selenium;

import QC.GlobalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class DriverFactory {

    public class BaseTest {
        protected WebDriver driver;

        public void initializeDriver() {
            String browser = GlobalProperties.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}