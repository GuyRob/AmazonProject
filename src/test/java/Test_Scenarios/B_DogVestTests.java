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
 *         Dog Vest Tests:
 *
 *    Tests:
 *      0. Searching for "Dog" product on amazon web, clicking, and checking the search result
 *      1. Selecting Department - Dog Supplies
 *      2. Select price up to $25
 *      3. Finding by text - "Vest" and clicking the first product
 *      4. Selecting product color
 *      5. View image by id
 *      6. Add to cart
 */
public class B_DogVestTests {
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

    /** Tests:*/
    @Test(priority = 0) //Test 0
    // Homepage to "Dog" search
    public void searchDog() {
        // Actions
        AmazonNavigation navigation = new AmazonNavigation(driver); // Object
        navigation.search("Dog");

        // Tests
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        Assert.assertEquals(ProductListPage.searchResults_GetText(), "Dog"); // 1. search result text
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "1-16 of over 100,000 results for"); // 2. search result summary
    }

    @Test(priority = 1) //Test 1
    // Filter dog supplies
    public void filter_DogSupplies() {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_Department_DogSupplies_click();

        // Tests
        Assert.assertEquals(ProductListPage.searchResults_Summary(), "1-24 of over 50,000 results for"); // 1. Checking total results
        Assert.assertTrue(ProductListPage.filter_AnyDepartment_isDisplayed()); // 1. Checking if Any Department button appears
    }

    @Test(priority = 2) //Test 2
    // Filter price up to 25
    public void filter_Price_Upto25() {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.filter_price_clickByText("Up to $25");

        // Tests
        Assert.assertTrue(ProductListPage.filter_AnyPrice_isDisplayed()); // 1. Checking if Any Price button appears
    }

    @Test(priority = 3) // Test 3
    // Selecting product by "Vest" text
    public void product_SelectVest() {
        AmazonProductListPage ProductListPage = new AmazonProductListPage(driver); // Object
        ProductListPage.product_Click_FirstByText("Vest");

        // Tests
        /* Currently selected product is: (may changed)
            Product: PHOEPET No Pull Dog Harness Medium Reflective Front Clip Vest with Handle,Adjustable 2 Metal Rings 3 Buckles,[Easy to Put on & Take Off](M, Orange)
            URL: https://www.amazon.com/PHOEPET-Harness-Reflective-Adjustable-Buckles/dp/B07GVCFQV6/ref=sr_1_9?crid=37KGVBN2UQOYV&keywords=Dog&qid=1659120957&refinements=p_36%3A2661612011&rnid=2661611011&s=pet-supplies&sprefix=dog%2Caps%2C885&sr=1-9&th=1
        */
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object

        // String initial
        String expectedProduct = "PHOEPET No Pull Dog Harness Medium Reflective Front Clip Vest with Handle,Adjustable 2 Metal Rings 3 Buckles,[Easy to Put on & Take Off](M, Orange)";
        expectedProduct = expectedProduct.toLowerCase();
        String actualProduct = ProductPage.title_GetText_toLowerCase();

        // String substring
        int substringAt = 20;
        expectedProduct = expectedProduct.substring(0, substringAt);
        actualProduct = actualProduct.substring(0, substringAt);

        Assert.assertEquals(actualProduct, expectedProduct); // 1. Checking if the title of the selected product matches
    }


    @Test (priority = 4) // Test 4
    // Selecting product color
    public void product_ColorBlue(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.color_ClickByName("Red");
        // Tests
        Assert.assertEquals(ProductPage.color_Selected(), "Red"); // 1. Validating selected color
    }

    @Test (priority = 5) // Test 5
    // Selecting product image
    public void product_imgage_6(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.imgvid_ClickById(3);
    }

    @Test (priority = 6) // Test 6
    // Adding product to cart
    public void product_AddToCart(){
        AmazonProductPage ProductPage = new AmazonProductPage(driver); // Object
        ProductPage.purchase_AddToCart_ByID(1);
    }

} // End of class
