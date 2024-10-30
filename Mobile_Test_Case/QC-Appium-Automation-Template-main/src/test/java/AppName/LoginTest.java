package AppName;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    private AndroidDriver driver;
        @Test(priority = 1)
        public void testPositiveLogin() {
            WebElement usernameField = (WebElement) driver.findElements(By.id("test-Username"));
            WebElement passwordField = (WebElement) driver.findElements(By.id("test-Password"));
            WebElement loginButton = (WebElement) driver.findElements(By.id("test-LOGIN"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();

            // Assert successful login
            WebElement homePageElement = (WebElement) driver.findElements(By.id("test-InventoryItem"));
            Assert.assertTrue(homePageElement.isDisplayed(), "Login failed: Home page element not found.");
        }

        @Test(priority = 2)
        public void testNegativeLogin() {
            WebElement usernameField = (WebElement) driver.findElements(By.id("test-Username"));
            WebElement passwordField = (WebElement) driver.findElements(By.id("test-Password"));
            WebElement loginButton = (WebElement) driver.findElements(By.id("test-LOGIN"));

            usernameField.clear();
            passwordField.clear();
            usernameField.sendKeys("locked_out_user"); // Incorrect username for negative test
            passwordField.sendKeys("wrong_password"); // Incorrect password for negative test
            loginButton.click();

            // Assert failed login by verifying error message
            WebElement errorMessage = (WebElement) driver.findElements(By.id("test-Error message"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Negative login test failed: Error message not displayed.");
        }

    }

