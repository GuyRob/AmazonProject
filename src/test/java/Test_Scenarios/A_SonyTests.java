package Test_Scenarios;

import Objects.AmazonNavigation;
import Objects.AmazonProductListPage;
import Objects.AmazonProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *                                          Amazon Web
 *    • Page Object Model - working with objects instead of find elements on tests
 *
 *    Sony Tests:
 *
 *    Tests:
 *      0. Searching for "Sony" product on amazon web, clicking, and checking the search result
 *      1. filter by ShipLocal
 *      2. filter by Electronics
 *      3. filter by CustomerReview 4 stars
 *      4. Select first product
 *      5. Select color
 *      6. Select product image
 *      7. See all buy options
 *      8. Add to cart
 *
 *
 *
 *      TODO:
 *      1. Use cssSelector instead of xpath - V
 *      2. change name of functions to more specific - V
 *      3. Log before every function - need to check about loggers, will use on next project
 *      4. wait instead of Thread.sleep - Not working - tried with driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); - not waiting
 *      5. Check about HashMap
 */
public class A_SonyTests {
    WebDriver driver;

    @BeforeTest
    public void BeforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
    }

    @AfterTest
    public void AfterTest() {
        // try & catch to avoid adding throw exception on public line
        try {
            // Wait time before closing
            Thread.sleep(1000); // Wait Time
            driver.quit();

        } catch (Exception e) {
            System.out.println("Exceptions Caught" + e.getMessage());
        }

    }

    /**Tests:*/
    @Test(priority = 0) //Test 0
    // Homepage to "Sony" search
    public void searchSony() {
        // Actions
        AmazonNavigation navigation = new AmazonNavigation(driver); // Object
        navigation.search("Sony");

        // Tests
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        Assert.assertEquals(ProductListPage.searchResults_GetText(), "Sony"); // 1. search result text
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "1-16 of over 8,000 results for"); // 2. search result summary
    }

    @Test(priority = 1) //Test 1
    // Filter ship local - Please notice that sometimes filter not appears
    public void filter_ShipLocal() {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_ShipLocally_click();

        // Tests
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "14 results for"); // 1. Checking total results
        Assert.assertTrue(ProductListPage.filter_ShipLocally_isSelected()); // 2. Checking filter ship locally selected
    }

    @Test(priority = 2) //Test 2
    // Filter ship local - Please notice that sometimes filter not appears
    public void filter_Electronics() {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_Department_Electronics_click();

        // Tests
        Assert.assertTrue(ProductListPage.filter_AnyDepartment_isDisplayed()); // 1. Checking if Any Department button appears
    }

    @Test(priority = 3) // Test 3
    // Filter customer review, 4 stars and up (Filter not saved on Amazon site
    public void filter_CustomerReview_4 () {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_CustomerReview_SelectStarsByNum(4);

        // Tests
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "10 results for"); // 1. Checking if searched result has been updated after selecting 4 stars
    }

    @Test (priority = 4) // Test 4
    // Selecting the first product
    public void product_SelectFirst(){
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.product_ClickById(1);

        // Tests
        /* Currently selected product is: (may changed)
            Product: Sony SRS-XB13 Extra BASS Wireless Bluetooth Portable Lightweight Compact Travel Speaker, IP67 Waterproof & Durable for Outdoor, 16 Hour Battery, USB Type-C, Removable Strap, and Speakerphone, Black
            URL: https://www.amazon.com/Sony-SRS-XB13-Waterproof-Bluetooth-SRSXB13/dp/B08ZJ6DQNY/ref=sr_1_1?keywords=Sony&qid=1657562381&refinements=p_n_is_country_local%3A17964664011%2Cp_72%3A1248879011%2Cp_n_deal_type%3A23566065011&rnid=23566063011&s=electronics&sr=1-1
        */
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object

        // String initial
        String expectedProduct = "Sony SRS-XB13 EXTRA BASS Wireless Bluetooth Portable Lightweight Compact Travel Speaker, IP67 Waterproof & Durable for Outdoor, 16 Hour Battery, USB Type-C, Removable Strap, & Speakerphone, Coral Pink";
        expectedProduct = expectedProduct.toLowerCase();
        String actualProduct = ProductPage.title_GetText_toLowerCase();

        // String substring
        int substringAt = 20;
        expectedProduct = expectedProduct.substring(0, substringAt);
        actualProduct = actualProduct.substring(0, substringAt);

        Assert.assertEquals(actualProduct, expectedProduct); // 1. Checking if the title of the selected product matches
    }

    @Test (priority = 5) // Test 5
    // Selecting product color
    public void product_ColorBlue(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.color_ClickByName("Light Blue");
        // Tests
        Assert.assertEquals(ProductPage.color_Selected(), "Light Blue"); // 1. Validating selected color
    }

    @Test (priority = 6) // Test 6
    // Selecting product image
    public void product_image_6(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.imgvid_ClickById(3);
    }

    @Test (priority = 7) // Test 7
    // Selecting "See All Buying Options"
    public void product_AllBuyOptions(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.purchase_AllBuyOptions();
    }

    @Test (priority = 8) // Test 8
    // Adding product to cart
    public void product_AddToCart(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.purchase_AddToCart_ByID(1);
    }

} // End of class
