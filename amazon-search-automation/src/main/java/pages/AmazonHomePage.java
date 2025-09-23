package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators using exact CSS selectors as per requirements
    By searchBox = By.cssSelector("#twotabsearchtextbox");           // CSS ID
    By searchButton = By.cssSelector("input[value='Go']");          // CSS Attribute

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchForProduct(String productName) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchField.clear();
        searchField.sendKeys(productName);
    }

    public void clickSearchButton() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

    // Combined method for convenience
    public void searchProduct(String productName) {
        searchForProduct(productName);
        clickSearchButton();
    }
}