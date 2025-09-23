package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AmazonSearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    // General locator for all products
    By allProducts = By.cssSelector("div[data-component-type='s-search-result']");
    By productTitleLink = By.cssSelector("h2 a");

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectFirstProduct() {
        try {
            // Wait until at least 1 product is visible
            List<WebElement> products = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(allProducts));

            if (!products.isEmpty()) {
                WebElement firstProduct = products.get(0).findElement(productTitleLink);
                wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
            } else {
                throw new RuntimeException("No products found on search results page!");
            }

        } catch (Exception e) {
            System.out.println("Error selecting first product: " + e.getMessage());
        }
    }

    public boolean areSearchResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProducts));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstProductTitle() {
        try {
            List<WebElement> products = wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(allProducts));

            if (!products.isEmpty()) {
                WebElement titleElement = products.get(0).findElement(productTitleLink);
                return titleElement.getText();
            } else {
                return "No product title found";
            }

        } catch (Exception e) {
            return "Unable to get product title: " + e.getMessage();
        }
    }
}
