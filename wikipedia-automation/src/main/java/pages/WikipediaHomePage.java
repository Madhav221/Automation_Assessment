package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WikipediaHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Simple locators
    By englishLink = By.xpath("//a[contains(@href, 'en.wikipedia.org')]");
    By privacyPolicyLink = By.xpath("//a[contains(@href, 'privacy') or contains(text(), 'Privacy')]");

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickEnglish() {
        WebElement english = wait.until(ExpectedConditions.elementToBeClickable(englishLink));
        english.click();
    }

    public void clickPrivacyPolicy() {
        WebElement privacy = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink));
        privacy.click();
    }
}