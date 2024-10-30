package QC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    WebDriver driver;

    By cartItems = By.className("cart_item");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifySelectedProducts() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() == 2; // Expecting exactly two items in the cart
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}

