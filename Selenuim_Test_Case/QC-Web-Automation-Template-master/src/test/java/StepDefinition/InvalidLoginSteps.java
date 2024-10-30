package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidLoginSteps {
    WebDriver driver;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter invalid credentials {string} and {string}")
    public void i_enter_invalid_credentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        String actualMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessage, actualMessage);
        driver.quit();
    }
}

