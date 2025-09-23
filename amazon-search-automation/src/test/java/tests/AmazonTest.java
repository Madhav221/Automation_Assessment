package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazonLaptopSearch() {
        System.out.println("Starting Amazon laptop search test...");

        // Step 1: Enter "Laptop" into the search box
        System.out.println("Searching for 'Laptop'...");
        homePage.searchForProduct("Laptop");

        // Step 2: Click search button
        System.out.println("Clicking search button...");
        homePage.clickSearchButton();

        // Step 3: Verify search results are displayed
        System.out.println("Verifying search results...");
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(),
                "Search results are not displayed");

        // Step 4: Get and print first product title
        System.out.println("Selecting first product...");
        String firstProductTitle = searchResultsPage.getFirstProductTitle();
        System.out.println("First product title: " + firstProductTitle);

        // Step 5: Click first product
        searchResultsPage.selectFirstProduct();

        // Step 6: Verify we navigated to a product page on Amazon
        System.out.println("Current URL after clicking: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.in"),
                "Should remain on Amazon domain");

        System.out.println("Test completed successfully!");
    }

    @Test
    public void testSearchFunctionality() {
        System.out.println("Testing search functionality...");

        // Step 1: Enter "Laptop" into the search box
        homePage.searchForProduct("Laptop");

        // Step 2: Click search button
        homePage.clickSearchButton();

        // Step 3: Verify search URL contains "k=Laptop"
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Search URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("k=Laptop"),
                "Search URL should contain the search term");

        // Step 4: Verify results are displayed
        Assert.assertTrue(searchResultsPage.areSearchResultsDisplayed(),
                "Search results should be displayed after search");

        System.out.println("Search functionality test completed!");
    }
}
