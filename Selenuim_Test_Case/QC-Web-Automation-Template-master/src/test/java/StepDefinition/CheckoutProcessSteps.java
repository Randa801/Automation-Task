package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutProcessSteps {
    WebDriver driver;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with valid credentials {string} and {string}")
    public void i_login_with_valid_credentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be navigated to the products page")
    public void i_should_be_navigated_to_the_products_page() {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @And("I add the two most expensive products to the cart")
    public void i_add_the_two_most_expensive_products_to_the_cart() {
        driver.findElements(By.className("btn_inventory")).get(0).click();
        driver.findElements(By.className("btn_inventory")).get(3).click();
    }

    @When("I open the cart")
    public void i_open_the_cart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("I should see the selected products")
    public void i_should_see_the_selected_products() {
        assertEquals(2, driver.findElements(By.className("cart_item")).size());
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("I should be on the checkout page")
    public void i_should_be_on_the_checkout_page() {
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
    }

    @When("I fill the checkout form with {string} {string} and {string}")
    public void i_fill_the_checkout_form_with(String firstName, String lastName, String zipCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }

    @And("I continue to the overview page")
    public void i_continue_to_the_overview_page() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("I should see the correct total amount before taxes")
    public void i_should_see_the_correct_total_amount_before_taxes() {
        // Add logic to capture and verify total amount
    }

    @Then("I should be on the URL {string}")
    public void i_should_be_on_the_url(String url) {
        assertEquals(url, driver.getCurrentUrl());
    }

    @When("I finish the order")
    public void i_finish_the_order() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {
        assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.className("complete-header")).getText());
        driver.quit();
    }
}

