package QC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    WebDriver driver;

    By itemTotalLabel = By.className("summary_subtotal_label");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public double calculateExpectedTotal() {
        // Calculate expected total based on known item prices (you can adjust this as needed)
        double firstItemPrice = 49.99; // Replace with actual item price as appropriate
        double secondItemPrice = 39.99; // Replace with actual item price as appropriate
        return firstItemPrice + secondItemPrice;
    }

    public double getActualTotal() {
        String totalText = driver.findElement(itemTotalLabel).getText().replace("Item total: $", "");
        return Double.parseDouble(totalText);
    }
}

