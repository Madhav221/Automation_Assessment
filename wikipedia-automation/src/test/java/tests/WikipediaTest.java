package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WikipediaHomePage;

public class WikipediaTest {
    WebDriver driver;
    WikipediaHomePage homePage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        homePage = new WikipediaHomePage(driver);
    }

    @Test
    public void testWikipediaNavigation() {
        // Step 1: Click English
        homePage.clickEnglish();
        Assert.assertTrue(driver.getTitle().contains("Wikipedia"), "Failed to open English Wikipedia");

        // Step 2: Click Privacy Policy
        homePage.clickPrivacyPolicy();
        Assert.assertTrue(driver.getTitle().contains("Privacy"), "Failed to open Privacy Policy page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
