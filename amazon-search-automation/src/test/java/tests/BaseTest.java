package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;

public class BaseTest {
    protected WebDriver driver;
    protected AmazonHomePage homePage;
    protected AmazonSearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        // Chrome options for better stability
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Navigate to Amazon India
        driver.get("https://www.amazon.in/");
        
        // Initialize page objects
        homePage = new AmazonHomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}