package QC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Comparator;

public class ProductsPage {
    WebDriver driver;

    By products = By.className("inventory_item");
    By prices = By.className("inventory_item_price");
    By addToCartButtons = By.className("btn_inventory");
    By cartButton = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTwoMostExpensiveItemsToCart() {
        List<WebElement> priceElements = driver.findElements(prices);
        List<WebElement> addButtons = driver.findElements(addToCartButtons);

        // Sort prices in descending order and select top two
        priceElements.stream()
                .sorted((e1, e2) -> Double.compare(
                        Double.parseDouble(e2.getText().replace("$", "")),
                        Double.parseDouble(e1.getText().replace("$", ""))))
                .limit(2)
                .forEach(e -> addButtons.get(priceElements.indexOf(e)).click());
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}

